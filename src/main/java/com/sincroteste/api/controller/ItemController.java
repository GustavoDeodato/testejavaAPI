package com.sincroteste.api.controller;

import com.sincroteste.api.domain.Item.Item;
import com.sincroteste.api.domain.Item.ItemRequestDTO;
import com.sincroteste.api.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ItemRequestDTO body){
        try {
            Item newItem = itemService.createItem(body);
            return ResponseEntity.status(200).body(newItem);
        }catch (Exception e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}
