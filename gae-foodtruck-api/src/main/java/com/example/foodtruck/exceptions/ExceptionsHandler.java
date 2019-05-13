package com.example.foodtruck.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.ResponseEntity.status;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> objectNotFound(Exception exception, HttpServletRequest request) {
        ExceptionsAtributes err = new ExceptionsAtributes(exception.getMessage(), exception.getLocalizedMessage(), request.getRequestURI(), System.currentTimeMillis());
        return status(NOT_FOUND).body(err);
    }
}
