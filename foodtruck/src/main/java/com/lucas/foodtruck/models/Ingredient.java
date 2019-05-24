package com.lucas.foodtruck.models;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@Data
public class Ingredient {
    @PrimaryKey
    private Long id;
    private String name;
    private double cost;
}
