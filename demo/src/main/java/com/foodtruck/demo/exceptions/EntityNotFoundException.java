package com.foodtruck.demo.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(){
        super("Entity not Found");
    }
}