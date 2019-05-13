package com.example.foodtruck.exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExceptionsAtributes {
    private Long time;
    private String message;
    private String details;
    private String uri;

    public ExceptionsAtributes(String message,String details, String URI, Long time) {
        this.message = message;
        this.time = time;
        this.uri = URI;
        this.details = details;
    }
}
