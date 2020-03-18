package dev.lucas.foodtruck.services_implementation;

import dev.lucas.foodtruck.dto.FoodDto;
import dev.lucas.foodtruck.exceptions.EntityNotFoundException;
import dev.lucas.foodtruck.models.Food;
import dev.lucas.foodtruck.models.Ingredient;
import dev.lucas.foodtruck.repositories.FoodRepository;
import dev.lucas.foodtruck.services.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodServiceImplementation implements FoodService {

    private static final Logger logger = LoggerFactory.getLogger(FoodServiceImplementation.class);

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private IngredientServiceImplementation ingredientServiceImplementation;

    @Override
    public Food getById(Long id) {
        logger.info("Searching ID: " + id);
        Optional<Food> foodObject = foodRepository.findById(id);
        return foodObject.orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Food> getAll() {
        logger.info("Getting all food");
        return foodRepository.findAll();
    }

    @Override
    public Food save(FoodDto foodDto) {
        logger.info("Saving food - " + foodDto.getName());
        List<Ingredient> ingredientList = foodDto.getIngredientsIdList().stream().map(ingredientId -> ingredientServiceImplementation.getById(ingredientId)).collect(Collectors.toList());
        Food food = new Food().setName(foodDto.getName()).setIngredientList(ingredientList);
        return foodRepository.save(food);
    }

    @Override
    public void update(Long id, FoodDto foodDto) {
        logger.info("Validating food id: " + id);
        Food foodById = this.getById(id);
        List<Ingredient> ingredientList = foodDto.getIngredientsIdList().stream().map(ingredientId -> ingredientServiceImplementation.getById(ingredientId)).collect(Collectors.toList());
        foodById.setName(foodDto.getName()).setIngredientList(ingredientList);
        logger.info("Updating food");
        foodRepository.save(foodById);
    }

    @Override
    public void delete(Long id) {
        logger.info("Validating food");
        this.getById(id);
        logger.info("Deleting food");
        foodRepository.deleteById(id);
    }
}
