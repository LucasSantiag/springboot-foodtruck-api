package com.foodtruck.api.services

import com.foodtruck.api.models.Lunch

interface LunchService {
    fun findById(id: Long): Lunch
    fun getAll(): Iterable<Lunch>
    fun save(lunch: Lunch): Iterable<Lunch>
    fun update(id: Long, lunch: Lunch): Iterable<Lunch>
    fun delete(id: Long)
}