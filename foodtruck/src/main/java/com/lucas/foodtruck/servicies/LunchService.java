package com.lucas.foodtruck.servicies;

import com.example.foodtruckapi.model.Lunch;

import java.util.List;

public interface LunchService {

    Lunch findById(Long id);

    List<Lunch> getAll();

    List<Lunch> save(Lunch lunch);

    List<Lunch> update(Long id, Lunch lunch);

    void delete(Long id);
}
