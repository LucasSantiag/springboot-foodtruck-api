package dev.lucas.foodtruck.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class IngredientDto implements Serializable {
    private static final long serialVersionUID = 6509545031101582361L;
    private String name;
    private double price;
}
