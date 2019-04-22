package com.example.foodtruckapi.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(){
        super("Entity not Found");
    }
}
