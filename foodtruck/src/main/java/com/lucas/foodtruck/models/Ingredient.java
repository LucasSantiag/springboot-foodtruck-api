package com.lucas.foodtruck.models;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "INGREDIENT")
public class Ingredient {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double cost;

    @ManyToOne
    @JoinColumn(name = "lunch", nullable = false)
    private Lunch lunch;
}
