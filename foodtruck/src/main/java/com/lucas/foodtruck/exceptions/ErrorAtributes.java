package com.lucas.foodtruck.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorAtributes {

    private Long time;
    private String message;
    private String details;
    private String uri;

    public ErrorAtributes(String message,String details, String URI, Long time) {
        this.message = message;
        this.time = time;
        this.uri = URI;
        this.details = details;
    }
}
