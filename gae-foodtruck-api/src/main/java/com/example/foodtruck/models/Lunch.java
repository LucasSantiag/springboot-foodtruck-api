package com.example.foodtruck.models;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity (name = "lunchs")
@Data
public class Lunch {

    @Id
    private Long id;
    private String name;

    private List<Ingredient> ingredients = new ArrayList<>();

}
