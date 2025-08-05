package application;

import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.ItemEstoque;
import model.Pedido;

public class Dados {
    private static List<ItemEstoque> itemEstoques = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();

    public static void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public static void removerCliente(Cliente cliente){
        clientes.remove(cliente);
    }

    public static void adicionarPedido(Pedido pedido){
        pedidos.add(pedido);
    }

    public static void removerPedido(Pedido pedido){
        pedidos.remove(pedido);
    }

    public static void adicionarItemEstoque(ItemEstoque item) {
        itemEstoques.add(item);
    }

    public static void removerItemEstoque(ItemEstoque item) {
        itemEstoques.remove(item);
    }

    public static List<Cliente> getClientes() {
        return new ArrayList<>(clientes);
    }

    public static List<ItemEstoque> getItemEstoques() {
        return new ArrayList<>(itemEstoques);
    }

    public static List<Pedido> getPedidos(){
        return new ArrayList<>(pedidos);
    }

    public static boolean verificaListaVazia(List<?> l){
        return l.isEmpty();
    }
}
