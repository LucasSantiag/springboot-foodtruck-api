package com.lucas.foodtruck.repositories;

import com.lucas.foodtruck.models.Ingredient;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CassandraRepository<Ingredient, Long> {
}
