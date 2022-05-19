package com.example.smite_api.controllers;

import com.example.smite_api.models.God;
import com.example.smite_api.repositories.GodRepository;
import org.aspectj.weaver.patterns.ReferencePointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("gods")
public class GodController {

    @Autowired
    GodRepository godRepository;

    // INDEX
    @GetMapping
    public ResponseEntity<List<God>> getGods() {
        return new ResponseEntity<>(godRepository.findAll(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping("/{id}")
    public ResponseEntity<Optional<God>> getGodById(@PathVariable Long id) {
        var god = godRepository.findById(id);
        return new ResponseEntity<>(god, god.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    // CREATE
    @PostMapping
    public ResponseEntity<God> createGod(@RequestBody God god) {
        godRepository.save(god);
        return new ResponseEntity<>(god, HttpStatus.CREATED);
    }

    // DESTROY
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> destroyGodById(@PathVariable Long id) {
        try {
            godRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
