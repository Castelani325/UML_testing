package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cliente {
    private long idCliente;
    private String nome;
    private String email;
    private String endereco;

    // Relação de Composição: Cliente "tem um" Carrinho.
    // O carrinho é instanciado junto com o cliente.
    private Carrinho carrinho;

    // Associação: Cliente "faz" Pedidos
    private List<Pedido> historicoPedidos;

    public Cliente(long idCliente, String nome, String email, String endereco) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.carrinho = new Carrinho(); // Composição: Carrinho é criado com o Cliente
        this.historicoPedidos = new ArrayList<>();
    }

    public void adicionarPedido(Pedido pedido) {
        this.historicoPedidos.add(pedido);
    }

    // Exemplo de método que transforma o carrinho em um pedido
    public Pedido finalizarCompra(long idPedido) {
        Pedido novoPedido = new Pedido(idPedido, this);

        // Converte os itens do carrinho em itens de pedido
        for (Map.Entry<Produto, Integer> entry : this.carrinho.getItens().entrySet()) {
            ItemPedido item = new ItemPedido(entry.getKey(), entry.getValue());
            novoPedido.adicionarItem(item);
        }

        adicionarPedido(novoPedido); // Adiciona ao histórico
        this.carrinho.limparCarrinho(); // Limpa o carrinho após a compra

        return novoPedido;
    }

    // Métodos essenciais (Getters e Setters)
    public long getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public List<Pedido> getHistoricoPedidos() {
        return historicoPedidos;
    }
}