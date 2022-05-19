package com.example.smite_api.controllers;

import com.example.smite_api.models.Effect;
import com.example.smite_api.repositories.EffectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "effects")
public class EffectController {

    @Autowired
    EffectRepository effectRepository;

    // INDEX
    @GetMapping
    public ResponseEntity<List<Effect>> getEffects() {
        return new ResponseEntity<>(effectRepository.findAll(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Effect>> getEffectById(@PathVariable Long id) {
        var effect = effectRepository.findById(id);
        return new ResponseEntity<>(effect, effect.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Effect> createEffect(@RequestBody Effect effect) {
        effectRepository.save(effect);
        return new ResponseEntity<>(effect, HttpStatus.CREATED);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Effect> updateEffect(@PathVariable Long id, @RequestBody Effect effectUpdate) {
        var effect = effectRepository.findById(id);
        if (effect.isPresent()) {
            Effect _effect = effect.get();
            _effect.setName(effectUpdate.getName());
            _effect.setDesc(effectUpdate.getDesc());
            effectRepository.save(_effect);
            return new ResponseEntity<>(_effect, HttpStatus.OK);
        } else {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }

    // DESTROY
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> destroyEffectById(@PathVariable Long id) {
        try {
            effectRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
