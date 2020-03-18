package dev.lucas.foodtruck.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Food setName(String name) {
        this.name = name;
        return this;
    }

    public Food setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
        return this;
    }

    @ElementCollection
    @CollectionTable(name = "listOfIngredients")
    private List<Ingredient> ingredientList = new ArrayList<>();

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
