package com.teamproject.devTalks.controller.board;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamproject.devTalks.dto.request.board.postBoard.PostQnaBoardRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.dto.response.board.qnaResponseDto.GetQnaBoardListResponseDto;
import com.teamproject.devTalks.dto.response.board.qnaResponseDto.GetQnaBoardResponseDto;

@RestController
@RequestMapping("/board/qna")
public class QnaBoardController {
    
    @GetMapping("/list")
    public ResponseEntity<? super GetQnaBoardListResponseDto> getQnaBoardList() {
        return null;
    }

    @GetMapping("/{qnaBoardNumber}")
    public ResponseEntity<? super GetQnaBoardResponseDto> getQnaBoard(
        @PathVariable("qnaBoardNumber") int qnaBoardNumber
    ) {
        return null;
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto> postQnaBoard(
        @Valid @RequestBody PostQnaBoardRequestDto requestBody
    ) {
        return null;
    }

    @PatchMapping("")
    public ResponseEntity<ResponseDto> patchQnaBoard() {
        return null;
    }

    @DeleteMapping("/{qnaBoardNumber}")
    public ResponseEntity<ResponseDto> deleteQnaBoard() {
        return null;
    }

    @PostMapping("/comment")
    public ResponseEntity<ResponseDto> postQnaComment() {
        return null;
    }

    @PatchMapping("/comment")
    public ResponseEntity<ResponseDto> patchQnaComment() {
        return null;
    }

    @DeleteMapping("/comment/{qnaCommentNumber}")
    public ResponseEntity<ResponseDto> deleteQnaComment() {
        return null;
    }

    @PostMapping("/heart")
    public ResponseEntity<ResponseDto> postQnaHeart() {
        return null;
    }

    @DeleteMapping("/{qnaBoardNumber}")
    public ResponseEntity<ResponseDto> deleteQnaHeart() {
        return null;
    }





}
