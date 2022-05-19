package com.example.smite_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "effects")
public class Effect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column(name = "description")
    private String desc;

    @ManyToMany(mappedBy = "effects")
    @JsonIgnoreProperties({"effects", "items"})
    private List<Ability> abilities;

    public Effect(String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.abilities = new ArrayList<>();
    }

    protected Effect() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    @Override
    public String toString() {
        return "Effect{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", abilities=" + abilities +
                '}';
    }
}
