package dev.lucas.foodtruck.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class FoodDto implements Serializable {
    private static final long serialVersionUID = 2695235335969391192L;
    private String name;
    private List<Long> ingredientsIdList;
}
