package com.example.foodtruck.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Lunch {

    private Long id;
    private String name;

    private List<Ingredient> ingredients = new ArrayList<>();

}
