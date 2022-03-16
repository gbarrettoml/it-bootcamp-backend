package com.market.example.model;

import java.math.BigDecimal;

public class Product {

    private String code;
    private String name;
    private int quantity;
    private BigDecimal value;

    public Product(String code, String name, int quantity, BigDecimal value) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CÓDIGO: " + code + " - NOME: " + name + " - " + "QUANTIDADE: " + quantity + " - " + "VALOR: R$ " + value;
    }
}
