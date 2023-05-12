package com.teamproject.devTalks.service.board;

import org.springframework.http.ResponseEntity;

import com.teamproject.devTalks.dto.response.board.informaion.GetInformationBoardResponseDto;
import com.teamproject.devTalks.dto.response.board.informaion.GetInformationBoardListResponseDto;
import com.teamproject.devTalks.dto.request.board.information.PatchInformationBoardRequestDto;
import com.teamproject.devTalks.dto.request.board.information.PostInformationBoardRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;

public interface InformationBoardService {

    public ResponseEntity<ResponseDto> postInformationBoard(String userEmail, PostInformationBoardRequestDto dto);

    public ResponseEntity<? super GetInformationBoardResponseDto> getBoard(Integer informationBoardNumber);
    public ResponseEntity<? super GetInformationBoardListResponseDto> getBoardList();
    
    public ResponseEntity<ResponseDto> patchBoard(String userEmail, PatchInformationBoardRequestDto dto);
    
    public ResponseEntity<ResponseDto> deleteBoard(String userEmail, Integer boardNumber);
    
}
