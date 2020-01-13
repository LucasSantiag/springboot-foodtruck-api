package com.foodtruck.demo.controllers;

import com.foodtruck.demo.dto.IngredientDto;
import com.foodtruck.demo.models.Ingredient;
import com.foodtruck.demo.services_implementation.IngredientServiceImplementation;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RestController
@RequestMapping(path = "/ingredient")
public class IngredientController {

    private static final Logger logger = LoggerFactory.getLogger(IngredientController.class);

    private final IngredientServiceImplementation serviceImplementation;

    @Autowired
    public IngredientController(IngredientServiceImplementation serviceImplementation) {
        this.serviceImplementation = serviceImplementation;
    }

    @PostMapping
    @ApiOperation("Create an Ingredient")
    public ResponseEntity addIngredient(@ApiParam(name = "ingredient", value = "ingredient") @RequestBody Ingredient ingredient) {
        logger.info("Starting the Ingredient creation");
        ingredient = serviceImplementation.save(ingredient);
        logger.info("Ingredient Created");
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ingredient.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    @ApiOperation("Search for all Ingredients")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Ingredient> getAllIngredient() {
        logger.info("Starting the Ingredient search");
        return serviceImplementation.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation("Search for a specific Ingredient by ID")
    @ResponseStatus(HttpStatus.OK)
    public Ingredient getIngredient(@ApiParam(name = "id", value = "long") @PathVariable Long id) {
        logger.info("Starting the Ingredient search");
        return serviceImplementation.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Deletes an Ingredient")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIngredient(@ApiParam(name = "id", value = "long") @PathVariable long id) {
        logger.info("Starting the Ingredient deletion");
        serviceImplementation.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Updates an existing Ingredient")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateIngredient(@ApiParam(name = "id", value = "long") @PathVariable Long id,
                                 @ApiParam(name = "ingredient", value = "ingredient") @RequestBody IngredientDto ingredient) {
        logger.info("Starting the Ingredient update");
        serviceImplementation.update(id, ingredient);
    }
}
