package org.example;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private long idCategoria;
    private String nome;

    // Lista de produtos que pertencem a esta categoria
    private List<Produto> produtos;

    public Categoria(long idCategoria, String nome) {
        this.idCategoria = idCategoria;
        this.nome = nome;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    // Métodos essenciais (Getters e Setters)
    public long getIdCategoria() {
        return idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> listarProdutos() {
        return this.produtos;
    }
}