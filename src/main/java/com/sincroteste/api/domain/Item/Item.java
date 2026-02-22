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
    public void setNome(String nome) { this.nome = nome; }

    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public static record ItemRequestDTO() {
    }
}
