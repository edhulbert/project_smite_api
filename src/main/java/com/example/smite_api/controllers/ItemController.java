package com.example.smite_api.controllers;

import com.example.smite_api.models.Item;
import com.example.smite_api.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "items")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;


    // INDEX
    @GetMapping
    public ResponseEntity<List<Item>> getItems() {
        return new ResponseEntity<>(itemRepository.findAll(), HttpStatus.OK);
    }


    // SHOW
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Item>> getItemById(@PathVariable Long id) {
        var item = itemRepository.findById(id);
        return new ResponseEntity<>(item, item.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        itemRepository.save(item);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item itemUpdate) {
        var item = itemRepository.findById(id);
        if (item.isPresent()) {
            Item _item = item.get();
            _item.setName(itemUpdate.getName());
            _item.setDesc(itemUpdate.getDesc());
            _item.setTier(itemUpdate.getTier());
            _item.setPrice(itemUpdate.getPrice());
            itemRepository.save(_item);
            return new ResponseEntity<>(_item, HttpStatus.OK);
        } else {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }

    // DESTROY
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> destroyItemById(@PathVariable Long id) {
        try {
            itemRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
