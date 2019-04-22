package com.example.foodtruckapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(){
        super("Entity not Found");
    }
}
