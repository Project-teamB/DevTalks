package com.teamproject.devTalks.controller.user;

import com.teamproject.devTalks.dto.request.user.AdminSignInRequestDto;
import com.teamproject.devTalks.dto.request.user.AdminSignUpRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.dto.response.user.AdminSignInResponseDto;
import com.teamproject.devTalks.service.user.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;

    @PostMapping("sign-up")
    public ResponseEntity<ResponseDto> adminSignUp(

            @Valid @RequestBody AdminSignUpRequestDto dto) {

        ResponseEntity<ResponseDto> response = adminService.adminSignUp(dto);
        return response;

    }

    @PostMapping("sign-in")
    public ResponseEntity<?super AdminSignInResponseDto> adminSignIn(
            @Valid @RequestBody AdminSignInRequestDto dto

    ){
        ResponseEntity<? super AdminSignInResponseDto> response = adminService.adminSignIn(dto);
        return response;

    }


}
