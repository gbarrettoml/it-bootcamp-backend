package com.market.example.service;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class Menu {

    public static Menu getInstance() {
        return new Menu();
    }

    public void execute() {
        int awnser = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("-------------- MENU ---------------");
            System.out.println(
                            "1 - Clientes\n" +
                            "2 - Produtos\n" +
                            "3 - Faturas\n" +
                            "0 - Sair");
            System.out.println("-----------------------------------");
            System.out.println("Escolha sua opção: ");
            awnser = sc.nextInt();

            switch (awnser) {
                case 1:
                    ClientService service = ClientService.getInstance();
                    service.execute();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    System.out.println("Programa encerrado!");
                    break;
                default:
                    System.out.println("Opção incorreta ou inexistente. Escolha novamente.");
            }

        } while(awnser != 0);

    }

}
