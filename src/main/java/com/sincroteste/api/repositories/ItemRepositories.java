package com.sincroteste.api.repositories;

import com.sincroteste.api.domain.Item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepositories extends JpaRepository<Item, Integer> {
}
