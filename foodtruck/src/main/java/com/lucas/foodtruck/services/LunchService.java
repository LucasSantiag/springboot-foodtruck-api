package com.lucas.foodtruck.services;

import com.lucas.foodtruck.models.Lunch;

public interface LunchService {

    Lunch findById(Long id);

    Iterable<Lunch> getAll();

    Iterable<Lunch> save(Lunch lunch);

    Iterable<Lunch> update(Long id, Lunch lunch);

    void delete(Long id);
}
