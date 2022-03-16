package com.market.example.service;

import com.market.example.model.Account;
import com.market.example.model.Client;
import com.market.example.model.Product;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class AccountService {

    private static AccountService instance;

    private static final Map<Integer, Account> accountList = new HashMap<>();
    private int globalId = 1;

    public static AccountService getInstance() {
        if(instance == null) {
            return new AccountService();
        }
        return instance;
    }


    public void execute(ClientService clientService, ProductService productService) {
        int awnser = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("----------- MENU FATURA -----------");
            System.out.println(
                    "1 - Criar fatura\n" +
                            "2 - Listar faturas\n" +
                            "3 - Buscar fatura por id\n" +
                            "4 - Apagar fatura\n" +
                            "0 - Voltar");
            System.out.println("-----------------------------------");
            System.out.println("Escolha sua opção: ");
            awnser = sc.nextInt();

            switch (awnser) {
                case 1:
                    register(clientService, productService);
                    break;
                case 2:
                    findAll();
                    break;
                case 3:
                    findById();
                    break;
                case 4:
                    deleteById();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção incorreta ou inexistente. Tente novamente");
            }
        } while (awnser != 0);
    }

    private void findAccount(Integer id) {
        Account accountSearched = accountList.get(id);
        if(accountSearched == null) System.out.println("Erro! Fatura inexistente ou não encontrada");
        else System.out.println(accountSearched.toString());
    }

    private void deleteAccount(Integer id) {
        Account accountDeleted = accountList.remove(id);
        if(accountDeleted == null) System.out.println("Erro! Fatura inexistente ou não encontrada");
    }


    private void register(ClientService clientService, ProductService productService) {
        Scanner sc = new Scanner(System.in);
        String awnser = null;
        System.out.println("Informe o id do cliente: ");
        Integer clientId = sc.nextInt();
        Client client = clientService.getClientList().get(clientId);
        if(client == null) {
            System.out.println("Cliente não encontrado. Deseja cadastrá-lo? y/n");
            awnser = sc.next().toLowerCase(Locale.ROOT);
            if(awnser.equals("y")) client = clientService.register();
            else return;
        }

        Account account = new Account(client);
        addingProducts(sc, awnser, client, account, productService);

    }

    private void findAll() {
        accountList.entrySet().forEach(System.out::println);
    }

    private void findById() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o id da fatura que você deseja encontrar: ");
        Integer id = sc.nextInt();
        findAccount(id);
    }

    private void deleteById() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o id da fatura que deseja deletar: ");
        Integer id = sc.nextInt();
        deleteAccount(id);
    }

    private void addingProducts(Scanner sc, String awnser, Client client, Account account, ProductService productService) {
        do {
            System.out.println("Informe o código do produto: ");
            String code = sc.next();
            Product product = productService.getProductList().get(code);
            if(product == null) {
                System.out.println("Produto não encontrado. Deseja cadastrá-lo? y/n");
                awnser = sc.next().toLowerCase(Locale.ROOT);
                if(awnser.equals("y")) product = productService.register();
                else return;
            }
            account.addProduct(product);
            System.out.println("Deseja cadastrar mais um produto? y/n");
            awnser = sc.next();
        } while (awnser.equals("y"));
        account.totalCalculation();
        System.out.println("Sua conta final é: ");
        System.out.println(account.toString());
        System.out.println("Escreva y para confirmar a fatura ou n para descartar: y/n");
        awnser = sc.next();
        if(awnser.equals("y")) {
            accountList.put(globalId, account);
            globalId++;
        }
    }
}
