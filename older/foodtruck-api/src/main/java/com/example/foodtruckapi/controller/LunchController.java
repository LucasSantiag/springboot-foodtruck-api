package com.example.foodtruckapi.controller;

import com.example.foodtruckapi.model.Lunch;
import com.example.foodtruckapi.service.LunchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lunch")
public class LunchController {

    private LunchService lunchService;

    public LunchController(LunchService lunchService) {
        this.lunchService = lunchService;
    }

    @GetMapping()
    public List<Lunch> getAll() {
        return this.lunchService.getAll();
    }

    @GetMapping("/{id}")
    public Lunch findById(@PathVariable("id") Long id) {
        return this.lunchService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") Long id) {
        this.lunchService.delete(id);
    }

    @PostMapping()
    public List<Lunch> save(@RequestBody Lunch lunch) {
        this.lunchService.save(lunch);
        return this.lunchService.getAll();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody Lunch lunch) {
        this.lunchService.update(id, lunch);
    }
}
