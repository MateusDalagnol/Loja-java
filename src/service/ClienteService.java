package service;

import java.util.List;
import java.util.Scanner;

import application.Dados;
import model.Cliente;

public class ClienteService {

    public Cliente cadastroCliente(Scanner sc) {

        System.out.println("Cadastro");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        Cliente cliente = new Cliente(nome, email);
        return cliente;
    }

    public void removerCliente(Scanner sc) {
        List<Cliente> clist = Dados.getClientes();
        if (Dados.verificaListaVazia(clist)) {
            System.out.println("Não a cliente cadastrados");
            return;
        }

        Cliente cliente = buscaCliente(sc);
        Dados.removerCliente(cliente);
    }



    public void verificaCliente(Scanner sc) {
        Cliente cliente = buscaCliente(sc);

        if (cliente != null) {
            System.out.println("Cliente encontrado: " + cliente.toString());
        } else {
            System.out.println("Usuario não existente");
        }
    }

    public Cliente buscaCliente(Scanner sc) {
        List<Cliente> clist = Dados.getClientes();
        if (Dados.verificaListaVazia(clist)) {
            System.out.println("Não a cliente cadastrados");
            return null;
        }

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Id: ");
        int id = sc.nextInt();

        for (Cliente cliente : clist) {
            if (cliente.getNome().equals(nome) && cliente.getId() == id) {
                return cliente;
            }
        }
        System.out.println("Usuario não existente");
        return null;

    }

    public void alterarNome(Scanner sc) {
        Cliente cliente = buscaCliente(sc);
        if(cliente == null){
            return;
        }
        System.out.print("Digite o novo nome: ");
        sc.nextLine();
        String novoNome = sc.nextLine();

        cliente.setNome(novoNome);
    }

    public void alterarEmail(Scanner sc) {
        Cliente cliente = buscaCliente(sc);
        if(cliente == null){
            return;
        }
        System.out.print("Digite o novo email: ");
        sc.nextLine();
        String novoEmail = sc.nextLine();

        cliente.setEmail(novoEmail);
    }

}
