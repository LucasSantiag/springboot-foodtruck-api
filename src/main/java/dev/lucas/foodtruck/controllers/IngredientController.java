package dev.lucas.foodtruck.controllers;

import dev.lucas.foodtruck.dto.IngredientDto;
import dev.lucas.foodtruck.models.Ingredient;
import dev.lucas.foodtruck.services_implementation.IngredientServiceImplementation;
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
@RequestMapping("/ingredient")
public class IngredientController {
    private Logger logger = LoggerFactory.getLogger(IngredientController.class);

    @Autowired
    private IngredientServiceImplementation serviceImplementation;

    @GetMapping
    @ApiOperation("Search for all ingredients at database")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Ingredient> getAllIngredient() {
        logger.info("Starting ingredient search");
        return serviceImplementation.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation("Search for specific ingredient at database")
    @ResponseStatus(HttpStatus.OK)
    public Ingredient getIngredientById(@ApiParam(name = "id", value = "long") @PathVariable Long id) {
        logger.info("Starting the search");
        return serviceImplementation.getById(id);
    }

    @PostMapping
    @ApiOperation("Add an ingredient at database")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Ingredient> postIngredient(@ApiParam(name = "ingredient", value = "ingredient") @RequestBody IngredientDto ingredientDto){
        logger.info("Starting ingredient creation");
        Ingredient ingredient = serviceImplementation.save(ingredientDto);
        logger.info("Created" +  ingredient.toString());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ingredient.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    @ApiOperation("Updates an existing ingredients")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateIngredient(@ApiParam(name = "id", value = "long") @PathVariable Long id,
                           @ApiParam(name = "ingredient", value = "ingredient") @RequestBody IngredientDto ingredient) {
        logger.info("Starting the ingredient update");
        serviceImplementation.update(id, ingredient);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Deletes a ingredient")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIngredient(@ApiParam(name = "id", value = "long") @PathVariable Long id) {
        logger.info("Starting the ingredient deletion");
        serviceImplementation.delete(id);
    }
}
