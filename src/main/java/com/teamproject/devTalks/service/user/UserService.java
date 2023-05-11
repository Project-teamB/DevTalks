package com.teamproject.devTalks.service.user;

import com.teamproject.devTalks.dto.request.user.DeleteUserRequestDto;
import com.teamproject.devTalks.dto.request.user.UpdateUserRequestDto;
import com.teamproject.devTalks.dto.request.user.UserSignInRequestDto;
import com.teamproject.devTalks.dto.request.user.UserSignUpRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.dto.response.user.SignInResponseDto;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<ResponseDto> userSignUp(UserSignUpRequestDto dto);

    ResponseEntity<? super SignInResponseDto> userSignIn(UserSignInRequestDto dto);

    ResponseEntity<ResponseDto> updateUser(String userEmail, UpdateUserRequestDto dto);

    ResponseEntity<ResponseDto> userDelete(String userEmail, DeleteUserRequestDto dto);
}
