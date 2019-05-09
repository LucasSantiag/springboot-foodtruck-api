package com.example.foodtruckapi.service;

import com.example.foodtruckapi.model.Ingredient;

import java.util.List;

public interface IngredientService {

    Ingredient findById(Long id);

    List<Ingredient> getAll();

    List<Ingredient> save(Ingredient ingredient) ;

    List<Ingredient> update(Long id, Ingredient ingredient);

    void delete(Long id);
}
