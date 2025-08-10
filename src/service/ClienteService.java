package service;

import java.util.List;
import java.util.Scanner;

import application.Dados;
import implementations_dao.DaoFactory;
import interfaces_dao.ClienteDao;
import model.Cliente;

public class ClienteService {

    ClienteDao clienteDao = DaoFactory.createClienteDao();

    public void cadastroCliente(Scanner sc) {

        System.out.println("Cadastro");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        Cliente cliente = new Cliente(nome, email);
        clienteDao.insert(cliente);
    }

    public void removerCliente(Scanner sc) {
        List<Cliente> clist = clienteDao.findAll();
        if (Dados.verificaListaVazia(clist)) {
            System.out.println("Não a cliente cadastrados");
            return;
        }

        Cliente cliente = buscaCliente(sc);
        if(cliente == null){
                System.out.println("Nenhum cliente encontrado com esse ID.");
                return;
        }
        clienteDao.deleteById(cliente.getId());

    }



    public void verificaCliente(Scanner sc) {
        Cliente cliente = buscaCliente(sc);

        if (cliente == null) {
            System.out.println("Usuario não existente");
        }
    }

    public Cliente buscaCliente(Scanner sc) {

        List<Cliente> clist = clienteDao.findAll();
        if (clist.isEmpty()) {
            System.out.println("Não a cliente cadastrados");
            return null;
        }

        System.out.print("ID: ");
        int id = sc.nextInt();

        return clienteDao.findById(id);
    }

    public void alterarNome(Scanner sc) {
        Cliente cliente = buscaCliente(sc);
        if(cliente == null){
            return;
        }
        System.out.print("Digite o novo nome: ");
        sc.nextLine();
        String novoNome = sc.nextLine();

        clienteDao.updateNome(novoNome, cliente.getId());

    }

    public void alterarEmail(Scanner sc) {
        Cliente cliente = buscaCliente(sc);
        if(cliente == null){
            return;
        }
        System.out.print("Digite o novo email: ");
        sc.nextLine();
        String novoEmail = sc.nextLine();

        clienteDao.updateEmail(novoEmail, cliente.getId());
    }

}
