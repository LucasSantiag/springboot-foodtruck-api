package dev.lucas.foodtruck.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class OrderDto implements Serializable {
    private static final long serialVersionUID = -1375889230412285134L;
    private String comments;
    private List<Long> ingredientsIdList;
}
