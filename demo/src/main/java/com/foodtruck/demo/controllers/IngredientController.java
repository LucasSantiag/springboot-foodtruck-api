package com.foodtruck.demo.controllers;

import com.foodtruck.demo.models.Ingredient;
import com.foodtruck.demo.services_implementation.IngredientServiceImplementation;
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
@RequestMapping(path = "/ingredient")
public class IngredientController {

    private IngredientServiceImplementation serviceImplementation;

    @Autowired
    public IngredientController(IngredientServiceImplementation serviceImplementation) {
        this.serviceImplementation = serviceImplementation;
    }

    @PostMapping
    public ResponseEntity addIngredient(@RequestBody Ingredient ingredient) {
        ingredient = serviceImplementation.save(ingredient);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ingredient.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<Ingredient> getAllIngredient() {
        return serviceImplementation.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Ingredient getIngredient(@PathVariable Long id) {
        return serviceImplementation.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIngredient(@PathVariable long id) {
        serviceImplementation.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void updateIngredient(@PathVariable Long id, @RequestBody Ingredient ingredient) {
        serviceImplementation.update(id, ingredient);
    }
}
