package com.foodtruck.demo.controllers;

import com.foodtruck.demo.models.Lunch;
import com.foodtruck.demo.services.LunchService;
import com.foodtruck.demo.services_implementation.LunchServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RestController
public class LunchController {

    @Autowired
    private LunchServiceImplementation serviceImplementation;

    @GetMapping(path="/all")
    public @ResponseBody List<Lunch> getAllLunch() {
        return serviceImplementation.getAll();
    }

    @GetMapping("/{id}")
    public Lunch getById(@PathVariable Long id) {
        return serviceImplementation.getById(id);
    }

    @PostMapping(path="/add")
    public @ResponseBody String addLunch(@Valid @RequestBody Lunch lunch) {
        serviceImplementation.save(lunch);
        return "saved";
    }
}
