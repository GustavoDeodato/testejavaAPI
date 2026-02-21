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

}

