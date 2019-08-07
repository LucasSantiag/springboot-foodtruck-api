package com.foodtruck.demo.repositories;

import com.foodtruck.demo.models.Lunch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LunchRepository extends CrudRepository<Lunch, Long> {
}
