package org.example;

public class ItemPedido {
    private int quantidade;
    private double precoUnitario; // Armazena o preço no momento da compra

    // Associação: ItemPedido referencia um Produto
    private Produto produto;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = produto.getPreco(); // Captura o preço atual do produto
    }

    public double calcularSubtotal() {
        return this.quantidade * this.precoUnitario;
    }

    // Métodos essenciais (Getters)
    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public Produto getProduto() {
        return produto;
    }
}