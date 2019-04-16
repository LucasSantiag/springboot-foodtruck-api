package com.example.foodtruckapi.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double cost;

    @ManyToOne
    @JoinColumn("lunch")
    private List<Lunch> lunch;

}
