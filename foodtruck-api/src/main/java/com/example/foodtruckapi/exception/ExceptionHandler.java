package com.example.foodtruckapi.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.ResponseEntity.status;

@ControllerAdvice
public class ExceptionHandler {

    @ExceptionHandler
    public

}