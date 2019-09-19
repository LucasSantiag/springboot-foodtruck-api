package com.foodtruck.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "INGREDIENT")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double cost;

    @ManyToMany(mappedBy = "ingredients")
    private List<Lunch> lunch;

    public Ingredient setId(Long id) {
        this.id = id;
        return this;
    }

    public Ingredient setName(String name) {
        this.name = name;
        return this;
    }

    public Ingredient setCost(double cost) {
        this.cost = cost;
        return this;
    }

    public Ingredient setLunch(List<Lunch> lunch) {
        this.lunch = lunch;
        return this;
    }
}
