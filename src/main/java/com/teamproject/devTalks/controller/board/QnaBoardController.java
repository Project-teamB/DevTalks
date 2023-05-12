package com.teamproject.devTalks.controller.board;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamproject.devTalks.dto.heart.qna.PostQnaHeartRequestDto;
import com.teamproject.devTalks.dto.request.board.qna.PatchQnaBoardRequestDto;
import com.teamproject.devTalks.dto.request.board.qna.PostQnaBoardRequestDto;
import com.teamproject.devTalks.dto.request.comment.qna.PatchQnaCommentRequestDto;
import com.teamproject.devTalks.dto.request.comment.qna.PostQnaCommentRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.dto.response.board.qna.GetQnaBoardListResponseDto;
import com.teamproject.devTalks.dto.response.board.qna.GetQnaBoardResponseDto;

@RestController
@RequestMapping("/board/qna")
public class QnaBoardController {

    @GetMapping("/list")
    public ResponseEntity<? super GetQnaBoardListResponseDto> getQnaBoardList() {
        return null;
    }

    @GetMapping("/{qnaBoardNumber}")
    public ResponseEntity<? super GetQnaBoardResponseDto> getQnaBoard(
            @PathVariable("qnaBoardNumber") int qnaBoardNumber) {
        return null;
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto> postQnaBoard(
            @AuthenticationPrincipal UserDetails userDetails,
            @Valid @RequestBody PostQnaBoardRequestDto requestBody) {
        return null;
    }

    @PatchMapping("")
    public ResponseEntity<ResponseDto> patchQnaBoard(
            @AuthenticationPrincipal UserDetails userDetails,
            @Valid @RequestBody PatchQnaBoardRequestDto requestBody) {
        return null;
    }

    @DeleteMapping("/{qnaBoardNumber}")
    public ResponseEntity<ResponseDto> deleteQnaBoard(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("qnaBoardNumber") int qnaBoardNumber) {
        return null;
    }

    @PostMapping("/comment")
    public ResponseEntity<ResponseDto> postQnaComment(
            @AuthenticationPrincipal UserDetails userDetails,
            @Valid @RequestBody PostQnaCommentRequestDto requestBody) {
        return null;
    }

    @PatchMapping("/comment")
    public ResponseEntity<ResponseDto> patchQnaComment(
            @AuthenticationPrincipal UserDetails userDetails,
            @Valid @RequestBody PatchQnaCommentRequestDto requestBody) {
        return null;
    }

    @DeleteMapping("/comment/{qnaCommentNumber}")
    public ResponseEntity<ResponseDto> deleteQnaComment(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("qnaCommentNumber") int qnaCommentNumber) {
        return null;
    }

    @PostMapping("/heart")
    public ResponseEntity<ResponseDto> postQnaHeart(
            @Valid @RequestBody PostQnaHeartRequestDto requestBody) {
        return null;
    }

    @DeleteMapping("/heart/{qnaBoardNumber}")
    public ResponseEntity<ResponseDto> deleteQnaHeart(
            @PathVariable("qnaBoardNumber") int qnaBoardNumber) {
        return null;
    }

}
