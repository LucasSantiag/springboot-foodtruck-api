package com.foodtruck.demo.models;

import lombok.Data;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "LUNCH")
public class Lunch {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy="lunch")
    private List<Ingredient> ingredients = new ArrayList<>();

}
