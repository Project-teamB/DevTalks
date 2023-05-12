package com.teamproject.devTalks.controller.user;

import com.teamproject.devTalks.dto.request.user.*;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.dto.response.user.SignInResponseDto;
import com.teamproject.devTalks.dto.response.user.UpdateUserResponseDto;
import com.teamproject.devTalks.security.UserPrinciple;
import com.teamproject.devTalks.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("update")
    ResponseEntity<? super UpdateUserResponseDto> updateUser(
           @AuthenticationPrincipal UserPrinciple userPrinciple
    ){
        String userEmail = userPrinciple.getUserEmail();
        ResponseEntity<? super UpdateUserResponseDto> response = userService.getUserUpdate(userEmail);
        return response;

    }

    @PatchMapping("update")
    ResponseEntity<ResponseDto> updateUser(
            @Valid @RequestBody UpdateUserRequestDto dto,
            @AuthenticationPrincipal UserPrinciple userPrinciple
    ){
        String userEmail = userPrinciple.getUserEmail();
        ResponseEntity<ResponseDto> response = userService.updateUser(userEmail,dto);
        return response;
    }

    @PatchMapping("update/password")
    ResponseEntity<ResponseDto> updateUserPassword(
            @Valid @RequestBody UpdateUserPasswordRequestDto dto,
            @AuthenticationPrincipal UserPrinciple userPrinciple
            ){
        String userEmail = userPrinciple.getUserEmail();
        ResponseEntity<ResponseDto> response =
                userService.updateUserPassword(userEmail,dto);

        return response;
    }

    @PatchMapping("delete")
    ResponseEntity<ResponseDto> deleteUser(
            @Valid @RequestBody DeleteUserRequestDto dto,
            @AuthenticationPrincipal UserPrinciple userPrinciple
    ){

        String userEmail = userPrinciple.getUserEmail();

       ResponseEntity<ResponseDto> response = userService.userDelete(userEmail,dto);
       return response;

        }
    }




