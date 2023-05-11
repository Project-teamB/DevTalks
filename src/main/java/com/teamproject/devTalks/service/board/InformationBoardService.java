package com.teamproject.devTalks.service.board;

import org.springframework.http.ResponseEntity;

import com.teamproject.devTalks.dto.response.board.GetInformationBoardResponseDto;
import com.teamproject.devTalks.dto.response.board.GetInformationBoardListResponseDto;
import com.teamproject.devTalks.dto.request.board.patchBoard.PatchInformationBoardRequestDto;
import com.teamproject.devTalks.dto.request.board.postBoard.PostInformationBoardRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;

public interface InformationBoardService {

    public ResponseEntity<ResponseDto> postInformationBoard(String userEmail, PostInformationBoardRequestDto dto);

    public ResponseEntity<? super GetInformationBoardResponseDto> getBoard(Integer informationBoardNumber);
    public ResponseEntity<? super GetInformationBoardListResponseDto> getBoardList();
    
    public ResponseEntity<ResponseDto> patchBoard(String userEmail, PatchInformationBoardRequestDto dto);
    
    public ResponseEntity<ResponseDto> deleteBoard(String userEmail, Integer boardNumber);
    
}
