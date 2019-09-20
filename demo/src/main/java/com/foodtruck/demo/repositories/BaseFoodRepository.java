package com.foodtruck.demo.repositories;

import com.foodtruck.demo.models.BaseFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseFoodRepository extends JpaRepository<BaseFood, Long> {
}
