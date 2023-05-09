package com.teamproject.devTalks.service.implement.user;

import com.teamproject.devTalks.common.util.CustomResponse;
import com.teamproject.devTalks.dto.request.user.UserSignUpRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.entity.hashTag.UserHashTagEntity;
import com.teamproject.devTalks.entity.user.UserEntity;
import com.teamproject.devTalks.repository.hashTag.UserHashTagRepository;
import com.teamproject.devTalks.repository.user.UserRepository;
import com.teamproject.devTalks.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {

    private final UserRepository userRepository;
    private final UserHashTagRepository userHashTagRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @Override
    public ResponseEntity<ResponseDto> userSignUp(UserSignUpRequestDto dto) {

        String userEmail = dto.getUserEmail();
        String userNickname = dto.getUserNickname();
        String userPhoneNumber = dto.getUserPhoneNumber();



        String encodedUserPassword = passwordEncoder.encode(dto.getUserPassword());
        dto.setUserPassword(encodedUserPassword);

        try {

            boolean isExistEmail = userRepository.existsByUserEmail(userEmail);
            if(isExistEmail) return CustomResponse.existEmail();

            boolean isExistNickname = userRepository.existsByUserNickname(userNickname);
            if(isExistNickname) return CustomResponse.existNickname();

            boolean isExistPhoneNumber = userRepository.existsByUserPhoneNumber(userPhoneNumber);
            if(isExistPhoneNumber) return CustomResponse.existPhoneNumber();

            UserEntity userEntity = new UserEntity(dto);
            userRepository.save(userEntity);

            int userNumber = userEntity.getUserNumber();
            //TODO :질문! 이 두 개는 위로 가는 게 좋나요 밑에 있어도 되나요?
            List<String> hashtagList = dto.getUserHashtag();
            List<UserHashTagEntity> userHashtagList = new ArrayList<>();


            for(String hashTag : hashtagList) {

                UserHashTagEntity userHashTagEntity = new UserHashTagEntity();

                userHashTagEntity.setUserNumber(userNumber);
                userHashTagEntity.setHashTag(hashTag);

                userHashtagList.add(userHashTagEntity);

            }

            userHashTagRepository.saveAll(userHashtagList);


        }catch (Exception exception){
            exception.printStackTrace();
            CustomResponse.databaseError();
        }

        return CustomResponse.success();
    }
}
