package com.sincroteste.api.domain.Item;

import com.sincroteste.api.domain.Categoria.Categoria;

public record ItemRequestDTO (String nome, String sku, int quantidade, double preco, String status, Categoria categoria)  {

}
