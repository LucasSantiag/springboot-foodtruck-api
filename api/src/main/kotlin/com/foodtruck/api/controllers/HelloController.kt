package com.foodtruck.api.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController{
    @GetMapping("/") fun getHello(): String { return "Hello World!"}
}