package com.teamproject.devTalks.controller.board;


import com.teamproject.devTalks.dto.response.board.notice.GetNoticeBoardResponseDto;
import com.teamproject.devTalks.service.board.NoticeBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeBoardController {

    private final NoticeBoardService noticeBoardService;

    @GetMapping("{noticeBoardNumber}")
    public ResponseEntity<? super GetNoticeBoardResponseDto> getBoard(
            @PathVariable("noticeBoardNumber") Integer boardNumber
    ){
        ResponseEntity<? super GetNoticeBoardResponseDto> response =
                noticeBoardService.getBoard(boardNumber);

        return response;

    }



}
