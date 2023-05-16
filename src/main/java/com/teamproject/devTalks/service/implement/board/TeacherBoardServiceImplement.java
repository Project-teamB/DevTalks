package com.teamproject.devTalks.service.implement.board;

import com.teamproject.devTalks.common.util.CustomResponse;
import com.teamproject.devTalks.dto.request.board.teacher.PatchTeacherBoardRequestDto;
import com.teamproject.devTalks.dto.request.board.teacher.PostTeacherBoardRequestDto;
import com.teamproject.devTalks.dto.request.heart.teacher.PostTeacherHeartRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.dto.response.board.teacher.GetTeacherBoardListResponseDto;
import com.teamproject.devTalks.dto.response.board.teacher.GetTeacherBoardResponseDto;

import com.teamproject.devTalks.entity.board.TeacherBoardEntity;
import com.teamproject.devTalks.entity.heart.TeacherHeartEntity;
import com.teamproject.devTalks.entity.resultSet.TeacherBoardListResultSet;
import com.teamproject.devTalks.entity.user.UserEntity;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.teamproject.devTalks.repository.board.TeacherBoardRepository;
import com.teamproject.devTalks.repository.hashTag.TeacherBoardHashTagRepository;
import com.teamproject.devTalks.repository.heart.TeacherHeartRepository;
import com.teamproject.devTalks.repository.user.UserRepository;
import com.teamproject.devTalks.service.board.TeacherBoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeacherBoardServiceImplement implements TeacherBoardService{
    private final UserRepository userRepository;
    private final TeacherBoardRepository teacherBoardRepository;
    private final TeacherBoardHashTagRepository teacherBoardHashTagRepository;
    private final TeacherHeartRepository teacherHeartRepository;

    @Override
    public ResponseEntity<? super GetTeacherBoardResponseDto> getTeacherBoard(Integer boardNumber){
        GetTeacherBoardResponseDto body = null;

        try{
            if(boardNumber == null) return CustomResponse.validationFailed();

            TeacherBoardEntity teacherBoardEntity = teacherBoardRepository.findByTeacherBoardNumber(boardNumber);
            if(teacherBoardEntity == null) return CustomResponse.notExistBoardNumber();

            int viewCount = teacherBoardEntity.getViewCount();
            teacherBoardEntity.setViewCount(++viewCount);
            teacherBoardRepository.save(teacherBoardEntity);

            body = new GetTeacherBoardResponseDto(teacherBoardEntity);

        } catch(Exception exception){
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
    // @Override
    // public ResponseEntity<? super GetTeacherBoardListResponseDto> getTeacherBoardList(String teacherSort) {
    //     GetTeacherBoardListResponseDto body = null;
    //     try {

    //         List<TeacherBoardListResultSet> resultSets = teacherBoardRepository.getList();
    //         body = new GetTeacherBoardListResponseDto(resultSets);

    //     }catch (Exception exception){
    //         exception.printStackTrace();
    //         return CustomResponse.databaseError();
    //     }
    //     return CustomResponse.success();
    // }

    @Override
    public ResponseEntity<ResponseDto> postTeacherBoard(String userEmail, PostTeacherBoardRequestDto dto) {

        try {
            UserEntity userEntity = userRepository.findByUserEmail(userEmail);
            if(userEntity == null) return CustomResponse.authenticationFailed();
        
            TeacherBoardEntity teacherBoardEntity = new TeacherBoardEntity(userEmail, dto);
            teacherBoardRepository.save(teacherBoardEntity);
    
        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        return CustomResponse.success();

    }

    @Override
    public ResponseEntity<ResponseDto> patchTeacherBoard(String userEmail, PatchTeacherBoardRequestDto dto) {
        
        try {
            UserEntity userEntity = userRepository.findByUserEmail(userEmail);
            if (userEntity == null) return CustomResponse.noExistUser();

            TeacherBoardEntity teacherBoardEntity = teacherBoardRepository.findByTeacherBoardNumber(0);
            if (teacherBoardEntity == null) return CustomResponse.notExistBoardNumber();

            TeacherBoardEntity teacherBoardEntityPathch = new TeacherBoardEntity(userEntity, dto);
            teacherBoardRepository.save(teacherBoardEntityPathch);

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return CustomResponse.success();
    }

    // @Override
    // public ResponseEntity<ResponseDto> deleteTeacherBoard(String userEmail, Integer teacherBoardNumber) {
    //     try {
    //         if (teacherBoardNumber == null) return CustomResponse.validationFailed();

    //         TeacherBoardEntity teacherBoardEntity = teacherBoardRepository.findByTeacherBoardNumber(0);
    //         if (teacherBoardEntity == null) return CustomResponse.notExistBoardNumber();

    //         boolean existedUserEmail = userRepository.existsByUserEmail(userEmail);
    //         if (!existedUserEmail) return CustomResponse.noExistUser();

    //         boolean equalWriter = teacherBoardEntity.getWriterEmail().equals(userEmail);
    //         if (!equalWriter) return CustomResponse.noPermission();

    //         teacherBoardRepository.deleteByteacherBoardNumber(teacherBoardNumber);

    //     } catch (Exception exception) {
    //         exception.printStackTrace();
    //         return CustomResponse.databaseError();
    //     }

    //     return CustomResponse.success();

    // }
    

    @Override
    public ResponseEntity<ResponseDto> postTeacherHeart(String userEmail, PostTeacherHeartRequestDto dto) {
        try {

            UserEntity userEntity = userRepository.findByUserEmail(userEmail);
            if (userEntity == null) return CustomResponse.noExistUser();

            TeacherBoardEntity teacherBoardEntity = teacherBoardRepository.findByTeacherBoardNumber(0);
            if (teacherBoardEntity == null) return CustomResponse.notExistBoardNumber();

            TeacherHeartEntity teacherHeartEntity = new TeacherHeartEntity(userEntity, teacherBoardEntity);
            teacherHeartRepository.save(teacherHeartEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        return CustomResponse.success();
    }

    // @Override
    // public ResponseEntity<ResponseDto> deleteTeacherHeart(String userEmail, Integer teacherBoardNumber) {
    //     try {
    //         if (teacherBoardNumber == null) return CustomResponse.validationFailed();

    //         TeacherBoardEntity teacherBoardEntity = teacherBoardRepository.findByTeacherBoardNumber(0);
    //         if (teacherBoardEntity == null) return CustomResponse.notExistBoardNumber();

    //         boolean existedUserEmail = userRepository.existsByUserEmail(userEmail);
    //         if (!existedUserEmail) return CustomResponse.noExistUser();

    //         boolean equalWriter = teacherBoardEntity.getWriterEmail().equals(userEmail);
    //         if (!equalWriter) return CustomResponse.noPermission();

    //         teacherHeartRepository.deleteByBoardNumber(teacherBoardNumber);

    //     } catch (Exception exception) {
    //         exception.printStackTrace();
    //         return CustomResponse.databaseError();
    //     }

    //     return CustomResponse.success();

    // }
    @Override
    public ResponseEntity<ResponseDto> postTeacherHashTag(String userEmail, PostTeacherHeartRequestDto dto) {
        return null;
        // String userEmail = dto.getUserEmail();
        // String userNickname = dto.getUserNickname();
        // String userPhoneNumber = dto.getUserPhoneNumber();

        // List<String> hashtagList = dto.getUserHashtag();
        // List<UserHashTagEntity> userHashtagList = new ArrayList<>();



        // String encodedUserPassword = passwordEncoder.encode(dto.getUserPassword());
        // dto.setUserPassword(encodedUserPassword);

        // try {

        //     boolean isExistEmail = userRepository.existsByUserEmail(userEmail);
        //     if(isExistEmail) return CustomResponse.existEmail();

        //     boolean isExistNickname = userRepository.existsByUserNickname(userNickname);
        //     if(isExistNickname) return CustomResponse.existNickname();

        //     boolean isExistPhoneNumber = userRepository.existsByUserPhoneNumber(userPhoneNumber);
        //     if(isExistPhoneNumber) return CustomResponse.existPhoneNumber();

        //     UserEntity userEntity = new UserEntity(dto);
        //     userRepository.save(userEntity);

        //     int userNumber = userEntity.getUserNumber();

        //     for(String hashTag : hashtagList) {

        //         UserHashTagEntity userHashTagEntity = new UserHashTagEntity();

        //         userHashTagEntity.setUserNumber(userNumber);
        //         userHashTagEntity.setHashtag(hashTag);

        //         userHashtagList.add(userHashTagEntity);

        //     }

        //     userHashTagRepository.saveAll(userHashtagList);


        // } catch (Exception exception){
        //     exception.printStackTrace();
        //     CustomResponse.databaseError();
        // }

        // return CustomResponse.success();
    }
    @Override
    public ResponseEntity<ResponseDto> patchTeacherHashTag(String userEmail, PatchTeacherBoardRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patchTeacherHashTag'");
    }
    @Override
    public ResponseEntity<ResponseDto> deleteTeacherHashTag(String userEmail, Integer teacherBoardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteTeacherHashTag'");
    }
    @Override
    public ResponseEntity<ResponseDto> deleteTeacherBoard(String userEmail, Integer teacherBoardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteTeacherBoard'");
    }
    @Override
    public ResponseEntity<ResponseDto> deleteTeacherHeart(String userEmail, Integer teacherBoardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteTeacherHeart'");
    }

    @Override
    public ResponseEntity<? super GetTeacherBoardListResponseDto> getTeacherBoardList(String teacherSort) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTeacherBoardList'");
    }

}
