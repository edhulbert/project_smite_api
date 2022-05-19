package com.example.smite_api.models;

import javax.persistence.*;

@Entity
@Table(name = "effects")
public class Effect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
