package com.teamproject.devTalks.service.user;

import com.teamproject.devTalks.dto.request.user.AdminSignUpRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import org.springframework.http.ResponseEntity;

public interface AdminService {

    ResponseEntity<ResponseDto> adminSignUp(AdminSignUpRequestDto dto);
}
