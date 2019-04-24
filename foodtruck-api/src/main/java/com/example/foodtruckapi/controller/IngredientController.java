package com.example.foodtruckapi.controller;

import com.example.foodtruckapi.service.IngredientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    private IngredientService service;

    public IngredientController (IngredientService ingredientService){
        this.service = ingredientService;
    }
    
    @GetMapping()
    public List<Ingredient> getAll() {
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    public Ingredient findById(@PathVariable("id") Long id) {
        return this.service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") Long id) {
        this.service.delete(id);
    }

    @PostMapping()
    public List<Ingredient> save(@RequestBody Ingredient ingredient) {
        this.service.save(ingredient);
        return this.service.getAll();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody Ingredient ingredient) {
        this.service.delete(id, ingredient);
    }
}
