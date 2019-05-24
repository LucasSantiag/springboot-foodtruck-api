package com.lucas.foodtruck.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double cost;

    @ManyToMany
    @JoinTable(name = "ingredientLunch", joinColumns = @JoinColumn(name = "lunch"), inverseJoinColumns =
            @JoinColumn(name = "ingredient"))
    private List<Lunch> lunch = new ArrayList<>();

    public Ingredient(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }
}
