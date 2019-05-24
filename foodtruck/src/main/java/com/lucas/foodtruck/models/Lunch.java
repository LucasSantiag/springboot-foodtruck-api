package com.lucas.foodtruck.models;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;

@Table
@Data
public class Lunch {
    @PrimaryKey
    private Long id;
    private String name;

    private List<Ingredient> ingredients = new ArrayList<>();

}
