package com.teamproject.devTalks.controller.user;

import com.teamproject.devTalks.dto.request.user.UserSignInRequestDto;
import com.teamproject.devTalks.dto.request.user.UserSignUpRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.dto.response.user.SignInResponseDto;
import com.teamproject.devTalks.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @PostMapping("sign-up")
    ResponseEntity<ResponseDto> userSignUp(
            @Valid @RequestBody UserSignUpRequestDto dto
    ){
        ResponseEntity<ResponseDto> response = userService.userSignUp(dto);
        return response;
    }

    @PostMapping("sign-in")
    ResponseEntity<? super SignInResponseDto> userSignIn(
            @Valid @RequestBody UserSignInRequestDto dto
            ){

        ResponseEntity<? super SignInResponseDto> response = userService.userSignIn(dto);
        return response;
    }


}
