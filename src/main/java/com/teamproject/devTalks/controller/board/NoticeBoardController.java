package com.teamproject.devTalks.controller.board;


import com.teamproject.devTalks.dto.request.board.notice.PostNoticeBoardRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.dto.response.board.notice.GetNoticeBoardResponseDto;
import com.teamproject.devTalks.entity.user.AdminEntity;
import com.teamproject.devTalks.security.AdminPrinciple;
import com.teamproject.devTalks.service.board.NoticeBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeBoardController {

    private final NoticeBoardService noticeBoardService;

    @PostMapping("")
    public ResponseEntity<ResponseDto> postNotice (
            @Valid @RequestBody PostNoticeBoardRequestDto dto,
            @AuthenticationPrincipal AdminPrinciple adminPrinciple

    ) {

        String adminEmail = adminPrinciple.getAdminEmail();
        ResponseEntity<ResponseDto> response = noticeBoardService.postNotice(adminEmail,dto);

        return response;

    }

    @GetMapping("{noticeBoardNumber}")
    public ResponseEntity<? super GetNoticeBoardResponseDto> getBoard(
            @PathVariable("noticeBoardNumber") Integer boardNumber
    ){
        ResponseEntity<? super GetNoticeBoardResponseDto> response =
                noticeBoardService.getBoard(boardNumber);

        return response;

    }

}
