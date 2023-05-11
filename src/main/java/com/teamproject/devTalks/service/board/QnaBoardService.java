package com.teamproject.devTalks.service.board;

import org.springframework.http.ResponseEntity;

import com.teamproject.devTalks.dto.request.board.postBoard.PostQnaBoardRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;


public interface QnaBoardService {
    
    public ResponseEntity<ResponseDto> qnaPostBoard(PostQnaBoardRequestDto dto);





}
