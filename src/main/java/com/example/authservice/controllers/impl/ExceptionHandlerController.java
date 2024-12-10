package com.example.authservice.controllers.impl;

import com.example.authservice.common.dto.ErrorResponse;
import com.example.authservice.common.exceptions.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = {AuthException.class})
    ResponseEntity<ErrorResponse> handleError(AuthException authException) {
        var errorResponse = ErrorResponse.builder()
                .codeStatus(authException.getHttpStatus().value())
                .message(authException.getMessage())
                .build();

        return ResponseEntity.status(authException.getHttpStatus()).body(errorResponse);
    }

}
