package com.example.foodtruckapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.ResponseEntity.status;

@ControllerAdvice
@RestController
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

   @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> objectNotFound(EntityNotFoundException error, HttpServletRequest request) {
       ErrorAtributes err = new ErrorAtributes(error.getMessage(), error.getLocalizedMessage(),request.getRequestURI(),
               System.currentTimeMillis());
        return status(NOT_FOUND).body(err);
    }

    @ExceptionHandler(InvalidBodyException.class)
    public ResponseEntity<?> objectNotFound(InvalidBodyException error, HttpServletRequest request) {
        ErrorAtributes err = new ErrorAtributes(error.getMessage(), error.getLocalizedMessage(), request.getRequestURI(),
                System.currentTimeMillis());
        return status(BAD_REQUEST).body(err);
    }

}