package com.market.example;

import com.market.example.service.Menu;

public class Main {

    public static void main(String[] args) {

        Menu menu = Menu.getInstance();
        menu.execute();

    }
}
