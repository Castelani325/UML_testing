package org.example;

import java.util.HashMap;
import java.util.Map;

public class Carrinho {
    // Usamos um Map para associar um Produto a uma quantidade (Integer)
    private Map<Produto, Integer> itens;

    public Carrinho() {
        this.itens = new HashMap<>();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        // Se o produto já existe no carrinho, apenas atualiza a quantidade
        this.itens.put(produto, this.itens.getOrDefault(produto, 0) + quantidade);
    }

    public void removerProduto(Produto produto) {
        this.itens.remove(produto);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Map.Entry<Produto, Integer> entry : itens.entrySet()) {
            Produto produto = entry.getKey();
            Integer quantidade = entry.getValue();
            total += produto.getPreco() * quantidade;
        }
        return total;
    }

    public void limparCarrinho() {
        this.itens.clear();
    }

    public Map<Produto, Integer> getItens() {
        // Retorna uma cópia para evitar modificação externa indesejada
        return new HashMap<>(this.itens);
    }
}