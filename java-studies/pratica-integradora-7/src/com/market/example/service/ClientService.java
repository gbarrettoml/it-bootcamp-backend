package com.market.example.service;

import com.market.example.model.Client;

import java.util.*;

public class ClientService implements CRUD<Client> {

    private static ClientService instance;
    private static final Map<Integer, Client> clientList = new HashMap<>();
    private int globalId = 1;

    public Map<Integer, Client> getClientList() {
        return clientList;
    }

    private void registerClient(Client client) {
        clientList.put(client.getId(), client);

    }

    private void removeClient(Integer id) {
        Client clientRemoved = clientList.remove(id);
        if(clientRemoved == null) {
            System.out.println("Erro! Cliente inexistente ou não encontrado.");
        } else {
            System.out.println("Cliente apagado com sucesso!");
        }
    }

    private void findClient(Integer id) {
        Client clientSearched = clientList.get(id);
        if(clientSearched == null) {
            System.out.println("Erro! Cliente inexistente ou não encontrado.");
        } else {
            System.out.println(clientSearched.toString());
        }
    }

    public static ClientService getInstance() {
        if(instance == null) {
            return new ClientService();
        }
        return instance;
    }

    public void execute() {
        int awnser = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("----------- MENU CLIENTE -----------");
            System.out.println(
                    "1 - Cadastrar cliente\n" +
                            "2 - Listar clientes\n" +
                            "3 - Buscar por id\n" +
                            "4 - Apagar cliente\n" +
                            "0 - Voltar");
            System.out.println("-----------------------------------");
            System.out.println("Escolha sua opção: ");
            awnser = sc.nextInt();

            switch (awnser) {
                case 1:
                    register();
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

    public Client register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o nome");
        String name = sc.next();
        System.out.println("Insira o sobrenome");
        String surname = sc.next();
        Client client = new Client(globalId, name, surname);
        registerClient(client);
        globalId++;
        return client;

    }

    public void findAll() {
        clientList.entrySet().forEach(System.out::println);
    }

    public void deleteById() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o id do cliente que deseja remover: ");
        Integer id = sc.nextInt();
        removeClient(id);
    }

    public void findById() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o id do cliente que você deseja encontrar: ");
        Integer id = sc.nextInt();
        findClient(id);
    }
}
