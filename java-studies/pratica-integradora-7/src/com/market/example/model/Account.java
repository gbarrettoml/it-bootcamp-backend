package com.market.example.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Account {

    private Client client;
    private BigDecimal totalValue;
    private Map<String, Product> productMap = new HashMap<>();


    public Account(Client client) {
        this.client = client;
    }

    public void addProduct(Product product) {
        productMap.put(product.getCode(), product);
    }

    public void totalCalculation () {
        ArrayList<BigDecimal> allValues = new ArrayList<>();
        productMap.entrySet().forEach( entry -> allValues.add(entry.getValue()
                .getValue()
                .multiply(
                        new BigDecimal( entry.getValue().getQuantity())
                )));

        totalValue = allValues.stream().reduce(BigDecimal::add).get();
    }

    @Override
    public String toString() {
        return "Fatura: \n" +
                "Cliente: " + client.toString() + "\n" +
                "Total: R$ " + totalValue + "\n" +
                "Produtos: \n" + productMap;

    }


}
