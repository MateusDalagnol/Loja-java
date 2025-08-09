package application;

import java.lang.ref.Cleaner;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import implementations_dao.DaoFactory;
import interface_dao.ClienteDao;
import model.Cliente;
import model.Item;
import model.ItemEstoque;
import model.Pedido;
import service.ClienteService;
import service.EstoqueService;
import service.ItemService;
import service.PedidoService;

public class UI {

    public static void menu(Scanner sc) {

        char opcao;
        do {
            System.out.println("\n=====MENU=====");
            System.out.println("1 - Cliente\n" +
                    "2 - Item\n" +
                    "3 - Pedido\n" +
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
                case '3':
                    menuPedido(sc);
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
        ClienteService is = new ClienteService();
        ClienteDao clienteDao = DaoFactory.createClienteDao();

        do {
            System.out.println("\n=====MENU CLIENTE=====");
            System.out.println("1 - Cadastrar Cliente\n" +
                    "2 - Remover Cliente\n" +
                    "3 - Buscar Cliente\n" +
                    "4 - Alterar Nome\n" +
                    "5 - Alterar Email\n" +
                    "6 - Listar Clientes\n" +
                    "0 - Voltar para o menu\n");
            System.out.print("Opção: ");

            opcao = sc.next().charAt(0);
            switch (opcao) {
                case '1':
                    sc.nextLine();
                    is.cadastroCliente(sc);
                    break;
                case '2':
                    sc.nextLine();
                    is.removerCliente(sc);
                    break;
                case '3':
                    sc.nextLine();
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    List<Cliente> clientes = clienteDao.findByName(nome);

                    if (clientes.isEmpty()) {
                        System.out.println("Lista Vazia");
                        break;
                    }
                    System.out.println("=====Lista de Cliente Encontrados=====");
                    for (Cliente eCliente : clientes) {
                        System.out.println(eCliente);
                    }
                    System.out.println(is.buscaCliente(sc));
                    break;
                case '4':
                    sc.nextLine();
                    is.alterarNome(sc);
                    break;
                case '5':
                    sc.nextLine();
                    is.alterarEmail(sc);
                    break;
                case '6':
                    List<Cliente> cList =  clienteDao.findAll();
                    if (cList.isEmpty()) {
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
        ItemService is = new ItemService();
        EstoqueService es = new EstoqueService();

        do {
            System.out.println("\n=====MENU ITEM=====");
            System.out.println("1 - Cadastrar Item\n" +
                    "2 - Remover Item\n" +
                    "3 - Verificar Item\n" +
                    "4 - Alterar Nome\n" +
                    "5 - Aumentar Quantidade\n" +
                    "6 - Listar Itens\n" +
                    "0 - Voltar para o menu\n");
            System.out.print("Opção: ");

            opcao = sc.next().charAt(0);
            switch (opcao) {
                case '1':
                    sc.nextLine();
                    ItemEstoque novoItem = is.cadastroItem(sc);
                    Dados.adicionarItemEstoque(novoItem);
                    break;
                case '2':
                    sc.nextLine();
                    is.removerItem(sc);
                    break;
                case '3':
                    sc.nextLine();
                    is.verificaItem(sc);
                    break;
                case '4':
                    sc.nextLine();
                    is.alterarNome(sc);
                    break;
                case '5':
                    sc.nextLine();
                    es.aumetarQuantidaEmEstoqueItem(sc);
                    break;
                case '6':
                    List<ItemEstoque> iList = Dados.getItemEstoques();
                    if (Dados.verificaListaVazia(iList)) {
                        System.out.println("Lista Vazia");
                        break;
                    }
                    System.out.println("=====Lista de itens cadastrado=====");
                    for (Item eItem : iList) {
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

    public static void menuPedido(Scanner sc) {
        char opcao;
        ClienteService cs = new ClienteService();
        PedidoService ps = new PedidoService();

        do {
            System.out.println("\n=====Menu Pedido=====");
            System.out.println("1 - Cadastrar novo pedido\n" +
                    "2 - Remover pedido\n" +
                    "3 - Alterar pedido\n" +
                    "4 - Listar pedidos\n" +
                    "0 - Voltar para o menu\n");

            System.out.print("Opção: ");
            opcao = sc.next().charAt(0);

            switch (opcao) {
                case '1':
                    sc.nextLine();
                    System.out.println("Adicione um cliente ao pedido: ");
                    Cliente cliente = cs.buscaCliente(sc);
                    if(cliente == null){
                        return;
                    }
                    menuCriarPedido(sc, cliente);
                    return;
                case '2':
                    sc.nextLine();
                    ps.removerPedido(sc);
                    break;
                case '3':
                    sc.nextLine();
                    menuAlterarPedido(sc, ps.buscaPedido(sc));
                    break;
                case '4':
                    sc.nextLine();
                    List<Pedido> pList = Dados.getPedidos();
                    if (Dados.verificaListaVazia(pList)) {
                        System.out.println("Lista Vazia");
                        break;
                    }
                    System.out.println("=====Lista de pedidos cadastrado=====");
                    for (Pedido ep: pList) {
                        System.out.println(ep);
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

    public static void menuCriarPedido(Scanner sc, Cliente cliente){
        char opcao;
        PedidoService ps= new PedidoService();
        Date data = new Date();
        Pedido novoPedido = new Pedido(cliente, data);

        do {
            System.out.println("\n=====Menu Criar Pedido=====");
            System.out.println("1 - Add item\n" +
                    "2 - Remover Item\n" +
                    "3 - Concluir pedido\n" +
                    "4 - Mostar resumo do pedido\n" +
                    "5 - Mostar estoque\n" +
                    "6 - Cancelar pedido\n");

            System.out.print("Opção: ");
            opcao = sc.next().charAt(0);

            switch (opcao) {
                case '1':
                    sc.nextLine();
                    ps.addItem(novoPedido, sc);
                    break;
                case '2':
                    sc.nextLine();
                    ps.removerItem(novoPedido, sc);
                    break;
                case '3':
                    sc.nextLine();
                    Dados.adicionarPedido(novoPedido);
                    return;
                case '4':
                    System.out.println(novoPedido);
                    break;
                case '5':{
                    List<ItemEstoque> iList = Dados.getItemEstoques();
                    if (Dados.verificaListaVazia(iList)) {
                        System.out.println("Lista Vazia");
                        break;
                    }
                    System.out.println("=====Lista de itens cadastrado=====");
                    for (Item eItem : iList) {
                        System.out.println(eItem);
                    }
                    break;
                }
                case '6':
                    System.out.println("\nVoltando para o menu principal...\n");
                    return;
                default:
                    break;
            }

        } while (opcao != '0');
    }

    public static void menuAlterarPedido(Scanner sc, Pedido pedido){

    }
}
