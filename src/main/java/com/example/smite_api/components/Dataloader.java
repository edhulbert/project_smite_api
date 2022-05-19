package com.example.smite_api.components;

import com.example.smite_api.models.Effect;
import com.example.smite_api.models.God;
import com.example.smite_api.models.Item;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Dataloader implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // new up items
        Item item1 = new Item("Sovereignty", "Provides physical protected aura", 3, 2100);
        Item item2 = new Item("Mystical Mail", "Nearby enemies are damaged", 3, 2450);
        Item item3 = new Item("Qin's Sais", "Grants extra damage dependant on targets max health", 3, 2600);
        Item item4 = new Item("Asi", "Grants Physical Lifesteal", 3, 2550);
        Item item5 = new Item("Bancroft's Talon", "Gain Magical Power from missing health", 3, 2500);
        Item item6 = new Item("Spirit Robe", "Physical and Magical Protection", 3, 2500);
        Item item7 = new Item("Steel Mail", "Health and Physical protection", 2, 1400);
        Item item8 = new Item("Charged Morningstar", "Physical Power", 2, 1200);
        Item item9 = new Item("Tiny Trinket", "Magican Power and Lifesteal", 1, 550);

        // new up gods
        God god1 = new God("Loki", "Norse", "Assassin", 634, Arrays.asList(item3, item4, item6));
        God god2 = new God("Aphrodite", "Greek", "Mage", 2600, Arrays.asList(item9));
        God god3 = new God("Ah Muzen Cab", "Maya", "Hunter", 3, Arrays.asList(item3, item4, item8));
        God god4 = new God("Sun Wukong", "Chinese", "Warrior", 422, Arrays.asList(item1, item7));
        God god5 = new God("Sobek", "Egyptian", "Guardian", 880, Arrays.asList(item1,item2,item6));

        // new up effects
        Effect effect1 = new Effect("Stun", "The affected god cannot move or use abilities");
        Effect effect2 = new Effect("Knock-up", "The affected god is knocked upwards");
        Effect effect3 = new Effect("Silence", "The affected god cannot use abilities");
        Effect effect4 = new Effect("Heal", "The affected god has health replenished");
        Effect effect5 = new Effect("Damage", "The affected god takes damage");
        Effect effect6 = new Effect("DamageOverTime", "The affected god takes damage every few game ticks");

        // new up abilities



        // other ways of structuring
        // new up items
        // new up god
        // new up abilities
        // new up effects

        // new up items
        // new up effects
        // new up abilities
        // new up gods

    }
}
