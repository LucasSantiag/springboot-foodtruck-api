package com.foodtruck.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomLunch {
    private Lunch lunch;
    private List<Ingredient> ingredient = new ArrayList<>();
}
