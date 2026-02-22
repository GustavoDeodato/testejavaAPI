package com.sincroteste.api.repositories;

import com.sincroteste.api.domain.Item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepositories extends JpaRepository<Item, Integer> {
    List<Item> findByCategoriaId(Integer categoriaId);
}
