package application;

import java.util.Scanner;

import service.LerAquivo;

public class Main {
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
        LerAquivo.lerArquivoCsvItem();
        LerAquivo.lerArquivoCsvCliente();
        UI.menu(sc);

    }
}
