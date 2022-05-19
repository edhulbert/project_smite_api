package com.example.smite_api.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column(name = "description")
    private String desc;

    @Column
    private Integer price;

    @ManyToMany
    private List<God> gods;

    public Item(String name, String desc, Integer price) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.gods = new ArrayList<>();
    }

    protected Item() {}

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<God> getGods() {
        return gods;
    }

    public void setGods(List<God> gods) {
        this.gods = gods;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", price=" + price +
                ", gods=" + gods +
                '}';
    }
}
