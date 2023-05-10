package com.teamproject.devTalks.service.user;

import com.teamproject.devTalks.dto.request.user.AdminSignInRequestDto;
import com.teamproject.devTalks.dto.request.user.AdminSignUpRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.dto.response.user.AdminSignInResponseDto;
import org.springframework.http.ResponseEntity;

public interface AdminService {

    ResponseEntity<ResponseDto> adminSignUp(AdminSignUpRequestDto dto);

    ResponseEntity<? super AdminSignInResponseDto> adminSignIn(AdminSignInRequestDto dto);
}
