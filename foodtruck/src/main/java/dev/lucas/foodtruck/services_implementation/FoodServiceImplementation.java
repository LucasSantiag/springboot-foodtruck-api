package dev.lucas.foodtruck.services_implementation;

import dev.lucas.foodtruck.exceptions.EntityNotFoundException;
import dev.lucas.foodtruck.models.Food;
import dev.lucas.foodtruck.repositories.FoodRepository;
import dev.lucas.foodtruck.services.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImplementation implements FoodService {

    private static final Logger logger = LoggerFactory.getLogger(FoodServiceImplementation.class);

    private FoodRepository repository;

    @Autowired
    public FoodServiceImplementation(FoodRepository repositoryFood) { this.repository = repositoryFood; }

    @Override
    public Food getById(Long id) {
        logger.info("Searching ID");
        Optional<Food> foodObject = repository.findById(id);
        return foodObject.orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Food> getAll() {
        logger.info("Getting all food");
        return repository.findAll();
    }

    @Override
    public Food save(Food food) {
        logger.info("Saving food");
        return repository.save(food);
    }

    @Override
    public void update(Long id, Food food) {
        logger.info("Validating food");
        Food foodById = this.getById(id);
        foodById.setName(food.getName());
        logger.info("Updating food");
        repository.save(foodById);
    }

    @Override
    public void delete(Long id) {
        logger.info("Validating food");
        this.getById(id);
        logger.info("Deleting food");
        repository.deleteById(id);
    }
}
