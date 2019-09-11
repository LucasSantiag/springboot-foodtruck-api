package com.example.foodtruckapi.repository;

import com.example.foodtruckapi.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}