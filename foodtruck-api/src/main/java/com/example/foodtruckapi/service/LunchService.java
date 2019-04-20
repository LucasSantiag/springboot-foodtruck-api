package com.example.foodtruckapi.service;

import com.example.foodtruckapi.model.Lunch;

import java.util.List;

public interface LunchService {

    Lunch findById(Long id);

    List<Lunch> getAll();

    List<Lunch> save(Lunch lunch);

    void update (Long id, Lunch lunch);

    void delete (Long id);
}