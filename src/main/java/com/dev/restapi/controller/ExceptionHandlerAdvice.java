package com.dev.restapi.controller;

import com.dev.restapi.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity handleException(CustomException e) {
        // log exception
        return ResponseEntity.status(e.getHttpStatus()).body(e.getErrorMessage());
    }
}
