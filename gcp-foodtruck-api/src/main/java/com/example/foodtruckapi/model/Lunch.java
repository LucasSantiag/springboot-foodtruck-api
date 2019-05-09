package com.example.foodtruckapi.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class Lunch {

    @Id
    private Long id;
    private String name;

    private List<Ingredient> ingredients = new ArrayList<>();

}
