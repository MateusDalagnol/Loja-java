package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import application.Dados;
import model.Item;
import model.ItemEstoque;
import model.ItemPedido;
import model.Pedido;

public class PedidoService {

    ItemService is = new ItemService();

    public void addItem(Pedido pedido, Scanner sc) {
        System.out.println("Escolha um item: ");
        Item item = is.buscaItem(sc);
        if(item == null){
            return;
        }
        System.out.print("Digite uma quantidade/Peso: ");
        int quantidade = sc.nextInt();
        ItemPedido novoItem = new ItemPedido(item.getTipo(), item.getNome(), item.getUnidadeMedida(), item.getCodigoBarras(), item.getPreco(), quantidade);
        pedido.getItensPedido().add(novoItem);

    }

    public void removerItem(Pedido pedido, Scanner sc) {
        List<ItemPedido> itemPedidoList = pedido.getItensPedido();
        if (pedido.getItensPedido().isEmpty()) {
            System.out.println("Não a item no pedido");
            return;
        }

        ItemPedido itemPedido = is.buscaItemPedido(pedido, sc);
        itemPedidoList.remove(itemPedido);

    }


    public void removerPedido(Scanner sc) {
        List<Pedido> pedidoList = Dados.getPedidos();
        if(Dados.verificaListaVazia(pedidoList)){
            System.out.println("Não a pedidos cadastrados");
            return;
        }

        Pedido pedido = buscaPedido(sc);
        Dados.removerPedido(pedido);


    }

    public Pedido buscaPedido(Scanner sc){
        List<Pedido> pedidoList = Dados.getPedidos();
        if (Dados.verificaListaVazia(pedidoList)) {
            System.out.println("Não a pedido cadastrados");
            return null;
        }


        System.out.print("Id do pedido: ");
        int idPedido = sc.nextInt();

        for (Pedido pedido : pedidoList) {
            if (pedido.getId() == idPedido){
                return pedido;
            }
        }
        System.out.println("Pedido não encontrado.");
        return null;
    }
}
