package com.foodtruck.demo.services;

import com.foodtruck.demo.models.Ingredient;

public interface IngredientService {

    Ingredient findById(Long id);

    Iterable<Ingredient> getAll();

    Iterable<Ingredient> save(Ingredient ingredient) ;

    Iterable<Ingredient> update(Long id, Ingredient ingredient);

    void delete(Long id);
}
