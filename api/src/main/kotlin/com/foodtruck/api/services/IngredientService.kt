package com.foodtruck.api.services

import com.foodtruck.api.models.Ingredient

interface IngredientService {
    fun findById(id: Long): Ingredient
    fun getAll(): Iterable<Ingredient>
    fun save(ingredient: Ingredient): Iterable<Ingredient>
    fun update(id: Long, ingredient: Ingredient): Iterable<Ingredient>
    fun delete(id: Long)
}