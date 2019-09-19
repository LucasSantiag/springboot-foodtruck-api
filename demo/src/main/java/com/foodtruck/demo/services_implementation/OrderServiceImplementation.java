package com.foodtruck.demo.services_implementation;

import com.foodtruck.demo.models.Order;
import com.foodtruck.demo.repositories.OrderRepository;
import com.foodtruck.demo.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderServiceImplementation implements OrderService {

    private Logger logger = LoggerFactory.getLogger(OrderServiceImplementation.class);

    private OrderRepository repository;

    @Autowired
    public OrderServiceImplementation(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order findById(Long id) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public Order save(Order order) {
        return null;
    }

    @Override
    public void update(Long id, Order order) {

    }

    @Override
    public void delete(Long id) {

    }
}
