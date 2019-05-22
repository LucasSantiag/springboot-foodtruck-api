package com.foodtruck.api.services_implementation

import com.foodtruck.api.exceptions.EntityNotFoundException
import com.foodtruck.api.models.Lunch
import com.foodtruck.api.repositories.LunchRepository
import com.foodtruck.api.services.LunchService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.util.Arrays.asList

@Service
class LunchServiceImplementation @Autowired
constructor(private val repository: LunchRepository) : LunchService {

    override fun findById(id: Long): Lunch {
        val lunchObject = repository.findById(id)
        return lunchObject.orElseThrow<EntityNotFoundException>(::EntityNotFoundException)
    }

    override fun getAll(): Iterable<Lunch> {
        return repository.findAll()
    }

    override fun save(lunch: Lunch): Iterable<Lunch> {
        return repository.saveAll(asList(lunch))
    }

    override fun update(id: Long, lunch: Lunch): Iterable<Lunch> {
        return repository.saveAll(asList(lunch))
    }

    override fun delete(id: Long) {
        this.findById(id)
        repository.deleteById(id)
    }
}
