package com.example.foodtruckapi.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.ResponseEntity;


import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.ResponseEntity.status;

@ControllerAdvice
public class ExceptionHandler {

   @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<RuntimeException> objectNotFound(Exception error, HttpServletRequest request) {
        StandardError err = new StandardError(NOT_FOUND.value(), error.getMessage(), System.currentTimeMillis());
        return status(NOT_FOUND).body(err);
    }

}