package com.sincroteste.api.service;

import com.sincroteste.api.domain.Categoria.Categoria;
import com.sincroteste.api.domain.Categoria.CategoriaRequestDTO;
import com.sincroteste.api.repositories.CategoriaRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepositories repository;

    public Categoria createCategoria(CategoriaRequestDTO data){
        Categoria newCategoria = new Categoria();
        newCategoria.setNome(data.nome());
        newCategoria.setDescricao(data.descricao());
        return repository.save(newCategoria);
    }

    public java.util.List<Categoria> getAllCategorias(){
        return repository.findAll();
    }
    public Categoria getbyidCategorias(Integer id){
        return repository.findById(id).orElse(null);
    }

    public boolean deleteCategoria(Integer id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public Categoria updateCategoria(Integer id, CategoriaRequestDTO data){
        Categoria categoria = repository.findById(id).orElse(null);
        if(categoria != null){
            categoria.setNome(data.nome());
            categoria.setDescricao(data.descricao());
            return repository.save(categoria);
        }
        return null;
    }

}

