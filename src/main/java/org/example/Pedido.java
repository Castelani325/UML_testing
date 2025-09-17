package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private long idPedido;
    private LocalDate data;
    private String status;

    // Relação de Composição: Pedido "contém" ItemPedido
    private List<ItemPedido> itens;

    // Associação: Pedido pertence a um Cliente
    private Cliente cliente;

    public Pedido(long idPedido, Cliente cliente) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.data = LocalDate.now();
        this.status = "AGUARDANDO_PAGAMENTO";
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemPedido item) {
        this.itens.add(item);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : this.itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
    }

    // Métodos essenciais (Getters)
    public long getIdPedido() {
        return idPedido;
    }

    public LocalDate getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public Cliente getCliente() {
        return cliente;
    }
}