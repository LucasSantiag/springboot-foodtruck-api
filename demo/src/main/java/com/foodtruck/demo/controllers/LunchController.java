package com.foodtruck.demo.controllers;

import com.foodtruck.demo.dto.LunchDto;
import com.foodtruck.demo.models.Lunch;
import com.foodtruck.demo.services_implementation.LunchServiceImplementation;
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
@RequestMapping(path = "/lunch")
public class LunchController {

    private Logger logger = LoggerFactory.getLogger(LunchController.class);

    private LunchServiceImplementation serviceImplementation;

    @Autowired
    public LunchController(LunchServiceImplementation serviceImplementation) {
        this.serviceImplementation = serviceImplementation;
    }

    @PostMapping
    @ApiOperation("Create a Lunch")
    public ResponseEntity addIngredient(@ApiParam(name = "lunch", value = "lunch") @RequestBody Lunch lunch) {
        logger.info("Starting the creation");
        lunch = serviceImplementation.save(lunch);
        logger.info("Created");
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(lunch.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    @ApiOperation("Search for all Lunches")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Lunch> getAllLunch() {
        logger.info("Starting the search");
        return serviceImplementation.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation("Search for a specific Lunch by ID")
    @ResponseStatus(HttpStatus.OK)
    public Lunch getLunch(@ApiParam(name = "id", value = "long") @PathVariable Long id) {
        logger.info("Starting the search");
        return serviceImplementation.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Deletes a Lunch")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLunch(@ApiParam(name = "id", value = "long") @PathVariable long id) {
        logger.info("Starting the deletion");
        serviceImplementation.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Updates an existing Lunch")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateLunch(@ApiParam(name = "id", value = "long") @PathVariable Long id,
                            @ApiParam(name = "lunch", value = "lunch") @RequestBody LunchDto lunch) {
        logger.info("Starting the update");
        serviceImplementation.update(id, lunch);
    }
}
