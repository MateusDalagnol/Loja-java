package application;

import java.util.List;
import java.util.Scanner;

import model.Cliente;
import model.Item;
import model.ItemEstoque;
import service.ClienteService;
import service.ItemService;

public class UI {

    public static void menu(Scanner sc) {

        char opcao;
        do {
            System.out.println("=====MENU=====");
            System.out.println("1 - Cliente\n" +
                    "2 - Item\n" +
                    "0 - Sair do programa\n");
            System.out.print("Opção: ");
            opcao = sc.next().charAt(0);
            switch (opcao) {
                case '1':
                    menuCliente(sc);
                    break;
                case '2':
                    menuItem(sc);
                    break;
                case '0':
                    System.out.println("Encerrando programa....");
                    break;
                default:
                    break;
            }
        } while (opcao != '0');
    }

    public static void menuCliente(Scanner sc) {
        char opcao;
        do {
            System.out.println("\n=====MENU CLIENTE=====");
            System.out.println("1 - Cadastrar Cliente\n" +
                    "2 - Remover Cliente\n" +
                    "3 - Verificar Cliente\n" +
                    "4 - Alterar Nome\n" +
                    "5 - Alterar Email\n" +
                    "6 - Listar Clientes\n" +
                    "0 - Voltar para o menu\n");
            System.out.print("Opção: ");

            ClienteService cs = new ClienteService();

            opcao = sc.next().charAt(0);
            switch (opcao) {
                case '1':
                    sc.nextLine();
                    Cliente novoCliente = cs.cadastroCliente(sc);
                    Dados.adicionarCliente(novoCliente);
                    break;
                case '2':
                    sc.nextLine();
                    cs.removerCliente(sc);
                    break;
                case '3':
                    sc.nextLine();
                    cs.verificaCliente(sc);
                    break;
                case '4':
                    sc.nextLine();
                    cs.alterarNome(sc);
                    break;
                case '5':
                    sc.nextLine();
                    cs.alterarEmail(sc);
                    break;
                case '6':
                    List<Cliente> cList = Dados.getClientes();

                    if (Dados.verificaListaVazia(cList)) {
                        System.out.println("Lista Vazia");
                        break;
                    }
                    System.out.println("=====Lista de Cliente cadastrado=====");
                    for (Cliente eCliente : cList) {
                        System.out.println(eCliente);
                    }
                    break;
                case '0':
                    System.out.println("\nVoltando para o menu principal...\n");
                    break;
                default:
                    break;
            }
        } while (opcao != '0');
    }

    public static void menuItem(Scanner sc) {
        char opcao;
        do {
            System.out.println("\n=====MENU ITEM=====");
            System.out.println("1 - Cadastrar Item\n" +
                    "2 - Remover Item\n" +
                    "3 - Verificar Item\n" +
                    "4 - Alterar Nome\n" +
                    "5 - Alterar Email\n" +
                    "6 - Listar Itens\n" +
                    "0 - Voltar para o menu\n");
            System.out.print("Opção: ");

            ItemService cs = new ItemService();

            opcao = sc.next().charAt(0);
            switch (opcao) {
                case '1':
                    sc.nextLine();
                    ItemEstoque novoItem = cs.cadastroItem(sc);
                    Dados.adicionarItemEstoque(novoItem);
                    break;
                case '2':
                    sc.nextLine();
                    cs.removerItem(sc);
                    break;
                case '3':
                    sc.nextLine();
                    cs.verificaItem(sc);
                    break;
                case '4':
                    sc.nextLine();
                    cs.alterarNome(sc);
                    break;
                case '5':
                    sc.nextLine();
                    break;
                case '6':
                    List<ItemEstoque> cList = Dados.getItemEstoques();

                    if (Dados.verificaListaVazia(cList)) {
                        System.out.println("Lista Vazia");
                        break;
                    }
                    System.out.println("=====Lista de itens cadastrado=====");
                    for (Item eItem : cList) {
                        System.out.println(eItem);
                    }
                    break;
                case '0':
                    System.out.println("\nVoltando para o menu principal...\n");
                    break;
                default:
                    break;
            }
        } while (opcao != '0');
    }
}
