package com.lucas.foodtruck.repositories;

import com.example.foodtruckapi.model.Lunch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LunchRepository extends JpaRepository<Lunch, Long> {
}