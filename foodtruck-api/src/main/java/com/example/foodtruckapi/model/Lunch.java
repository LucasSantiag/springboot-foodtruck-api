package com.example.foodtruckapi.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Lunch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "lunch")
    private List<Ingredient> ingredients = new ArrayList<>();

    public Lunch(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }
}