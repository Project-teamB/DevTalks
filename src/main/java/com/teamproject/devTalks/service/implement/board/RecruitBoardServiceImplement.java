package com.teamproject.devTalks.service.implement.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.teamproject.devTalks.dto.request.board.recruit.PatchRecruitBoardRequestDto;
import com.teamproject.devTalks.dto.request.board.recruit.PostRecruitBoardRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.dto.response.board.recruit.GetRecruitBoardResponseDto;
import com.teamproject.devTalks.entity.board.RecruitBoardEntity;
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
    public ResponseEntity<ResponseDto> postRecruitBoard(String userEmail, PostRecruitBoardRequestDto dto) {
        
        ResponseDto body = null;

        try {
            // 존재하지 않는 유저 오류 반환
            boolean existedUserEmail = userRepository.existsByUserEmail(userEmail);
            if(!existedUserEmail) {
                ResponseDto errorBody = new ResponseDto("NU", "Non-Existent User");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorBody);
            }

            // RecruitBoardEntity recruitBoardEntity = new RecruitBoardEntity(userEmail, dto)
            // recruitBoardRepository.save(recruitBoardEntity);

            body = new ResponseDto("SU", "Success");

        } catch (Exception exception) {
            // 데이터베이스 오류 반환
            exception.printStackTrace();
            ResponseDto errorBody = new ResponseDto("DE", "DatabaseError");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorBody);
        }

        // 성공 반환
        return ResponseEntity.status(HttpStatus.OK).body(body);

    }

    @Override
    public ResponseEntity<? super GetRecruitBoardResponseDto> getRecruitBoard(Integer recruitBoardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRecruitBoard'");
    }

    @Override
    public ResponseEntity<? super GetRecruitBoardResponseDto> getRecruitBoardList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRecruitBoardList'");
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

    

    
    
    
}
