package dev.lucas.foodtruck.services;

import dev.lucas.foodtruck.dto.IngredientDto;
import dev.lucas.foodtruck.models.Ingredient;

import java.util.List;

public interface IngredientService {

    Ingredient getById(Long id);

    List<Ingredient> getAll();

    Ingredient save(IngredientDto ingredient);

    void update(Long id, IngredientDto ingredient);

    void delete(Long id);
}
