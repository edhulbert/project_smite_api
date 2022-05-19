package com.example.smite_api.components;

import com.example.smite_api.models.Ability;
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
        God god1 = new God("Thor", "Norse", "Assassin", 634, Arrays.asList(item3, item4, item6));
        God god2 = new God("Aphrodite", "Greek", "Mage", 2600, Arrays.asList(item9));
        God god3 = new God("Ah Muzen Cab", "Maya", "Hunter", 3, Arrays.asList(item3, item4, item8));
        God god4 = new God("Sun Wukong", "Chinese", "Warrior", 422, Arrays.asList(item1, item7));
        God god5 = new God("Sobek", "Egyptian", "Guardian", 880, Arrays.asList(item1,item2,item6));

        // new up effects
        Effect effect1 = new Effect("Stun", "The affected god cannot move or use abilities");
        Effect effect2 = new Effect("Knock-back", "The affected god is knocked backwards");
        Effect effect3 = new Effect("Silence", "The affected god cannot use abilities");
        Effect effect4 = new Effect("Heal", "The affected god has health replenished");
        Effect effect5 = new Effect("Damage", "The affected god takes damage");
        Effect effect6 = new Effect("DamageOverTime", "The affected god takes damage every few game ticks");
        Effect effect7 = new Effect("Slow", "The affected god's movement speed is reduced");

        // new up abilities
        Ability ability1 = new Ability(
                "Tectonic Rift",
                "Thor slams his hammer on the ground, causing a fissure to appear in front of him, Stunning enemies and blocking movement.",
                10,
                god1,
                Arrays.asList(effect1));
        Ability ability2 = new Ability(
                "Anvil of Dawn",
                "Thor leaps into the air. Thor can target a great distance away to come crashing down in the area, dealing damage and Stunning all enemies in the radius.",
                120,
                god1,
                Arrays.asList(effect1, effect5));
        Ability ability3 = new Ability(
                "Back Off!",
                "Aphrodite commands enemies to get away from her, doing damage around her, slowing them by 25% for 2s and knocking them back.",
                12,
                god2,
                Arrays.asList(effect2, effect5, effect7));
        Ability ability4 = new Ability(
                "Love Birds",
                "Aphroditie calls forth a flock of doves that damage enemies and heal allies",
                15,
                god2,
                Arrays.asList(effect4, effect6));
        Ability ability5 = new Ability(
                "Stinger",
                "Ah Muzen Cab fires off an enormous stinger that deals damage to all enemies in a line, sticking into the first god that is hit, applying DOT and Slowing",
                150,
                god3,
                Arrays.asList(effect5, effect6));
        Ability ability6 = new Ability(
                "The Magic Cudgel",
                "Sun Wukong's Magic Cudgel grows in length, and he slams it down, damaging all enemies in front of him.",
                12,
                god4,
                Arrays.asList(effect5));
        Ability ability7 = new Ability(
                "Tail Whip",
                "Sobek whips around in a circle, knocking enemies back and doing damage.",
                20,
                god5,
                Arrays.asList(effect2, effect5));
        Ability ability8 = new Ability(
                "Sickening Strike",
                "Sobek does an axe attack that damages all enemies in front of him. In addition, Sobek heals for each enemy hit.",
                15,
                god5,
                Arrays.asList(effect5, effect4));
        Ability ability9 = new Ability(
                "Tectonic Rift",
                "",
                10,
                god1,
                Arrays.asList(effect1));

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
