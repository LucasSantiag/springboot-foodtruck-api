package com.lucas.foodtruck.services_implementation;

import com.lucas.foodtruck.exceptions.EntityNotFoundException;
import com.lucas.foodtruck.models.Ingredient;
import com.lucas.foodtruck.repositories.IngredientRepository;
import com.lucas.foodtruck.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Arrays.asList;

@Service
public class IngredientServiceImplementation implements IngredientService {

    private IngredientRepository repository;

    @Autowired
    public IngredientServiceImplementation(IngredientRepository repository){
        this.repository = repository;
    }

    @Override
    public Ingredient findById(Long id) {
        Optional<Ingredient> ingredientObject = repository.findById(id);
        return ingredientObject.orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Iterable<Ingredient> getAll(){
        return repository.findAll();
    }

    @Override
    public Iterable<Ingredient> save(Ingredient ingredient){
        return repository.saveAll(asList(ingredient));
    }

    @Override
    public Iterable<Ingredient> update(Long id, Ingredient ingredient){
        return repository.saveAll(asList(ingredient));
    }

    @Override
    public void delete(Long id){
        this.findById(id);
        repository.deleteById(id);
    }
}
