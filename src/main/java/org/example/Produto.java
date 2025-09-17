package org.example;

import java.util.ArrayList;
import java.util.List;

public class Produto {
    private long idProduto;
    private String nome;
    private String descricao;
    private double preco;

    // Referência à(s) categoria(s) do produto
    private List<Categoria> categorias;

    public Produto(long idProduto, String nome, double preco, String descricao) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.categorias = new ArrayList<>();
    }

    public void adicionarCategoria(Categoria categoria) {
        this.categorias.add(categoria);
        categoria.adicionarProduto(this); // Garante a via dupla da associação
    }

    // Métodos essenciais (Getters e Setters)
    public long getIdProduto() {
        return idProduto;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }
}