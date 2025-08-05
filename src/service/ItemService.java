package service;

import java.util.List;
import java.util.Scanner;

import application.Dados;
import enums.UnidadeMedida;
import model.ItemEstoque;

public class ItemService {

    public ItemEstoque cadastroItem(Scanner sc) {
    System.out.println("Cadastro de Item");
    System.out.print("Tipo: ");
    String tipo = sc.nextLine();
    System.out.print("Nome: ");
    String nome = sc.nextLine();
    System.out.print("Preço: ");
    double preco = sc.nextDouble();
    UnidadeMedida unidadeMedida = null;
    while (unidadeMedida == null) {
        System.out.print("Unidade de Medida (LITRO, QUILOGRAMA, UNIDADE): ");
        try {
            unidadeMedida = UnidadeMedida.valueOf(sc.nextLine().trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Unidade inválida. Tente novamente.");
        }
    }

    System.out.print("ID: ");
    String id = sc.nextLine();

    System.out.print("Quantidade: ");
    int quantidade = sc.nextInt();
    sc.nextLine();

    try {
        return new ItemEstoque(tipo, nome, unidadeMedida, id, preco, quantidade);
    } catch (IllegalArgumentException e) {
        System.out.println("Erro ao cadastrar item: " + e.getMessage());
        return null;
    }
}


    public void removerItem(Scanner sc) {
        List<ItemEstoque> iList = Dados.getItemEstoques();
        if (Dados.verificaListaVazia(iList)) {
            System.out.println("Não a Item cadastrados");
            return;
        }

        System.out.print("Id: ");
        String id = sc.nextLine();

        boolean encontrado = false;
        for (ItemEstoque item : iList) {
            if (item.getId().equalsIgnoreCase(id)) {
                Dados.removerItemEstoque(item);
                System.out.println("Item removido.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Item não encontrado.");
        }

    }

    public void verificaItem(Scanner sc) {
        ItemEstoque Item = buscaItem(sc);

        if (Item != null) {
            System.out.println("Item encontrado: " + Item.toString());
        } else {
            System.out.println("Item não existente");
        }
    }

    public ItemEstoque buscaItem(Scanner sc) {
        List<ItemEstoque> iList = Dados.getItemEstoques();
        if (Dados.verificaListaVazia(iList)) {
            System.out.println("Não a Item cadastrados");
            return null;
        }

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Id: ");
        String id = sc.nextLine();

        for (ItemEstoque item : iList) {
            if (item.getNome().equalsIgnoreCase(nome) && item.getId().equalsIgnoreCase(id)) {
                return item;
            }
        }
        System.out.println("Item não encontrado.");
        return null;

    }

    public void alterarNome(Scanner sc) {
        ItemEstoque Item = buscaItem(sc);
        if (Item == null) {
            return;
        }
        System.out.print("Digite o novo nome: ");
        sc.nextLine();
        String novoNome = sc.nextLine();

        Item.setNome(novoNome);
    }

    
}
