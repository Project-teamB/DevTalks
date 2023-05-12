package com.teamproject.devTalks.service.implement.board;

import com.teamproject.devTalks.common.util.CustomResponse;
import com.teamproject.devTalks.dto.heart.qna.PostQnaHeartRequestDto;
import com.teamproject.devTalks.dto.request.board.qna.PatchQnaBoardRequestDto;
import com.teamproject.devTalks.dto.request.board.qna.PostQnaBoardRequestDto;
import com.teamproject.devTalks.dto.request.comment.qna.PatchQnaCommentRequestDto;
import com.teamproject.devTalks.dto.request.comment.qna.PostQnaCommentRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.dto.response.board.qna.GetQnaBoardListResponseDto;
import com.teamproject.devTalks.dto.response.board.qna.GetQnaBoardResponseDto;
import com.teamproject.devTalks.entity.board.QnaBoardEntity;
import com.teamproject.devTalks.entity.user.UserEntity;
import com.teamproject.devTalks.repository.board.QnaBoardRepository;
import com.teamproject.devTalks.repository.comment.QnaCommentRepository;
import com.teamproject.devTalks.repository.hashTag.QnaBoardHashTagRepository;
import com.teamproject.devTalks.repository.heart.QnaHeartRepository;
import com.teamproject.devTalks.repository.user.UserRepository;
import com.teamproject.devTalks.service.board.QnaBoardService;

import lombok.RequiredArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.crypto.Data;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service //component로 쓰려고
@RequiredArgsConstructor
public class QnaBoardServiceImplement implements QnaBoardService {

    private final UserRepository userRepository;
    private final QnaBoardRepository qnaBoardRepository;
    private final QnaCommentRepository qnaCommentRepository;
    private final QnaBoardHashTagRepository qnaBoardHashTagRepository;
    private final QnaHeartRepository qnaHeartRepository;

    @Override
    public ResponseEntity<? super GetQnaBoardListResponseDto> getQnaBoardList(String qnaSort) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getQnaBoardList'");
    }
    
    @Override
    public ResponseEntity<? super GetQnaBoardResponseDto> getQnaBoard(int qnaBoardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getQnaBoard'");
    }
    
    @Override
    public ResponseEntity<ResponseDto> postQnaBoard(String userEmail, PostQnaBoardRequestDto dto) {

        try {
            UserEntity userEntity = userRepository.findByUserEmail(userEmail);
        if(userEntity == null) return CustomResponse.noExistUser();

        // Date now = new Date();
        // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        // String writerProfileImageUrl = userEntity.getUserProfileImageUrl();
        // String writerNickname = userEntity.getUserNickname();
        // String writerDatetime = dateFormat.format(now);
        // String qnaTitle = dto.getQnaTitle();
        // String qnaContent = dto.getQnaContent();
        // String qnaBoardImageUrl = dto.getQnaBoardImageUrl();
        // QnaBoardEntity qnaBoardEntity = new QnaBoardEntity(0, writerProfileImageUrl, writerNickname, writerDatetime, qnaTitle, qnaContent, qnaBoardImageUrl);
        QnaBoardEntity qnaBoardEntity = new QnaBoardEntity(userEntity, dto);
        qnaBoardRepository.save(qnaBoardEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        

        // return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("SU", "Success"));
        return CustomResponse.success();
    }
    @Override
    public ResponseEntity<ResponseDto> postQnaComment(String userEmail, PostQnaCommentRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postQnaComment'");
    }
    @Override
    public ResponseEntity<ResponseDto> postQnaHeart(String userEmail, PostQnaHeartRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postQnaHeart'");
    }
    @Override
    public ResponseEntity<ResponseDto> patchQnaBoard(String userEmail, PatchQnaBoardRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patchQnaBoard'");
    }
    @Override
    public ResponseEntity<ResponseDto> patchQnaComment(String userEmail, PatchQnaCommentRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patchQnaComment'");
    }
    @Override
    public ResponseEntity<ResponseDto> deleteQnaBoard(String userEmail, int qnaBoardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteQnaBoard'");
    }
    @Override
    public ResponseEntity<ResponseDto> deleteQnaComment(String userEmail, int qnaCommentNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteQnaComment'");
    }
    @Override
    public ResponseEntity<ResponseDto> deleteQnaHeart(String userEmail, int qnaBoardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteQnaHeart'");
    }
   



}
