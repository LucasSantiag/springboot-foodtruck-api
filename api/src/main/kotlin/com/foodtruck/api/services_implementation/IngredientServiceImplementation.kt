package com.foodtruck.api.services_implementation

import com.foodtruck.api.exceptions.EntityNotFoundException
import com.foodtruck.api.models.Ingredient
import com.foodtruck.api.repositories.IngredientRepository
import com.foodtruck.api.services.IngredientService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.util.Arrays.asList

@Service
class IngredientServiceImplementation @Autowired
constructor(private val repository: IngredientRepository) : IngredientService {

    override fun findById(id: Long): Ingredient {
        val ingredientObject = repository.findById(id)
        return ingredientObject.orElseThrow<EntityNotFoundException>(::EntityNotFoundException)
    }

    override fun getAll(): Iterable<Ingredient> {
        return repository.findAll()
    }

    override fun save(ingredient: Ingredient): Iterable<Ingredient> {
        return repository.saveAll(asList(ingredient))
    }

    override fun update(id: Long, ingredient: Ingredient): Iterable<Ingredient> {
        return repository.saveAll(asList(ingredient))
    }

    override fun delete(id: Long) {
        this.findById(id)
        repository.deleteById(id)
    }
}
