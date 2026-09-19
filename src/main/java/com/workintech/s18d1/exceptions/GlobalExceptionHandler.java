package com.workintech.s18d1.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BurgerException.class)
    public ResponseEntity<BurgerErrorResponse> handleBurgerException(BurgerException exception) {
        return ResponseEntity.status(exception.getHttpStatus())
                .body(new BurgerErrorResponse(exception.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BurgerErrorResponse> handleException(Exception exception) {
        return ResponseEntity.internalServerError()
                .body(new BurgerErrorResponse(exception.getMessage()));
    }
}