package com.sincroteste.api.controller;

import com.sincroteste.api.domain.Item.Item;
import com.sincroteste.api.domain.Item.ItemRequestDTO;
import com.sincroteste.api.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody ItemRequestDTO body){
        try {
            Item newItem = itemService.createItem(body);
            return ResponseEntity.status(200).body(newItem);
        }catch (Exception e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity<List<Item>>getAll(){
        List<Item> Items = this.itemService.getAllItems();
        return ResponseEntity.status(200).body(Items);
    }

    @GetMapping("{/id}")
    public ResponseEntity<?> getbyiditems(@PathVariable Integer id){
            Item item = this.itemService.getbyidItems(id);
            if (item != null){
                return ResponseEntity.status(200).body(item);
            }
            return ResponseEntity.notFound().build();
    }
}
