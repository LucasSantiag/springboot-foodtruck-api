package com.foodtruck.demo.controllers;

import com.foodtruck.demo.models.Ingredient;
import com.foodtruck.demo.services_implementation.IngredientServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/ingredient")
public class IngredientController {

    @Autowired
    private IngredientServiceImplementation ingredientServiceImplementation;

    @PostMapping(path="/add/")
    public @ResponseBody String addIngredient (@RequestBody Ingredient ingredient) {
        System.out.println(ingredient.getName());
        ingredientServiceImplementation.save(ingredient);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody List<Ingredient> getAllIngredient (){
        return ingredientServiceImplementation.getAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody Ingredient getIngredient (@PathVariable("id") Long id){
        return ingredientServiceImplementation.findById(id);
    }

}
