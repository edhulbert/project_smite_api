package com.example.smite_api.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gods")
public class God {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String pantheon;

    @Column
    private String type;

    @Column
    private Integer money;

    @OneToMany(mappedBy = "god")
    @JsonIgnoreProperties({"god"})
    private List<Ability> abilities;

    @ManyToMany
    @JoinTable(
            name = "gods_items",
            joinColumns = {@JoinColumn(name = "god_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "item_id", nullable = false)}
    )
    @JsonIgnoreProperties({"gods"})
    private List<Item> items;

    public God(String name, String pantheon, String type, Integer money, List<Item> items) {
        this.name = name;
        this.pantheon = pantheon;
        this.type = type;
        this.money = money;
        this.abilities = new ArrayList<>();
        this.items = items;
    }

    protected God() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPantheon() {
        return pantheon;
    }

    public void setPantheon(String pantheon) {
        this.pantheon = pantheon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "God{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pantheon='" + pantheon + '\'' +
                ", type='" + type + '\'' +
                ", money=" + money +
                ", abilities=" + abilities +
                ", items=" + items +
                '}';
    }
}
