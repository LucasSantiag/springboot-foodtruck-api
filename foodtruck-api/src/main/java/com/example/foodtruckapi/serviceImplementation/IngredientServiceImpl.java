package com.example.foodtruckapi.serviceImplementation;

import com.example.foodtruckapi.exception.EntityNotFoundException;
import com.example.foodtruckapi.model.Ingredient;
import com.example.foodtruckapi.repository.IngredientRepository;
import com.example.foodtruckapi.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

@Service
public class IngredientServiceImpl implements IngredientService {

    private IngredientRepository repository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository repository){
        this.repository = repository;
    }

    @Override
    public Ingredient findById(Long id){
        Optional<Ingredient> ingredientObject = repository.findById(id);
        return ingredientObject.orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Ingredient> getAll(){
        Optional<Ingredient> ingredientObject = repository.findAll();
        return ingredientObject.orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Ingredient> save(Ingredient ingredient){
        Ingredient ingredient = new Ingredient(ingredient.getName(), ingredient.getCost());
        Optional<Ingredient> ingredientObject = repository.saveAll(asList(ingredient)); 
        return ingredientObject.orElseThrow(InvalidBodyException::new);
    }

    @Override
    public List<Ingredient> update(Long id, Ingredient ingredient){
        Ingredient ingredient = this.findById(id);
        ingredient.setName(ingredient.getName());
        ingredient.setCost(ingredient.getCost());
        Optional<Ingredient> ingredientObject = repository.saveAll(asList(ingredient));
        return ingredientObject.orElseThrow(InvalidBodyException::new);
    }

    @Override
    public void delete(Long id){
        this.findById(id);
        repository.deleteById(id);
    }

}
