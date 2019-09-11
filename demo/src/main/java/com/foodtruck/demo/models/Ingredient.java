package com.foodtruck.demo.models;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Table(name = "INGREDIENT")
public class Ingredient {
    @Autowired
    public Ingredient(Ingredient ingredient) {
        this.name = ingredient.name;
        this.cost = ingredient.cost;
    }

    public Ingredient(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double cost;

    @ManyToMany(mappedBy = "ingredients")
    private List<Lunch> lunch;
}
