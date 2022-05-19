package com.example.smite_api.controllers;


import com.example.smite_api.models.Ability;
import com.example.smite_api.repositories.AbilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "abilities")
public class AbilityController {

    @Autowired
    AbilityRepository abilityRepository;

    // INDEX
    @GetMapping
    public ResponseEntity<List<Ability>> getAbilitys() {
        return new ResponseEntity<>(abilityRepository.findAll(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Ability>> getAbilityById(@PathVariable Long id) {
        var ability = abilityRepository.findById(id);
        return new ResponseEntity<>(ability, ability.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Ability> createAbility(@RequestBody Ability ability) {
        abilityRepository.save(ability);
        return new ResponseEntity<>(ability, HttpStatus.CREATED);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Ability> updateAbility(@PathVariable Long id, @RequestBody Ability abilityUpdate) {
        var ability = abilityRepository.findById(id);
        if (ability.isPresent()) {
            Ability _ability = ability.get();
            _ability.setName(abilityUpdate.getName());
            _ability.setDesc(abilityUpdate.getDesc());
            _ability.setCooldown(abilityUpdate.getCooldown());
            _ability.setGod(abilityUpdate.getGod());
            _ability.setEffects(abilityUpdate.getEffects());
            abilityRepository.save(_ability);
            return new ResponseEntity<>(_ability, HttpStatus.OK);
        } else {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }

    // DESTROY
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> destroyAbilityById(@PathVariable Long id) {
        try {
            abilityRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
