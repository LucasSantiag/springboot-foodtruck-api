package dev.lucas.foodtruck.services;

import dev.lucas.foodtruck.models.Food;

import java.util.List;

public interface FoodService {

    Food getById(Long id);

    List<Food> getAll();

    Food save(Food food);

    void update(Long id, Food food);

    void delete(Long id);
}
