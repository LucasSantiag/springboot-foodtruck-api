package com.foodtruck.demo.services_implementation;

import com.foodtruck.demo.exceptions.EntityNotFoundException;
import com.foodtruck.demo.models.Ingredient;
import com.foodtruck.demo.repositories.IngredientRepository;
import com.foodtruck.demo.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImplementation implements IngredientService {

    private IngredientRepository repository;

    @Autowired
    public IngredientServiceImplementation(IngredientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ingredient findById(Long id) {
        Optional<Ingredient> ingredientObject = repository.findById(id);
        return ingredientObject.orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Ingredient> getAll() {
        return repository.findAll();
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return repository.save(ingredient);
    }

    @Override
    public void  update(Long id, Ingredient ingredient) {
        this.findById(id);
        ingredient.setId(id);
        repository.save(ingredient);
    }

    @Override
    public void delete(Long id) {
        this.findById(id);
        repository.deleteById(id);
    }
}
