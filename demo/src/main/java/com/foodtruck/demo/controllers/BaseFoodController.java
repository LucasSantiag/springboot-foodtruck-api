package com.foodtruck.demo.controllers;

import com.foodtruck.demo.dto.BaseFoodDto;
import com.foodtruck.demo.models.BaseFood;
import com.foodtruck.demo.services_implementation.BaseFoodServiceImplementation;
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
@RequestMapping(path = "/basefood")
public class BaseFoodController {

    private Logger logger = LoggerFactory.getLogger(BaseFoodController.class);

    private BaseFoodServiceImplementation serviceImplementation;

    @Autowired
    public BaseFoodController(BaseFoodServiceImplementation serviceImplementation) {
        this.serviceImplementation = serviceImplementation;
    }

    @PostMapping
    @ApiOperation("Create a BaseFood")
    public ResponseEntity addBaseFood(@ApiParam(name = "baseFood", value = "baseFood") @RequestBody BaseFood baseFood,
                                      @ApiParam(name = "listIngredient", value = "listIngredient") @RequestBody List<Long> listIngredient) {
        logger.info("Starting the creation");
        baseFood = serviceImplementation.save(baseFood, listIngredient);
        logger.info("Created");
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(baseFood.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    @ApiOperation("Search for all Lunches")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<BaseFood> getAllBaseFood() {
        logger.info("Starting the search");
        return serviceImplementation.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation("Search for a specific BaseFood by ID")
    @ResponseStatus(HttpStatus.OK)
    public BaseFood getBaseFood(@ApiParam(name = "id", value = "long") @PathVariable Long id) {
        logger.info("Starting the search");
        return serviceImplementation.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Deletes a BaseFood")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBaseFood(@ApiParam(name = "id", value = "long") @PathVariable long id) {
        logger.info("Starting the deletion");
        serviceImplementation.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Updates an existing BaseFood")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBaseFood(@ApiParam(name = "id", value = "long") @PathVariable Long id,
                            @ApiParam(name = "lunch", value = "lunch") @RequestBody BaseFoodDto lunch) {
        logger.info("Starting the update");
        serviceImplementation.update(id, lunch);
    }
}
