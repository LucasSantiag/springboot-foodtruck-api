package com.foodtruck.demo.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.ResponseEntity.status;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> objectNotFound(Exception exception, HttpServletRequest request) {
        ExceptionsAttributes err = new ExceptionsAttributes(exception.getMessage(), exception.getLocalizedMessage(), request.getRequestURI(), System.currentTimeMillis());
        return status(NOT_FOUND).body(err);
    }
}
