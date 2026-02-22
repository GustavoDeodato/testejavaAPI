package com.sincroteste.api.service;

import com.sincroteste.api.domain.Categoria.Categoria;
import com.sincroteste.api.domain.Item.Item;
import com.sincroteste.api.domain.Item.ItemRequestDTO;
import com.sincroteste.api.repositories.CategoriaRepositories;
import com.sincroteste.api.repositories.ItemRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    private ItemRepositories repository;
    @Autowired
    private CategoriaRepositories categoriaRepository;

    public Item createItem(ItemRequestDTO data){
        Categoria categoria = categoriaRepository.findById(data.categoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        
        Item newItem = new Item();
        newItem.setNome(data.nome());
        newItem.setSku(data.sku());
        newItem.setQuantidade(data.quantidade());
        newItem.setPreco(data.preco());
        newItem.setStatus(data.status());
        newItem.setCategoria(categoria);
        return repository.save(newItem);
    }
    public java.util.List<Item>getAllItems(){
        return repository.findAll();

    }
    public Item getbyidItems(Integer id){
        return repository.findById(id).orElse(null);
    }
    public boolean deleteItem(Integer id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
    public Item updateItem(Integer id, ItemRequestDTO data){
        Item item = repository.findById(id).orElse(null);
        Categoria categoria = categoriaRepository.findById(data.categoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        if(item != null){
            item.setNome(data.nome());
            item.setSku(data.sku());
            item.setQuantidade(data.quantidade());
            item.setPreco(data.preco());
            item.setStatus(data.status());
            item.setCategoria(categoria);
            return repository.save(item);
        }
        return null;
    }
    public java.util.List<Item> getItemsByCategoria(Integer categoriaId){
        return repository.findByCategoriaId(categoriaId);
    }














}
