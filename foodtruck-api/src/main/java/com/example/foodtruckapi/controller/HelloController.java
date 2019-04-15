package com.example.foodtruckapi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {
    
    public String getHello() {
        return "Hello World!";
    }
}
