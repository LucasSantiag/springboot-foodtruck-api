package com.example.foodtruckapi.exception;

public class InvalidBodyException extends RuntimeException {

    public InvalidBodyException(){
        super("Invalid body request!");
    }
}
