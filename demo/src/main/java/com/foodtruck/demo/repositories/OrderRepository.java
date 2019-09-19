package com.foodtruck.demo.repositories;

import com.foodtruck.demo.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Long, Order> {
}
