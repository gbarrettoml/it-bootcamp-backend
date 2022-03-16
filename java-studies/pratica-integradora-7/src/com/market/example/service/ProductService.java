package com.market.example.service;

import com.market.example.model.Product;

import javax.script.ScriptContext;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductService implements CRUD<Product> {

    private static ProductService instance;

    private static final Map<String, Product> productList = new HashMap<>();
    private int globalId = 1;

    public static ProductService getInstance() {
        if(instance == null) {
            return new ProductService();
        }
        return instance;
    }

    private void registerProduct(Product product) {
        productList.put(product.getCode(), product);
    }

    private void removeProduct(String code) {
        Product productRemoved = productList.remove(code);
        if(productRemoved == null) System.out.println("Erro! Produto inexistente ou não encontrado");
        else System.out.println("Produto apagado com sucesso!");
    }

    private void findProduct(String code) {
        Product productSearched = productList.get(code);
        if(productSearched == null) System.out.println("Erro! Produto inexistente ou não encontrado");
        else System.out.println(productSearched.toString());
    }

    public Map<String, Product> getProductList() {
        return productList;
    }

    public void execute() {
        int awnser = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("----------- MENU PRODUTOS -----------");
            System.out.println(
                    "1 - Criar produto\n" +
                            "2 - Listar produtos\n" +
                            "3 - Buscar produto por id\n" +
                            "4 - Apagar produto\n" +
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

    public Product register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o código:");
        String code = sc.next();
        System.out.println("Informe o nome do produto:");
        String name = sc.next();
        System.out.println("Informe a quantidade:");
        Integer quantity = sc.nextInt();
        System.out.println("Informe o preço");
        BigDecimal price = sc.nextBigDecimal();
        Product product = new Product(code, name, quantity, price);
        registerProduct(product);
        return product;
    }

    public void findAll() {
        productList.entrySet().forEach(System.out::println);
    }

    public void deleteById() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o código do produto que deseja remover: ");
        String code = sc.next();
        removeProduct(code);
    }

    public void findById() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o código do produto que deseja consultar: ");
        String code = sc.next();
        findProduct(code);
    }

}
