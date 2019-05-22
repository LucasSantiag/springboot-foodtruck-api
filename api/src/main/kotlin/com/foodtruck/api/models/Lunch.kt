package com.foodtruck.api.models

import lombok.Data
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table

@Data
@Table
class Lunch (
        @PrimaryKey
        private val id: Long,
        private val name: String,
        private val ingredients: List<Ingredient>
)