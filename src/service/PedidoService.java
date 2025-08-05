package service;

import java.util.Scanner;

import model.Item;
import model.ItemPedido;
import model.Pedido;

public class PedidoService {
    
    ItemService is = new ItemService();

    public void addItem(Pedido pedido, Scanner sc){
        System.out.println("Escolha um item: ");
        Item item = is.buscaItem(sc);
        System.out.print("Digite uma quantidade/Peso: ");
        int quantidade = sc.nextInt();
        ItemPedido novoItem = new ItemPedido(item.getTipo(), item.getNome(), item.getUnidadeMedida(), item.getId(), item.getPreco(), quantidade);
        pedido.getItensPedido().add(novoItem);

    }

    public void removerItem(Pedido pedido, Scanner sc){
        Item item = is.buscaItem(sc);
    }
}
