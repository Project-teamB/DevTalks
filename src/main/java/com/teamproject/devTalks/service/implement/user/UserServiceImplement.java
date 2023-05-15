package com.teamproject.devTalks.service.implement.user;

import com.teamproject.devTalks.common.util.CustomResponse;
import com.teamproject.devTalks.dto.request.user.*;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.dto.response.user.GetMyInfoResponseDto;
import com.teamproject.devTalks.dto.response.user.GetUserInformationResponseDto;
import com.teamproject.devTalks.dto.response.user.SignInResponseDto;
import com.teamproject.devTalks.entity.hashTag.UserHashTagEntity;
import com.teamproject.devTalks.entity.recommendation.RecommendationEntity;
import com.teamproject.devTalks.entity.user.BlackListEntity;
import com.teamproject.devTalks.entity.user.UserEntity;
import com.teamproject.devTalks.provider.JwtProvider;
import com.teamproject.devTalks.repository.hashTag.UserHashTagRepository;
import com.teamproject.devTalks.repository.recommendation.RecommendationRepository;
import com.teamproject.devTalks.repository.user.BlackListRepository;
import com.teamproject.devTalks.repository.user.UserRepository;
import com.teamproject.devTalks.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    private final BlackListRepository blackListRepository;
    private final RecommendationRepository recommendationRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;


    @Override
    public ResponseEntity<ResponseDto> userSignUp(UserSignUpRequestDto dto) {

        String userEmail = dto.getUserEmail();
        String userNickname = dto.getUserNickname();
        String userPhoneNumber = dto.getUserPhoneNumber();

        List<String> hashtagList = dto.getUserHashtag();
        List<UserHashTagEntity> userHashtagList = new ArrayList<>();



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

            for(String hashTag : hashtagList) {

                UserHashTagEntity userHashTagEntity = new UserHashTagEntity();

                userHashTagEntity.setUserNumber(userNumber);
                userHashTagEntity.setHashtag(hashTag);

                userHashtagList.add(userHashTagEntity);

            }

            userHashTagRepository.saveAll(userHashtagList);


        } catch (Exception exception){
            exception.printStackTrace();
            CustomResponse.databaseError();
        }

        return CustomResponse.success();
    }

    @Override
    public ResponseEntity<? super SignInResponseDto> userSignIn(UserSignInRequestDto dto) {

        SignInResponseDto body = null;
        String userEmail = dto.getUserEmail();
        String password = dto.getUserPassword();
        String ROLE = "USER";

        try{

            UserEntity userEntity = userRepository.findByUserEmail(userEmail);
            if(userEntity == null) return CustomResponse.signInFailed();

            String encodedPassword = userEntity.getUserPassword();
            boolean isEqualPassword = passwordEncoder.matches(password,encodedPassword);
            if(!isEqualPassword) return CustomResponse.signInFailed();

            String jwt = jwtProvider.createJwt(userEmail,ROLE);
            body = new SignInResponseDto(jwt);

        }catch (Exception exception){
            exception.printStackTrace();
            return CustomResponse.databaseError();

        }

        return ResponseEntity.status(HttpStatus.OK).body(body);
    }



    @Override
    public ResponseEntity<? super GetMyInfoResponseDto> getMyInfo(String userEmail) {

        GetMyInfoResponseDto body = null;
        List<String> hashtagList = new ArrayList<>();

        try {

            UserEntity userEntity = userRepository.findByUserEmail(userEmail);
            if(userEntity == null) return CustomResponse.noExistUser();

            int userNumber = userEntity.getUserNumber();
            List<UserHashTagEntity> userHashTagEntities =
                    userHashTagRepository.findAllByUserNumber(userNumber);

            for(UserHashTagEntity userHashTagEntity: userHashTagEntities){
                String hashtag = userHashTagEntity.getHashtag();
                hashtagList.add(hashtag);
            }

            List<RecommendationEntity> recommendation =
                    recommendationRepository.findByReceiverUserNumber(userNumber);

            int recommendationCount = recommendation.size();

            body = new GetMyInfoResponseDto(hashtagList,userEntity,recommendationCount);

        }catch (Exception exception){
            exception.printStackTrace();
            return CustomResponse.databaseError();

        }

        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @Override
    public ResponseEntity<? super GetUserInformationResponseDto> getUserInformation(Integer userNumber) {

        if(userNumber == null) return CustomResponse.validationFailed();

        GetUserInformationResponseDto body = null;
        List<String> hashtagList = new ArrayList<>();

        try {

            UserEntity userEntity = userRepository.findByUserNumber(userNumber);
            if(userEntity == null) return CustomResponse.noExistUser();

            List<UserHashTagEntity> userHashTagEntities =
                    userHashTagRepository.findAllByUserNumber(userNumber);

            for(UserHashTagEntity userHashTagEntity: userHashTagEntities){
                String hashtag = userHashTagEntity.getHashtag();
                hashtagList.add(hashtag);
            }

            List<RecommendationEntity> recommendation =
                    recommendationRepository.findByReceiverUserNumber(userNumber);

            int recommendationCount = recommendation.size();

            body = new GetUserInformationResponseDto(hashtagList,userEntity,recommendationCount);

        }catch (Exception exception){
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @Override
    public ResponseEntity<ResponseDto> updateUser(String userEmail, UpdateUserRequestDto dto) {

        String password = dto.getPassword();
        String userNickname = dto.getUserNickname();
        String userPhoneNumber = dto.getUserPhoneNumber();
        String userIntroduction = dto.getUserIntroduction();
        String userProfileImageUrl = dto.getUserProfileImageUrl();
        boolean  chatAcceptance = dto.isChatAcceptance();

        List<String> hashTagList = dto.getUserHashtag();
        List<UserHashTagEntity> userHashtagList = new ArrayList<>();

        try {

            UserEntity userEntity = userRepository.findByUserEmail(userEmail);
            if(userEntity == null) CustomResponse.noExistUser();

            String encodedCurrentPassword = userEntity.getUserPassword();

            boolean isEqualPassword = passwordEncoder.matches(password,encodedCurrentPassword);
            if(!isEqualPassword) return CustomResponse.passwordMismatch();

            boolean isExistUserNickname = userRepository.existsByUserNickname(userNickname);
            if(isExistUserNickname) return CustomResponse.existNickname();

            boolean isExistPhoneNumber = userRepository.existsByUserPhoneNumber(userPhoneNumber);
            if(isExistPhoneNumber) return CustomResponse.existPhoneNumber();

            userEntity.setUserNickname(userNickname);
            userEntity.setUserPhoneNumber(userPhoneNumber);
            userEntity.setUserIntroduction(userIntroduction);
            userEntity.setUserProfileImageUrl(userProfileImageUrl);
            userEntity.setChatAcceptance(chatAcceptance);

            userRepository.save(userEntity);

            int userNumber = userEntity.getUserNumber();

            List<UserHashTagEntity> currentUserHashTagEntities =
                    userHashTagRepository.findAllByUserNumber(userNumber);

            userHashTagRepository.deleteAll(currentUserHashTagEntities);

            for(String hashtag:hashTagList){

                UserHashTagEntity userHashTagEntity = new UserHashTagEntity();
                userHashTagEntity.setUserNumber(userNumber);
                userHashTagEntity.setHashtag(hashtag);

                userHashtagList.add(userHashTagEntity);

            }

            userHashTagRepository.saveAll(userHashtagList);

        }catch (Exception exception){
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        return CustomResponse.success();
    }
    @Override
    public ResponseEntity<ResponseDto> updateUserPassword(
            String userEmail, UpdateUserPasswordRequestDto dto
    ) {
        String currentPassword = dto.getCurrentPassword();
        String changePassword = dto.getChangePassword();

        UserEntity userEntity = userRepository.findByUserEmail(userEmail);
        if(userEntity == null) CustomResponse.noExistUser();

        String encodedCurrentPassword = userEntity.getUserPassword();
        boolean isEqualPassword = passwordEncoder.matches(currentPassword,encodedCurrentPassword);

        if(!isEqualPassword) return CustomResponse.passwordMismatch();
        String encodedChangePassword = passwordEncoder.encode(changePassword);

        userEntity.setUserPassword(encodedChangePassword);
        userRepository.save(userEntity);

        return CustomResponse.success();
    }
    @Override
    public ResponseEntity<ResponseDto> userDelete(String userEmail, DeleteUserRequestDto dto) {

        String password = dto.getUserPassword();

        try {

            UserEntity userEntity = userRepository.findByUserEmail(userEmail);
            if(userEntity == null) return CustomResponse.noExistUser();

            String encodedPassword = userEntity.getUserPassword();
            boolean isEqualPassword = passwordEncoder.matches(password,encodedPassword);

            if(!isEqualPassword) return CustomResponse.passwordMismatch();

            int userNumber = userEntity.getUserNumber();

            List<UserHashTagEntity> userHashTagEntities =
                    userHashTagRepository.findAllByUserNumber(userNumber);

            userHashTagRepository.deleteAll(userHashTagEntities);


            List<RecommendationEntity> sendRecommendations =
                    recommendationRepository.findBySenderUserNumber(userNumber);

            List<RecommendationEntity> receiveRecommendations=
                    recommendationRepository.findByReceiverUserNumber(userNumber);

            recommendationRepository.deleteAll(sendRecommendations);
            recommendationRepository.deleteAll(receiveRecommendations);

            BlackListEntity blackListEntity = blackListRepository.findByUserNumber(userNumber);
            blackListRepository.delete(blackListEntity);

            userRepository.deleteByUserEmail(userEmail);

        }catch (Exception exception){
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return CustomResponse.success();
    }



}