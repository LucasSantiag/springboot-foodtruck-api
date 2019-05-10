package com.example.foodtruck.models;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import lombok.Data;

@Entity (name = "ingredients")
@Data
public class Ingredient {

    @Id
    private Long id;
    private String name;
    private double cost;
}
