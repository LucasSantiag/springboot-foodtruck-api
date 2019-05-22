package com.foodtruck.api.repositories

import com.foodtruck.api.models.Lunch
import org.springframework.data.cassandra.repository.CassandraRepository

interface LunchRepository : CassandraRepository<Lunch, Long>