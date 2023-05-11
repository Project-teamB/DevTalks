package com.teamproject.devTalks.service.implement.board;

import com.teamproject.devTalks.dto.heart.qna.PostQnaHeartRequestDto;
import com.teamproject.devTalks.dto.request.board.qna.PostQnaBoardRequestDto;
import com.teamproject.devTalks.dto.request.comment.qna.PostQnaCommentRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.dto.response.board.qna.GetQnaBoardListResponseDto;
import com.teamproject.devTalks.dto.response.board.qna.GetQnaBoardResponseDto;
import com.teamproject.devTalks.repository.board.QnaBoardRepository;
import com.teamproject.devTalks.repository.comment.QnaCommentRepository;
import com.teamproject.devTalks.repository.hashTag.QnaBoardHashTagRepository;
import com.teamproject.devTalks.repository.heart.QnaHeartRepository;
import com.teamproject.devTalks.service.board.QnaBoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class QnaBoardServiceImplement implements QnaBoardService {

    private QnaBoardRepository qnaBoardRepository;
    private QnaCommentRepository qnaCommentRepository;
    private QnaBoardHashTagRepository qnaBoardHashTagRepository;
    private QnaHeartRepository qnaHeartRepository;

    @Override
    public ResponseEntity<? super GetQnaBoardListResponseDto> getQnaBoardList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getQnaBoardList'");
    }

    @Override
    public ResponseEntity<? super GetQnaBoardResponseDto> getQnaBoard(int qnaBoardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getQnaBoard'");
    }

    @Override
    public ResponseEntity<ResponseDto> postQnaBoard(UserDetails userDetails, PostQnaBoardRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postQnaBoard'");
    }

    @Override
    public ResponseEntity<ResponseDto> postQnaComment(UserDetails userDetails, PostQnaCommentRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postQnaComment'");
    }

    @Override
    public ResponseEntity<ResponseDto> postQnaHeart(UserDetails userDetails, PostQnaHeartRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postQnaHeart'");
    }

    @Override
    public ResponseEntity<ResponseDto> patchQnaBoard(UserDetails userDetails, int qnaBoardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patchQnaBoard'");
    }

    @Override
    public ResponseEntity<ResponseDto> patchQnaComment(UserDetails userDetails, int qnaCommentNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patchQnaComment'");
    }

    @Override
    public ResponseEntity<ResponseDto> deleteQnaBoard(UserDetails userDetails, int qnaBoardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteQnaBoard'");
    }

    @Override
    public ResponseEntity<ResponseDto> deleteQnaComment(UserDetails userDetails, int qnaCommentNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteQnaComment'");
    }

    @Override
    public ResponseEntity<ResponseDto> deleteQnaHeart() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteQnaHeart'");
    }

}
