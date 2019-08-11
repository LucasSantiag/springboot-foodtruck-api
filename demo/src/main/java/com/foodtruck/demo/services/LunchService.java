package com.foodtruck.demo.services;

import com.foodtruck.demo.models.Lunch;

public interface LunchService {

    Lunch getById(Long id);

    Iterable<Lunch> getAll();

    Iterable<Lunch> save(Lunch lunch);

    Iterable<Lunch> update(Long id, Lunch lunch);

    void delete(Long id);
}
