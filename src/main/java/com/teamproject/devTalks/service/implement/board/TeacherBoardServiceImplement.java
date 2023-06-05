package com.teamproject.devTalks.service.implement.board;

import com.teamproject.devTalks.common.util.CustomResponse;
import com.teamproject.devTalks.dto.request.board.teacher.PatchTeacherBoardRequestDto;
import com.teamproject.devTalks.dto.request.board.teacher.PostTeacherBoardRequestDto;
import com.teamproject.devTalks.dto.request.heart.teacher.PostTeacherHeartRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.dto.response.board.qna.GetQnaBoardListResponseDto;
import com.teamproject.devTalks.dto.response.board.teacher.GetTeacherBoardListResponseDto;
import com.teamproject.devTalks.dto.response.board.teacher.GetTeacherBoardResponseDto;
import com.teamproject.devTalks.entity.board.TeacherBoardEntity;
import com.teamproject.devTalks.entity.hashTag.TeacherBoardHashTagEntity;
import com.teamproject.devTalks.entity.heart.TeacherHeartEntity;
import com.teamproject.devTalks.entity.resultSet.QnaBoardListResultSet;
import com.teamproject.devTalks.entity.resultSet.TeacherBoardListResultSet;
import com.teamproject.devTalks.entity.user.UserEntity;
import java.util.ArrayList;
import java.util.List;

