package com.foodtruck.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "LUNCH")
public class Lunch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "lunch_ingredients",
            joinColumns = {@JoinColumn(name = "lunch_id")},
            inverseJoinColumns = {@JoinColumn(name = "ingredient_id")})
    private List<Ingredient> ingredients;

    public Lunch setId(Long id) {
        this.id = id;
        return this;
    }

    public Lunch setName(String name) {
        this.name = name;
        return this;
    }

    public Lunch setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
        return this;
    }

}
