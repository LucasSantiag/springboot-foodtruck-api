package com.foodtruck.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class LunchDto implements Serializable {
    private static final long serialVersionUID = 3359555390319803845L;
    private String name;
}
