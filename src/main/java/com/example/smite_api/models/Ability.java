package com.example.smite_api.models;

import javax.persistence.*;

@Entity
@Table(name = "abilities")
public class Ability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

//    @Column
//
//    @Column
//
//    @Column

}
