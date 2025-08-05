package service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import application.Dados;
import enums.UnidadeMedida;
import model.Cliente;
import model.ItemEstoque;

public class LerAquivo {

    public static void lerArquivoCsvItem() {
        String arquivo = "dadosItens.csv";
        BufferedReader br = null;
        String linha = "";

        try {
            br = new BufferedReader(new FileReader(arquivo));
            while ((linha = br.readLine()) != null) {
                String[] valor = linha.split(",");
                Dados.adicionarItemEstoque(new ItemEstoque(valor[0], valor[1], UnidadeMedida.valueOf(valor[2]),
                        valor[3], Double.parseDouble(valor[4]), Integer.parseInt(valor[5])));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + arquivo);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo.");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao converter unidade de medida: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void lerArquivoCsvCliente() {
        String arquivo = "dadosCliente.csv";
        BufferedReader br = null;
        String linha = "";

        try {
            br = new BufferedReader(new FileReader(arquivo));
            while ((linha = br.readLine()) != null) {
                String[] valor = linha.split(",");
                Dados.adicionarCliente(new Cliente(valor[0], valor[1]));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + arquivo);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo.");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao converter unidade de medida: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
