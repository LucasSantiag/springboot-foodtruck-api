package com.foodtruck.demo.services;

import com.foodtruck.demo.models.Lunch;

public interface LunchService {

    Lunch findById(Long id);

    Iterable<Lunch> getAll();

    Lunch save(Lunch lunch);

    void update(Long id, Lunch lunch);

    void delete(Long id);
}
