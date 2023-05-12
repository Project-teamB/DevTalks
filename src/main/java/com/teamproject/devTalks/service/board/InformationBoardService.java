package com.teamproject.devTalks.service.board;

import java.nio.file.attribute.UserPrincipal;

import org.springframework.http.ResponseEntity;

import com.teamproject.devTalks.dto.heart.information.PostInformationHeartRequestDto;
import com.teamproject.devTalks.dto.request.board.information.PatchInformationBoardRequestDto;
import com.teamproject.devTalks.dto.request.board.information.PostInformationBoardRequestDto;
import com.teamproject.devTalks.dto.request.comment.information.PatchInformationCommentRequestDto;
import com.teamproject.devTalks.dto.request.comment.information.PostInformationCommentRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.dto.response.board.information.GetInformationBoardListResponseDto;
import com.teamproject.devTalks.dto.response.board.information.GetInformationBoardResponseDto;

public interface InformationBoardService {

    public ResponseEntity<ResponseDto> postInformationBoard(UserPrincipal userPrincipal, PostInformationBoardRequestDto dto);
    public ResponseEntity<ResponseDto> postInformationComment(UserPrincipal userPrincipal, PostInformationCommentRequestDto dto);
    public ResponseEntity<ResponseDto> postInformationHeart(UserPrincipal userPrincipal, PostInformationHeartRequestDto dto);

    public ResponseEntity<ResponseDto> patchInformationBoard(UserPrincipal userPrincipal, PatchInformationBoardRequestDto dto);
    public ResponseEntity<ResponseDto> patchInformationComment(UserPrincipal userPrincipal, PatchInformationCommentRequestDto dto);
    public ResponseEntity<ResponseDto> deleteInformationBoard(UserPrincipal userPrincipal, Integer informationBoardNumber);
    
    public ResponseEntity<ResponseDto> deleteInformationComment(UserPrincipal userPrincipal, Integer informationCommentNumber);
    public ResponseEntity<ResponseDto> deleteInformationHeart();

    public ResponseEntity<? super GetInformationBoardResponseDto> getInformationBoard(Integer informationBoardNumber);
    public ResponseEntity<? super GetInformationBoardListResponseDto> getInformationBoardList();
}