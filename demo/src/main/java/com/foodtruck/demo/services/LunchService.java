package com.foodtruck.demo.services;

import com.foodtruck.demo.dto.LunchDto;
import com.foodtruck.demo.models.Lunch;

public interface LunchService {

    Lunch findById(Long id);

    Iterable<Lunch> getAll();

    Lunch save(Lunch lunch);

    void update(Long id, LunchDto lunch);

    void delete(Long id);
}
