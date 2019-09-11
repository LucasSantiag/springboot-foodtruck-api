package com.foodtruck.demo.repositories;

import com.foodtruck.demo.models.Lunch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LunchRepository extends JpaRepository<Lunch, Long> {
}
