package com.sincroteste.api.domain.Item;

public record ItemRequestDTO (String nome, String sku, int quantidade, double preco, String status, String localizacao, Integer categoriaId)  {

}
