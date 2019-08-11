package com.foodtruck.demo.controllers;

import com.foodtruck.demo.models.Lunch;
import com.foodtruck.demo.services.LunchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RestController
public class LunchController {

    @Autowired
    private LunchService service;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Lunch> getAllLunch() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Lunch getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping(path="/add")
    public @ResponseBody String addLunch(@Valid @RequestBody Lunch lunch) {
        return "";
    }
}
