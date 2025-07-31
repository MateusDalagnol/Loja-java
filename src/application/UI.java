package application;

import java.util.List;
import java.util.Scanner;

import model.Cliente;
import service.ClienteService;

public class UI {

    public static void menu(Scanner sc) {

        System.out.println("=====MENU=====");
        System.out.println("1 - Cliente");
        System.out.print("Opção: ");

        char opcao = sc.next().charAt(0);
        switch (opcao) {
            case '1':
                menuCliente(sc);
                break;
            case '2':
                break;
            default:
                break;
        }
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
                    "6 - Listar Clientes");
            System.out.print("\nOpção: ");

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
                default:
                    break;
            }
        } while (opcao != '0');
    }
}
