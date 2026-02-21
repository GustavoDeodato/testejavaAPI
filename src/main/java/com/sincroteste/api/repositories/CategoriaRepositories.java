package com.sincroteste.api.repositories;

import com.sincroteste.api.domain.Categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositories extends JpaRepository<Categoria, Integer> {
}
