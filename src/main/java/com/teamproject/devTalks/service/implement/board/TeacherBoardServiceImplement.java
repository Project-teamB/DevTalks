package com.teamproject.devTalks.service.implement.board;

import com.teamproject.devTalks.common.util.CustomResponse;
import com.teamproject.devTalks.dto.request.board.teacher.PostTeacherBoardRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.dto.response.board.teacher.GetTeacherBoardResponseDto;
import com.teamproject.devTalks.entity.board.TeacherBoardEntity;
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
    
    private final TeacherBoardRepository teacherBoardRepository;
    private final TeacherBoardHashTagRepository teacherBoardHashTagRepository;
    private final TeacherHeartRepository teacherHeartRepository;

    @Override
    public ResponseEntity<? super GetTeacherBoardResponseDto> getBoard(Integer boardNumber){
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

    
}
