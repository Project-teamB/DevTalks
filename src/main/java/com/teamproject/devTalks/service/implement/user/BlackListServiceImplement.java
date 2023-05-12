package com.teamproject.devTalks.service.implement.user;

import com.teamproject.devTalks.common.util.CustomResponse;
import com.teamproject.devTalks.dto.request.user.PostBlackListRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.entity.user.AdminEntity;
import com.teamproject.devTalks.entity.user.BlackListEntity;
import com.teamproject.devTalks.entity.user.UserEntity;
import com.teamproject.devTalks.repository.user.AdminRepository;
import com.teamproject.devTalks.repository.user.BlackListRepository;
import com.teamproject.devTalks.repository.user.UserRepository;
import com.teamproject.devTalks.service.user.BlackListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlackListServiceImplement implements BlackListService {

    private final BlackListRepository blackListRepository;
    private final AdminRepository adminRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<ResponseDto> postBlackList(String adminEmail, PostBlackListRequestDto dto) {

        int userNumber = dto.getUserNumber();
        String reason = dto.getReason();

        try {

            AdminEntity adminEntity = adminRepository.findByAdminEmail(adminEmail);
            if(adminEntity == null) return CustomResponse.authenticationFailed();

            UserEntity userEntity = userRepository.findByUserNumber(userNumber);
            if(userEntity == null) return CustomResponse.noExistUser();

            boolean isExistBlackUser = blackListRepository.existsByUserNumber(userNumber);
            if(isExistBlackUser) return CustomResponse.alreadyBlacklisted();

            BlackListEntity blackListEntity = new BlackListEntity(userNumber,reason);
            blackListRepository.save(blackListEntity);

        }catch (Exception exception){
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }


        return CustomResponse.success();
    }
}
