package com.lucas.foodtruck.repositories;

import com.lucas.foodtruck.models.Lunch;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LunchRepository extends CassandraRepository<Lunch, Long> {
}
