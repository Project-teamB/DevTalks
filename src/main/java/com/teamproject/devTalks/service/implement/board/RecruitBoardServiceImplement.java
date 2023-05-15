package com.teamproject.devTalks.service.implement.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.teamproject.devTalks.common.util.CustomResponse;
import com.teamproject.devTalks.dto.request.board.recruit.PatchRecruitBoardRequestDto;
import com.teamproject.devTalks.dto.request.board.recruit.PostRecruitBoardRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.dto.response.board.recruit.GetRecruitBoardListResponseDto;
import com.teamproject.devTalks.dto.response.board.recruit.GetRecruitBoardResponseDto;
import com.teamproject.devTalks.entity.board.RecruitBoardEntity;
import com.teamproject.devTalks.entity.hashTag.RecruitBoardHashTagEntity;
import com.teamproject.devTalks.entity.user.UserEntity;
import com.teamproject.devTalks.repository.board.RecruitBoardRepository;
import com.teamproject.devTalks.repository.comment.RecruitCommentRepository;
import com.teamproject.devTalks.repository.heart.RecruitHeartRepository;
import com.teamproject.devTalks.repository.user.UserRepository;
import com.teamproject.devTalks.service.board.RecruitBoardService;

@Service
public class RecruitBoardServiceImplement implements RecruitBoardService {

    private UserRepository userRepository;
    private RecruitBoardRepository recruitBoardRepository;
    private RecruitCommentRepository recruitCommentRepository;
    private RecruitHeartRepository recruitHeartRepository;

    @Autowired
    public RecruitBoardServiceImplement(
        UserRepository userRepository,
        RecruitBoardRepository recruitBoardRepository,
        RecruitCommentRepository recruitCommentRepository,
        RecruitHeartRepository recruitHeartRepository
    ) {
        this.userRepository = userRepository;
        this.recruitBoardRepository = recruitBoardRepository;
        this.recruitCommentRepository = recruitCommentRepository;
        this.recruitHeartRepository = recruitHeartRepository;
    }

    
    @Override
    public ResponseEntity<? super GetRecruitBoardResponseDto> getRecruitBoard(Integer recruitBoardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRecruitBoard'");
    }
    
    @Override
    public ResponseEntity<? super GetRecruitBoardListResponseDto> getRecruitBoardList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRecruitBoardList'");
    }

    @Override
    public ResponseEntity<ResponseDto> postRecruitBoard(String userEmail, PostRecruitBoardRequestDto dto) {

        try {
            // 존재하지 않는 유저 오류 반환
            UserEntity userEntity = userRepository.findByUserEmail(userEmail);
            if (userEntity == null)
                return CustomResponse.noExistUser();

            RecruitBoardEntity recruitBoardEntity = new RecruitBoardEntity(userEmail, dto);
            recruitBoardRepository.save(recruitBoardEntity);

        } catch (Exception exception) {
            // 데이터베이스 오류 반환
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        // 성공 반환
        return CustomResponse.success();

    }

    @Override
    public ResponseEntity<ResponseDto> patchRecruitBoard(String userEmail, PatchRecruitBoardRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patchRecruitBoard'");
    }

    @Override
    public ResponseEntity<ResponseDto> deleteRecruitBoard(String userEmail, Integer recruitBoardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteRecruitBoard'");
    }

    @Override
    public ResponseEntity<ResponseDto> postRecruitComment(String userEmail, PostRecruitBoardRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postRecruitComment'");
    }

    @Override
    public ResponseEntity<ResponseDto> patchRecruitComment(String userEmail, PatchRecruitBoardRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patchRecruitComment'");
    }

    @Override
    public ResponseEntity<ResponseDto> deleteRecruitComment(String userEmail, Integer recruitBoardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteRecruitComment'");
    }

    @Override
    public ResponseEntity<ResponseDto> postRecruitHeart(String userEmail, PostRecruitBoardRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postRecruitHeart'");
    }

    @Override
    public ResponseEntity<ResponseDto> patchRecruitHeart(String userEmail, PatchRecruitBoardRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patchRecruitHeart'");
    }

    @Override
    public ResponseEntity<ResponseDto> deleteRecruitHeart(String userEmail, Integer recruitBoardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteRecruitHeart'");
    }

    

    
    
    
}
