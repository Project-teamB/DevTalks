package com.teamproject.devTalks.service.board;

import com.teamproject.devTalks.dto.response.board.GetNoticeBoardResponseDto;
import org.springframework.http.ResponseEntity;

public interface NoticeBoardService {

    ResponseEntity<? super GetNoticeBoardResponseDto> getBoard(Integer boardNumber);
}
