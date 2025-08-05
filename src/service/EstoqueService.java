package service;

import java.util.Scanner;

import model.ItemEstoque;

public class EstoqueService {
    public void aumetarQuantidaEmEstoqueItem(Scanner sc){
        System.out.println("Qual item dejesa aumentar a quantidade: ");
        ItemService itemService = new ItemService();
        ItemEstoque itemEstoque = itemService.buscaItem(sc);
        if(itemEstoque == null){
            return;
        }
        System.out.print("Quantas unidades deseja aumentar: ");
        int quantidade = sc.nextInt();
        itemEstoque.setQuantidade(quantidade);
    }
}
