package dev.lucas.foodtruck.models;

import lombok.Data;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
