package com.example.foodtruckapi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double cost;

    public Ingredient(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }
}
