package com.example.foodtruckapi.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import lombok.Data;

@Data
@Entity
public class Ingredient {

    @Id
    private Long id;
    private String name;
    private double cost;

}
