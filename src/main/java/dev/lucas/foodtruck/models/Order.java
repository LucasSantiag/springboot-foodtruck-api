package dev.lucas.foodtruck.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comments;

    public Order setComments(String comments) {
        this.comments = comments;
        return this;
    }

    public Order setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
        return this;
    }

    @ElementCollection
    @CollectionTable(name = "listOfIngredients")
    private List<Ingredient> ingredientList = new ArrayList<>();

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", ingredientList=" + ingredientList +
                '}';
    }
}
