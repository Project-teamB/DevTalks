package com.teamproject.devTalks.service.implement.board;

import com.teamproject.devTalks.dto.request.board.qna.PostQnaBoardRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.repository.board.QnaBoardRepository;
import com.teamproject.devTalks.repository.comment.QnaCommentRepository;
import com.teamproject.devTalks.repository.hashTag.QnaBoardHashTagRepository;
import com.teamproject.devTalks.repository.heart.QnaHeartRepository;
import com.teamproject.devTalks.service.board.QnaBoardService;
import org.springframework.http.ResponseEntity;

public class QnaBoardServiceImplement implements QnaBoardService{
    
    private QnaBoardRepository qnaBoardRepository;
    private QnaCommentRepository qnaCommentRepository;
    private QnaBoardHashTagRepository qnaBoardHashTagRepository;
    private QnaHeartRepository qnaHeartRepository;


    @Override
    public ResponseEntity<ResponseDto> qnaPostBoard(PostQnaBoardRequestDto dto) {
        return null;
    }
}
