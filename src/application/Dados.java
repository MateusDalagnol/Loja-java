package application;

import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.ItemEstoque;

public class Dados {
    private static List<ItemEstoque> itemEstoques = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();

    public static void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public static void adicionarItemEstoque(ItemEstoque item) {
        itemEstoques.add(item);
    }

    public static List<Cliente> getClientes() {
        return new ArrayList<>(clientes); // retorna uma cópia, evitando alteração direta
    }

    public static List<ItemEstoque> getItemEstoques() {
        return new ArrayList<>(itemEstoques);
    }
}
