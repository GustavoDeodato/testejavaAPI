package com.sincroteste.api.domain.Item;


import com.sincroteste.api.domain.Categoria.Categoria;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //
    private Integer id;

    private String nome;
    private String sku;
    private int quantidade;
    private double preco;
    private String status;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Item(){

    }
    public Item(Integer id, String nome, String sku, int quantidade, double preco, String status, Categoria categoria) {
        if (nome == null || nome.isEmpty() || nome.length() > 100 ||
            sku == null || sku.isEmpty() || sku.length() > 50 ||
            quantidade < 0 ||
            preco < 0.0 ||
            (status != null && status.length() > 20) ||
            categoria == null) {
            throw new IllegalArgumentException("Dados inválidos");
        }

        this.id = id;
        this.nome = nome;
        this.sku = sku;
        this.quantidade = quantidade;
        this.preco = preco;
        this.status = status;
        this.categoria = categoria;
    }


    //getters e setters

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || nome.length() > 100) {
            throw new IllegalArgumentException("Nome inválido");
        }
        this.nome = nome;
    }

    public String getSku() { return sku; }
    public void setSku(String sku) {
        if (sku == null || sku.isEmpty() || sku.length() > 50) {
            throw new IllegalArgumentException("SKU inválido");
        }
        this.sku = sku;
    }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade inválida");
        }
        this.quantidade = quantidade;
    }

    public double getPreco() { return preco; }
    public void setPreco(double preco) {
        if (preco < 0.0) {
            throw new IllegalArgumentException("Preço inválido");
        }
        this.preco = preco;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) {
        if (status != null && status.length() > 20) {
            throw new IllegalArgumentException("Status inválido");
        }
        this.status = status;
    }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("Categoria inválida");
        }
        this.categoria = categoria;
    }

    public static record ItemRequestDTO() {
    }
}
