package com.teamproject.devTalks.service.user;

import com.teamproject.devTalks.dto.request.user.PostBlackListRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.dto.response.user.GetBlackListResponseDto;
import com.teamproject.devTalks.dto.response.user.GetBlackListUserResponseDto;
import org.springframework.http.ResponseEntity;

public interface BlackListService {
    ResponseEntity<ResponseDto> postBlackList(String adminEmail, PostBlackListRequestDto dto);

    ResponseEntity<ResponseDto> deleteBlackList(String adminEmail, Integer userNumber);

    ResponseEntity<? super GetBlackListUserResponseDto> getBlackListUser(Integer userNumber, String adminEmail);

    ResponseEntity<? super GetBlackListResponseDto> getBlackList(String adminEmail);
}
