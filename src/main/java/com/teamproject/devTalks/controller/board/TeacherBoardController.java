package com.teamproject.devTalks.controller.board;

import com.teamproject.devTalks.dto.response.board.GetTeacherBoardResponseDto;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.teamproject.devTalks.service.board.TeacherBoardService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherBoardController {
    
    private final TeacherBoardService teacherBoardService;

    @GetMapping("{teacherBoardNumber}")
    public ResponseEntity<? super GetTeacherBoardResponseDto> getBoard(
        @Valid @PathVariable("teacherBoardNumber") Integer boardNumber){
            ResponseEntity<? super GetTeacherBoardResponseDto> response =
                teacherBoardService.getBoard(boardNumber);
        return response;
        }
}
