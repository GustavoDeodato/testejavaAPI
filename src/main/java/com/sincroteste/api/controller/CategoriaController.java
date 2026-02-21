package com.sincroteste.api.controller;

import com.sincroteste.api.domain.Categoria.Categoria;
import com.sincroteste.api.domain.Categoria.CategoriaRequestDTO;
import com.sincroteste.api.service.CategoriaService;
import jdk.jfr.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriaController {


    @Autowired
    private CategoriaService categoriaService;
    @PostMapping
    public ResponseEntity<?> create(@RequestBody CategoriaRequestDTO body){
        try{
            Categoria newCategoria  = this.categoriaService.createCategoria(body);
            return ResponseEntity.status(201).body(newCategoria);
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Erro ao criar categoria: " + e.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity<List<Categoria>> getAll(){
        List<Categoria> categorias = this.categoriaService.getAllCategorias();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Categoria categoria = this.categoriaService.getbyidCategorias(id);
        if(categoria != null){
            return ResponseEntity.ok(categoria);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody CategoriaRequestDTO body){
        Categoria updatedCategoria = this.categoriaService.updateCategoria(id, body);
        if(updatedCategoria != null){
            return ResponseEntity.ok(updatedCategoria);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        boolean deleted = this.categoriaService.deleteCategoria(id);
        if(deleted){
            return ResponseEntity.ok("Categoria deletada com sucesso");
        }
        return ResponseEntity.notFound().build();
    }

}
