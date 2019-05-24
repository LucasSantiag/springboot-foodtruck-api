package com.lucas.foodtruck.repositories;

import com.example.foodtruckapi.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}