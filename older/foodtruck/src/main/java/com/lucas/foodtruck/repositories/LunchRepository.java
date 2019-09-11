package com.lucas.foodtruck.repositories;

import com.lucas.foodtruck.models.Lunch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LunchRepository extends CrudRepository<Lunch, Long> {
}
