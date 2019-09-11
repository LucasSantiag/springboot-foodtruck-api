package com.foodtruck.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "LUNCH")
public class Lunch {
    public Lunch(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "lunch_ingredients",
            joinColumns = {@JoinColumn(name = "lunch_id")},
            inverseJoinColumns = {@JoinColumn(name = "ingredient_id")})
    private List<Ingredient> ingredients;

}
