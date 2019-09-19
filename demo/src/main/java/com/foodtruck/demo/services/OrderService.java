package com.foodtruck.demo.services;

import com.foodtruck.demo.models.Order;

import java.util.List;

public interface OrderService {
    Order findById(Long id);

    List<Order> getAll();

    Order save(Order order);

    void update(Long id, Order order);

    void delete(Long id);
}
