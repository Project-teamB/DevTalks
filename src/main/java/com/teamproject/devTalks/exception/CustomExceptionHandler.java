package com.teamproject.devTalks.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.teamproject.devTalks.common.util.CustomResponse;
import com.teamproject.devTalks.dto.response.ResponseDto;

@RestControllerAdvice
public class CustomExceptionHandler {
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDto> handlerHttpMessageNotReadableException(
            HttpMessageNotReadableException exception) {
        return CustomResponse.validationFailed();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handlerMethodArgumentNotValidException(
        MethodArgumentNotValidException exception) {
        return CustomResponse.validationFailed();
    }

}
