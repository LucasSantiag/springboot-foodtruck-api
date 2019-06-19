package com.lucas.foodtruck.models;

import lombok.Data;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
@Data
public class Ingredient {
    @Id
    private Long id;
    private String name;
    private double cost;
}
