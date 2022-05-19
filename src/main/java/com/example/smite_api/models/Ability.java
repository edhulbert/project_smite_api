package com.example.smite_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "abilities")
public class Ability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String desc;

    @Column
    private Integer cooldown;

    @ManyToOne
    @JoinColumn(name = "god_id")
    @JsonIgnoreProperties({"abilities"})
    private God god;

    @ManyToMany
    @JoinTable(
            name = "abilities_effects",
            joinColumns = {@JoinColumn(name = "ability_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "effect_id", nullable = false)}
    )
    @JsonIgnoreProperties({"abilities"})
    private List<Effect> effects;

    public Ability(String name, String desc, Integer cooldown, God god, List<Effect> effects) {
        this.name = name;
        this.desc = desc;
        this.cooldown = cooldown;
        this.god = god;
        this.effects = effects;
    }

    protected Ability() {}

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

    public Integer getCooldown() {
        return cooldown;
    }

    public void setCooldown(Integer cooldown) {
        this.cooldown = cooldown;
    }

    public God getGod() {
        return god;
    }

    public void setGod(God god) {
        this.god = god;
    }

    public List<Effect> getEffects() {
        return effects;
    }

    public void setEffects(List<Effect> effects) {
        this.effects = effects;
    }

    @Override
    public String toString() {
        return "Ability{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", cooldown=" + cooldown +
                ", god=" + god +
                ", effects=" + effects +
                '}';
    }
}
