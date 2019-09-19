package com.foodtruck.demo.services;

import com.foodtruck.demo.models.Ingredient;

import java.util.List;

public interface IngredientService {

    Ingredient findById(Long id);

    List<Ingredient> getAll();

    Ingredient save(Ingredient ingredient);

    void update(Long id, Ingredient ingredient);

    void delete(Long id);
}
