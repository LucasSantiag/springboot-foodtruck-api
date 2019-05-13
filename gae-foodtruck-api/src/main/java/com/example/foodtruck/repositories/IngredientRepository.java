package com.example.foodtruck.repositories;

import com.example.foodtruck.models.Ingredient;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends DatastoreRepository<Ingredient, Long>{
}
