package com.foodtruck.demo.services;

import com.foodtruck.demo.dto.LunchDto;
import com.foodtruck.demo.models.Lunch;

import java.util.List;

public interface LunchService {

    Lunch findById(Long id);

    List<Lunch> getAll();

    Lunch save(Lunch lunch);

    void update(Long id, LunchDto lunch);

    void delete(Long id);
}
