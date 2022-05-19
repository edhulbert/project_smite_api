package com.example.smite_api.controllers;

import com.example.smite_api.models.God;
import com.example.smite_api.repositories.GodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("gods")
public class GodController {

    @Autowired
    GodRepository godRepository;

    @GetMapping
    public ResponseEntity<List<God>> getGods() {
        return new ResponseEntity<>(godRepository.findAll(), HttpStatus.OK);
    }
}
