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
@Table(name = "BASEFOOD")
public class BaseFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "basefood_ingredients",
            joinColumns = {@JoinColumn(name = "basefood_id")},
            inverseJoinColumns = {@JoinColumn(name = "ingredient_id")})
    private List<Ingredient> ingredients;

    public BaseFood setId(Long id) {
        this.id = id;
        return this;
    }

    public BaseFood setName(String name) {
        this.name = name;
        return this;
    }

    public BaseFood setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
        return this;
    }
}
