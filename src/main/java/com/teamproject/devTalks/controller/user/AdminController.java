package com.teamproject.devTalks.controller.user;

import com.teamproject.devTalks.dto.request.user.AdminSignInRequestDto;
import com.teamproject.devTalks.dto.request.user.AdminSignUpRequestDto;
import com.teamproject.devTalks.dto.request.user.UpdateAdminPasswordRequestDto;
import com.teamproject.devTalks.dto.request.user.UpdateAdminRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.dto.response.user.AdminSignInResponseDto;
import com.teamproject.devTalks.security.AdminPrinciple;
import com.teamproject.devTalks.service.user.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

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

    @PatchMapping("update")
    public ResponseEntity<ResponseDto> updateAdmin(
            @Valid @RequestBody UpdateAdminRequestDto dto,
            @AuthenticationPrincipal AdminPrinciple adminPrinciple
            ){

        String adminEmail = adminPrinciple.getAdminEmail();
        ResponseEntity<ResponseDto> response =
                adminService.adminUpdate(adminEmail,dto);

        return response;

    }

    @PatchMapping("update/password")
    public ResponseEntity<ResponseDto> updateAdminPassword(
            @Valid @RequestBody UpdateAdminPasswordRequestDto dto,
            @AuthenticationPrincipal AdminPrinciple adminPrinciple
            ){

        String adminEmail = adminPrinciple.getAdminEmail();

        ResponseEntity<ResponseDto> response =
                adminService.updateAdminPassword(adminEmail,dto);

        return response;


    }


}
