package com.foodtruck.api.repositories

import com.foodtruck.api.models.Ingredient
import org.springframework.data.cassandra.repository.CassandraRepository

interface IngredientRepository : CassandraRepository<Ingredient, Long>