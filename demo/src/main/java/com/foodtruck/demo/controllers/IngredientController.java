package com.foodtruck.demo.controllers;


import com.foodtruck.demo.models.Ingredient;
import com.foodtruck.demo.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/ingredient")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @PostMapping(path="/add/{name}")
    public @ResponseBody String addIngredient (@PathVariable("name") String name) {
        System.out.println(name.toString());
        Ingredient ingredient = new Ingredient();
        ingredient.setName(name);
        ingredientRepository.save(ingredient);
        return "Saved";
    }
}
