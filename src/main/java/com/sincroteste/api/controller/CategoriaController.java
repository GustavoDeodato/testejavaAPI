package com.sincroteste.api.controller;

import com.sincroteste.api.domain.Categoria.Categoria;
import com.sincroteste.api.domain.Categoria.CategoriaRequestDTO;
import com.sincroteste.api.service.CategoriaService;
import jdk.jfr.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoriaController {


    @Autowired
    private CategoriaService categoriaService;
     @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody CategoriaRequestDTO body){
        Categoria newCategoria  = this.categoriaService.createCategoria(body);
        return ResponseEntity.ok(newCategoria);
    }
}
