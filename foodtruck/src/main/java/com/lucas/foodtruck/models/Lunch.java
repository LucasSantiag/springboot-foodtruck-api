package com.lucas.foodtruck.models;

import lombok.Data;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Lunch {
    @Id
    private Long id;
    private String name;

    private List<Ingredient> ingredients = new ArrayList<>();

}
