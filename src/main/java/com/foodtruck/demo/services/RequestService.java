package com.foodtruck.demo.services;

import com.foodtruck.demo.models.Request;

import java.util.List;

public interface RequestService {
    Request findById(Long id);

    List<Request> getAll();

    Request save(Request request);

    void update(Long id, Request request);

    void delete(Long id);
}
