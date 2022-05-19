package com.example.smite_api.models;


import javax.persistence.*;

@Entity
@Table(name = "gods")
public class God {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

}
