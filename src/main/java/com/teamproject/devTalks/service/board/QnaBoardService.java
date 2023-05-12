package com.teamproject.devTalks.service.board;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

import com.teamproject.devTalks.dto.heart.qna.PostQnaHeartRequestDto;
import com.teamproject.devTalks.dto.request.board.qna.PostQnaBoardRequestDto;
import com.teamproject.devTalks.dto.request.comment.qna.PostQnaCommentRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.dto.response.board.qna.GetQnaBoardListResponseDto;
import com.teamproject.devTalks.dto.response.board.qna.GetQnaBoardResponseDto;

public interface QnaBoardService {

    public ResponseEntity<? super GetQnaBoardListResponseDto> getQnaBoardList();

    public ResponseEntity<? super GetQnaBoardResponseDto> getQnaBoard(int qnaBoardNumber);

    public ResponseEntity<ResponseDto> postQnaBoard(UserDetails userDetails, PostQnaBoardRequestDto dto);

    public ResponseEntity<ResponseDto> postQnaComment(UserDetails userDetails, PostQnaCommentRequestDto dto);

    public ResponseEntity<ResponseDto> postQnaHeart(UserDetails userDetails, PostQnaHeartRequestDto dto);

    public ResponseEntity<ResponseDto> patchQnaBoard(UserDetails userDetails, int qnaBoardNumber);

    public ResponseEntity<ResponseDto> patchQnaComment(UserDetails userDetails, int qnaCommentNumber);

    public ResponseEntity<ResponseDto> deleteQnaBoard(UserDetails userDetails, int qnaBoardNumber);

    public ResponseEntity<ResponseDto> deleteQnaComment(UserDetails userDetails, int qnaCommentNumber);

    public ResponseEntity<ResponseDto> deleteQnaHeart();

}
