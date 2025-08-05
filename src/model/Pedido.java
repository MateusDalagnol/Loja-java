package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Pedido {

    private Cliente cliente;
    private List<ItemPedido> itensPedido = new ArrayList<>();
    private Date data;

    public Pedido(Cliente cliente, Date data) {
        this.cliente = cliente;
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente + ", itensPedido: " + itensPedido + ", data: " + data;
    }
}
