package com.example.foodtruckapi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String getHello() {
        return "Hello World!";
    }
}
