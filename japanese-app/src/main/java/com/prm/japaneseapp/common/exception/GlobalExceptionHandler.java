package com.prm.japaneseapp.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BadCredentialsException.class)
    public CustomException handleExceptionA(Exception e) {
        CustomException exception = new CustomException(e);
        return exception;
    }
    

    // Nên bắt cả Exception.class
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleUnwantedException(Exception e) {
        return ResponseEntity.status(500).body("Unknow error");
    }
}
