package com.teamproject.devTalks.service.board;

import com.teamproject.devTalks.dto.request.board.notice.PostNoticeBoardRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.dto.response.board.notice.GetNoticeBoardListResponseDto;
import com.teamproject.devTalks.dto.response.board.notice.GetNoticeBoardResponseDto;
import org.springframework.http.ResponseEntity;

public interface NoticeBoardService {

    ResponseEntity<? super GetNoticeBoardResponseDto> getBoard(Integer boardNumber);

    ResponseEntity<ResponseDto> postNotice(String adminEmail, PostNoticeBoardRequestDto dto);


    ResponseEntity<? super GetNoticeBoardListResponseDto> getNoticeList();
}