import com.teamproject.devTalks.entity.view.GetTeacherListViewEntity;
import com.teamproject.devTalks.repository.view.GetTeacherListRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.teamproject.devTalks.repository.board.TeacherBoardRepository;
import com.teamproject.devTalks.repository.hashTag.TeacherBoardHashTagRepository;
import com.teamproject.devTalks.repository.heart.TeacherHeartRepository;
import com.teamproject.devTalks.repository.user.AdminRepository;
import com.teamproject.devTalks.repository.user.UserRepository;
import com.teamproject.devTalks.service.board.TeacherBoardService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeacherBoardServiceImplement implements TeacherBoardService {
    private final UserRepository userRepository;
    private final TeacherBoardRepository teacherBoardRepository;
    private final TeacherBoardHashTagRepository teacherBoardHashTagRepository;
    private final TeacherHeartRepository teacherHeartRepository;
    private final AdminRepository adminRepository;
    private final GetTeacherListRepository getTeacherListRepository;

    @Override
    public ResponseEntity<? super GetTeacherBoardResponseDto> getTeacherBoard(Integer teacherBoardNumber) {

        try {
            if (teacherBoardNumber == null)
                return CustomResponse.validationFailed();

            TeacherBoardEntity teacherBoardEntity = 
                teacherBoardRepository.findByTeacherBoardNumber(teacherBoardNumber);
            if (teacherBoardEntity == null)
                return CustomResponse.notExistBoardNumber();

            int viewCount = teacherBoardEntity.getViewCount();
            teacherBoardEntity.setViewCount(++viewCount);
            teacherBoardRepository.save(teacherBoardEntity);

            String teacherBoardWriterEmail = teacherBoardEntity.getWriterEmail();
            UserEntity userEntity = userRepository.findByUserEmail(teacherBoardWriterEmail);

            List<TeacherHeartEntity> teacherHeartEntities = 
                    teacherHeartRepository.findByTeacherBoardNumber(teacherBoardNumber);
            List<String> heartList = teacherHeartRepository.findByTeacherBoardNumberToUserNumber(teacherBoardNumber);

            new GetTeacherBoardResponseDto(teacherBoardEntity, userEntity, viewCount, teacherHeartEntities, heartList);

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return CustomResponse.success();
    }


    // 모집상태에 따른 정렬
    @Override
    public ResponseEntity<? super GetTeacherBoardListResponseDto> getTeacherBoardRecruitmentList(String teacherSort) {

        GetTeacherBoardListResponseDto body = null;

        try {
            List<GetTeacherListViewEntity> boardList = null;
            if(teacherSort.equalsIgnoreCase("time")){
                boardList = getTeacherListRepository.findByOrderByWriteDatetimeDesc();
                body = new GetTeacherBoardListResponseDto(boardList);
            }else if(teacherSort.equalsIgnoreCase("heart")){
                boardList =getTeacherListRepository.findByOrderByHeartCountDesc();
                body = new GetTeacherBoardListResponseDto(boardList);
            }else if(teacherSort.equalsIgnoreCase("view")){
                boardList = getTeacherListRepository.findByOrderByViewCountDesc();
                body = new GetTeacherBoardListResponseDto(boardList);
            }else return CustomResponse.validationFailed();

        }catch (Exception exception){
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        return ResponseEntity.status(HttpStatus.OK).body(body);

    }

    // 검색 기능
    @Override
    public ResponseEntity<? super GetTeacherBoardListResponseDto> getTeacherBoardSearchList(
                    String group, String searchKeyword, Integer teacherBoardNumber) {

        try {
            TeacherBoardEntity teacherBoardEntity = 
                    teacherBoardRepository.findByTeacherBoardNumber(teacherBoardNumber);
            if (teacherBoardEntity == null)
                return CustomResponse.notExistBoardNumber();

            List<TeacherBoardListResultSet> resultSet = new ArrayList<>();

            if (group.equals("title"))
                resultSet = teacherBoardRepository.findByTeacherBoardTitleContaining("%" + searchKeyword + "%");
            if (group.equals("nickname"))
                resultSet = teacherBoardRepository.findByWriterNicknameContaining("%" + searchKeyword + "%");
            // if (group.equals("content"))
            //     resultSet = teacherBoardRepository.findByTeacherBoardContentContaining("%" + searchKeyword + "%");


        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return CustomResponse.success();
    }

    @Override
    public ResponseEntity<ResponseDto> postTeacherBoard(String userEmail, PostTeacherBoardRequestDto dto) {

        List<String> hashtagList = dto.getBoardHashtag();
        List<TeacherBoardHashTagEntity> teacherBoardHashtagList = new ArrayList<>();

        try {
            UserEntity userEntity = userRepository.findByUserEmail(userEmail);
            if (userEntity == null)
                return CustomResponse.authenticationFailed();

            TeacherBoardEntity teacherBoardEntity = new TeacherBoardEntity(userEmail, dto);
            teacherBoardRepository.save(teacherBoardEntity);

            for (String hashTag : hashtagList) {
                TeacherBoardHashTagEntity teacherBoardHashTagEntity = new TeacherBoardHashTagEntity(
                        teacherBoardEntity.getTeacherBoardNumber(), hashTag);
                teacherBoardHashtagList.add(teacherBoardHashTagEntity);
            }
            teacherBoardHashTagRepository.saveAll(teacherBoardHashtagList);

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return CustomResponse.success();
    }

    @Override
    public ResponseEntity<ResponseDto> patchTeacherBoard(String userEmail, PatchTeacherBoardRequestDto dto) {

        List<String> hashtagList = dto.getBoardHashtag();
        List<TeacherBoardHashTagEntity> teacherBoardHashtagList = new ArrayList<>();

        try {
            UserEntity userEntity = userRepository.findByUserEmail(userEmail);
            if (userEntity == null)
                return CustomResponse.authenticationFailed();

            TeacherBoardEntity teacherBoardEntity = 
                    teacherBoardRepository.findByTeacherBoardNumber(0);
            if (teacherBoardEntity == null)
                return CustomResponse.notExistBoardNumber();

            boolean equalWriter = teacherBoardEntity.getWriterEmail().equals(userEmail);
            if (!equalWriter)
                return CustomResponse.noPermission();

            TeacherBoardEntity teacherBoardEntityPathch = new TeacherBoardEntity(userEntity, dto);
            teacherBoardRepository.save(teacherBoardEntityPathch);

            int teacherBoardNumber1 = teacherBoardEntity.getTeacherBoardNumber();
            List<TeacherBoardHashTagEntity> currentTeacherBoardHashTagEntities = teacherBoardHashTagRepository
                    .findAllByTeacherBoardNumber(teacherBoardNumber1);

            teacherBoardHashTagRepository.deleteAll(currentTeacherBoardHashTagEntities);

            for (String hashTag : hashtagList) {
                TeacherBoardHashTagEntity teacherBoardHashTagEntity = new TeacherBoardHashTagEntity(
                        teacherBoardEntity.getTeacherBoardNumber(), hashTag);
                teacherBoardHashtagList.add(teacherBoardHashTagEntity);
            }
            teacherBoardHashTagRepository.saveAll(teacherBoardHashtagList);

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return CustomResponse.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteTeacherBoard(String userEmail, Integer teacherBoardNumber) {

        try {
            TeacherBoardEntity teacherBoardEntity = 
                    teacherBoardRepository.findByTeacherBoardNumber(0);
            if (teacherBoardEntity == null)
                return CustomResponse.notExistBoardNumber();

            boolean existedUserEmail = userRepository.existsByUserEmail(userEmail);
            if (!existedUserEmail)
                return CustomResponse.noExistUser();

            boolean equalWriter = teacherBoardEntity.getWriterEmail().equals(userEmail);
            if (!equalWriter)
                return CustomResponse.noPermission();

            int teacherBoardNumber1 = teacherBoardEntity.getTeacherBoardNumber();
            List<TeacherBoardHashTagEntity> currentTeacherBoardHashTagEntities = teacherBoardHashTagRepository
                    .findAllByTeacherBoardNumber(teacherBoardNumber1);

            teacherBoardHashTagRepository.deleteAll(currentTeacherBoardHashTagEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return CustomResponse.success();
    }

    @Override
    public ResponseEntity<ResponseDto> postTeacherHeart(String userEmail, PostTeacherHeartRequestDto dto) {

        try {
            UserEntity userEntity = userRepository.findByUserEmail(userEmail);
            if (userEntity == null)
                return CustomResponse.noExistUser();

            TeacherBoardEntity teacherBoardEntity = 
                    teacherBoardRepository.findByTeacherBoardNumber(0);
            if (teacherBoardEntity == null)
                return CustomResponse.notExistBoardNumber();

            TeacherHeartEntity teacherHeartEntity = new TeacherHeartEntity(userEntity, teacherBoardEntity);
            teacherHeartRepository.save(teacherHeartEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return CustomResponse.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteTeacherHeart(String userEmail, Integer teacherBoardNumber) {

        try {
            TeacherBoardEntity teacherBoardEntity = 
                    teacherBoardRepository.findByTeacherBoardNumber(0);
            if (teacherBoardEntity == null)
                return CustomResponse.notExistBoardNumber();

            boolean equalWriter = teacherBoardEntity.getWriterEmail().equals(userEmail);
            if (!equalWriter)
                return CustomResponse.noPermission();

            UserEntity userEntity = userRepository.findByUserEmail(userEmail);
            if (userEntity == null)
                return CustomResponse.noExistUser();

            int userNumber = userEntity.getUserNumber();
            teacherHeartRepository.deleteByUserNumberAndTeacherBoardNumber(userNumber, teacherBoardNumber);

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return CustomResponse.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteAdminTeacherBoard(String adminEmail, int teacherBoardNumber) {
        
        try {
            boolean existAdmin = adminRepository.existsByAdminEmail(adminEmail);
            if (!existAdmin)
                return CustomResponse.authenticationFailed();

            TeacherBoardEntity teacherBoardEntity = 
                    teacherBoardRepository.findByTeacherBoardNumber(teacherBoardNumber);
            if (teacherBoardEntity == null)
                return CustomResponse.notExistBoardNumber();

            teacherHeartRepository.deleteByTeacherBoardNumber(teacherBoardNumber);
            teacherBoardHashTagRepository.deleteByTeacherBoardNumber(teacherBoardNumber);
            teacherBoardRepository.delete(teacherBoardEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return CustomResponse.success();
    }

}
