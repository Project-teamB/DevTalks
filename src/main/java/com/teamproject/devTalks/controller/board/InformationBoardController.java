package com.teamproject.devTalks.controller.board;

import java.nio.file.attribute.UserPrincipal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.teamproject.devTalks.dto.heart.information.PostInformationHeartRequestDto;
import com.teamproject.devTalks.dto.request.board.information.PatchInformationBoardRequestDto;
import com.teamproject.devTalks.dto.request.board.information.PostInformationBoardRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.service.board.InformationBoardService;
import com.teamproject.devTalks.dto.response.board.information.GetInformationBoardListResponseDto;
import com.teamproject.devTalks.dto.response.board.information.GetInformationBoardResponseDto;
import com.teamproject.devTalks.security.UserPrinciple;
import com.teamproject.devTalks.dto.request.comment.information.PatchInformationCommentRequestDto;
import com.teamproject.devTalks.dto.request.comment.information.PostInformationCommentRequestDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/board/information")
@RequiredArgsConstructor
public class InformationBoardController {
    
    private final InformationBoardService informationBoardService;

    @GetMapping("/list")
    public ResponseEntity<? super GetInformationBoardListResponseDto> getInformationBoardList() {
        ResponseEntity<? super GetInformationBoardListResponseDto> response =
          informationBoardService.getInformationBoardList();
        return response;
    }

    @GetMapping("/{informationBoardNumber}") 
    public ResponseEntity<? super GetInformationBoardResponseDto> getInformationBoard(
        @PathVariable("informationBoardNumber") Integer informationBoardNumber
    ) {
        ResponseEntity<? super GetInformationBoardResponseDto> response = 
            informationBoardService.getInformationBoard(informationBoardNumber);
        return response;
    }

    // @PostMapping("")
    // public ResponseEntity<ResponseDto> PostInformationBoard(
    //     @Valid @RequestBody PostInformationBoardRequestDto requestBody,
    //     @AuthenticationPrincipal UserDetails userDetails
    // ) {
    //     ResponseEntity<ResponseDto> response = 
    //         informationBoardService.postInformationBoard(userDetails, requestBody);
    //     return response;
    // }

    // @PatchMapping("")
    // public ResponseEntity<ResponseDto> patchInformationBoard(
    //     @Valid @RequestBody PatchInformationBoardRequestDto requestBody,
    //     @AuthenticationPrincipal UserDetails userDetails
    // ) {
    //     String userEmail = userPrinciple.getUserEmail();
    //     ResponseEntity<ResponseDto> response = 
    //         informationBoardService.patchInformationBoard(userEmail, requestBody);
    //     return response;
    // }

    // @DeleteMapping("/{informationBoardNumber}")
    // public ResponseEntity<ResponseDto> deleteInformationBoard(
    //     @AuthenticationPrincipal UserDetails userDetails,
    //     @PathVariable("informationBoardNumber") Integer informationBoardNumber
    // ) {
    //     ResponseEntity<ResponseDto> response =
    //         informationBoardService.deleteInformationBoard(userDetails, informationBoardNumber);
    //     return response;
    // }

    // @PostMapping("/comment")
    // public ResponseEntity<ResponseDto> postInformationComment(
    //         @AuthenticationPrincipal UserDetails userDetails,
    //         @Valid @RequestBody PostInformationCommentRequestDto requestBody
    //         ) {
    //         ResponseEntity<ResponseDto> response = informationBoardService.postInformationComment(userDetails, requestBody);
    //         return response;
    // }

    // @PatchMapping("/comment")
    // public ResponseEntity<ResponseDto> patchInformationComment(
    //         @AuthenticationPrincipal UserDetails userDetails,
    //         @Valid @RequestBody PatchInformationCommentRequestDto requestBody
    //         ) {
    //         ResponseEntity<ResponseDto> response = informationBoardService.patchInformationComment(userDetails, requestBody);
    //         return response;
    // }

    // @DeleteMapping("/comment/{informationCommentNumber}")
    // public ResponseEntity<ResponseDto> deleteInformationComment(
    //         @AuthenticationPrincipal UserDetails userDetails,
    //         @Valid @RequestBody Integer InformationCommentNumber
    //         ) {
    //         ResponseEntity<ResponseDto> response = informationBoardService.deleteInformationComment(userDetails, InformationCommentNumber);
    //         return response;
    // }

    // @PostMapping("/heart")
    // public ResponseEntity<ResponseDto> postInformationHeart(
    //         @Valid @RequestBody PostInformationHeartRequestDto requestBody) {
    //     return null;
    // }

    // @DeleteMapping("/heart/{informationBoardNumber}")
    // public ResponseEntity<ResponseDto> deleteInformationHeart(
    //         @PathVariable("informationBoardNumber") int informationBoardNumber) {
    //     return null;
    // }
}
