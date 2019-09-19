package com.foodtruck.demo.controllers;

import com.foodtruck.demo.models.Lunch;
import com.foodtruck.demo.services_implementation.LunchServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RestController
@RequestMapping(path = "/lunch")
public class LunchController {
    private LunchServiceImplementation serviceImplementation;

    @Autowired
    public LunchController(LunchServiceImplementation serviceImplementation) {
        this.serviceImplementation = serviceImplementation;
    }

    @PostMapping
    public ResponseEntity addIngredient(@RequestBody Lunch lunch) {
        lunch = serviceImplementation.save(lunch);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(lunch.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Lunch> getAllLunch() {
        return serviceImplementation.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Lunch getLunch(@PathVariable Long id) {
        return serviceImplementation.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLunch(@PathVariable long id) {
        serviceImplementation.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateLunch(@PathVariable Long id, @RequestBody Lunch lunch) {
        serviceImplementation.update(id, lunch);
    }
}
