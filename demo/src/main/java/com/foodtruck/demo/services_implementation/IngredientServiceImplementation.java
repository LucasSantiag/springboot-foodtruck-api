package com.foodtruck.demo.services_implementation;

import com.foodtruck.demo.exceptions.EntityNotFoundException;
import com.foodtruck.demo.models.Ingredient;
import com.foodtruck.demo.dto.IngredientDto;
import com.foodtruck.demo.repositories.IngredientRepository;
import com.foodtruck.demo.services.IngredientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImplementation implements IngredientService {

    private static final Logger logger = LoggerFactory.getLogger(LunchServiceImplementation.class);

    private IngredientRepository repository;

    @Autowired
    public IngredientServiceImplementation(IngredientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ingredient findById(Long id) {
        logger.info("Searching ID");
        Optional<Ingredient> ingredientObject = repository.findById(id);
        return ingredientObject.orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Ingredient> getAll() {
        logger.info("Searching");
        return repository.findAll();
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        logger.info("Creating");
        return repository.save(ingredient);
    }

    @Override
    public void update(Long id, IngredientDto ingredient) {
        Ingredient byId = this.findById(id);
        byId.setName(ingredient.getName()).setCost(ingredient.getCost());
        logger.info("Updating");
        repository.save(byId);
    }

    @Override
    public void delete(Long id) {
        this.findById(id);
        logger.info("Deleting");
        repository.deleteById(id);
    }
}
