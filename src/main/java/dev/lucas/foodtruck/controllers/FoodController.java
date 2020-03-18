package dev.lucas.foodtruck.controllers;

import dev.lucas.foodtruck.dto.FoodDto;
import dev.lucas.foodtruck.models.Food;
import dev.lucas.foodtruck.services_implementation.FoodServiceImplementation;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@Controller
@RestController
@RequestMapping("/food")
public class FoodController {
    private Logger logger = LoggerFactory.getLogger(FoodController.class);

    @Autowired
    private FoodServiceImplementation serviceImplementation;

    @GetMapping
    @ApiOperation("Search for all lunches at database")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Food> getAllFood() {
        logger.info("Starting the food search");
        return serviceImplementation.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation("Search for specific lunch by id")
    @ResponseStatus(HttpStatus.OK)
    public Food getFoodById(@ApiParam(name = "id", value = "long") @PathVariable Long id) {
        logger.info("Starting the search");
        return serviceImplementation.getById(id);
    }

    @PostMapping
    @ApiOperation("Create a new lunch")
    public ResponseEntity<Food> postFood(@ApiParam(name = "food", value = "food") @RequestBody FoodDto food) {
        logger.info("Starting lunch creation");
        Food foodCreated = serviceImplementation.save(food);
        logger.info("Created");
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(foodCreated.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    @ApiOperation("Updates an existing food")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateFood(@ApiParam(name = "id", value = "long") @PathVariable Long id,
                               @ApiParam(name = "food", value = "food") @RequestBody FoodDto food) {
        logger.info("Starting the food update");
        serviceImplementation.update(id, food);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Deletes a food")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFood(@ApiParam(name = "id", value = "long") @PathVariable Long id) {
        logger.info("Starting the food deletion");
        serviceImplementation.delete(id);
    }
}