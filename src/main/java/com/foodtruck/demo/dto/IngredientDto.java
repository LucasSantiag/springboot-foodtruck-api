package com.foodtruck.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class IngredientDto implements Serializable {
    private static final long serialVersionUID = 2340004891987929089L;
    private String name;
    private double cost;
}
