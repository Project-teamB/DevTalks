package com.teamproject.devTalks.service.user;

import com.teamproject.devTalks.dto.request.user.PostUserRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<ResponseDto> userSignUp(PostUserRequestDto dto);
}
