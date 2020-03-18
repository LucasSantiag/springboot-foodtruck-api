package dev.lucas.foodtruck.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comments;
    private double price;

    public Order setComments(String comments) {
        this.comments = comments;
        return this;
    }

    public Order setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
        return this;
    }

    public Order setPrice(double price) {
        this.price = price;
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

