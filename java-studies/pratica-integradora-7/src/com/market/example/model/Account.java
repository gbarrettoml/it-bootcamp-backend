package com.market.example.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private Client client;
    private BigDecimal totalValue;
    private List<Product> list = new ArrayList<>();
}
