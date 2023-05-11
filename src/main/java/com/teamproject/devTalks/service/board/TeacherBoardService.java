package com.teamproject.devTalks.service.board;

import com.teamproject.devTalks.dto.response.board.teacher.GetTeacherBoardResponseDto;
import org.springframework.http.ResponseEntity;

public interface TeacherBoardService {
    public ResponseEntity<? super GetTeacherBoardResponseDto> getBoard(Integer boardNumber);
}
