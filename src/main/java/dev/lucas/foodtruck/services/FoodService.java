package dev.lucas.foodtruck.services;

import dev.lucas.foodtruck.dto.FoodDto;
import dev.lucas.foodtruck.models.Food;

import java.util.List;

public interface FoodService {

    Food getById(Long id);

    List<Food> getAll();

    Food save(FoodDto food);

    void update(Long id, FoodDto food);

    void delete(Long id);
}
