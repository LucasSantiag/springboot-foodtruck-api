package dev.lucas.foodtruck.services;

import dev.lucas.foodtruck.dto.OrderDto;
import dev.lucas.foodtruck.models.Order;

import java.util.List;

public interface OrderService {

    Order getById(Long id);

    List<Order> getAll();

    Order save(OrderDto orderDto);

    void update(Long id, OrderDto orderDto);

    void delete(Long id);
}
