package dev.lucas.foodtruck.services_implementation;

import dev.lucas.foodtruck.dto.IngredientDto;
import dev.lucas.foodtruck.exceptions.EntityNotFoundException;
import dev.lucas.foodtruck.models.Ingredient;
import dev.lucas.foodtruck.repositories.IngredientRepository;
import dev.lucas.foodtruck.services.IngredientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImplementation implements IngredientService {

    private static final Logger logger = LoggerFactory.getLogger(IngredientServiceImplementation.class);

    @Autowired
    private IngredientRepository repository;

    @Override
    public Ingredient getById(Long id) {
       logger.info("Validating id: " + id);
       Optional<Ingredient> ingredientObject = repository.findById(id);
       return ingredientObject.orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Ingredient> getAll() {
        logger.info("Getting all ingredients");
        return repository.findAll();
    }

    @Override
    public Ingredient save(IngredientDto ingredientDto) {
        logger.info("Saving ingredient - " + ingredientDto.getName());
        Ingredient ingredient = new Ingredient().setName(ingredientDto.getName()).setPrice(ingredientDto.getPrice());
        return repository.save(ingredient);
    }

    @Override
    public void update(Long id, IngredientDto ingredientDto) {
        logger.info("Validating ingredient id: " + id);
        Ingredient ingredientById = this.getById(id);
        ingredientById.setName(ingredientDto.getName());
        ingredientById.setPrice(ingredientDto.getPrice());
        logger.info("Updating ingredient" + ingredientDto.toString());
        repository.save(ingredientById);
    }

    @Override
    public void delete(Long id) {
        logger.info("Validating id: " + id);
        this.getById(id);
        logger.info("Deleting ingredient");
        repository.deleteById(id);
    }
}
