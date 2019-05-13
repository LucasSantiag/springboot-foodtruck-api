package com.example.foodtruck.repositories;

import com.example.foodtruck.models.Lunch;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LunchRepository extends DatastoreRepository<Lunch, Long>{
}
