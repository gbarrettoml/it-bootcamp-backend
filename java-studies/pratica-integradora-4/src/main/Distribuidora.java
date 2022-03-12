package main;

import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        ArrayList<Produto> list = new ArrayList<>();

        list.add(new NaoPereciveis("Geladeira", 1090.99, "Eletrodoméstico"));
        list.add(new Pereciveis("Maçã", 0.99, 2));
        list.add(new Pereciveis("Bacon", 6.99, 10));
        list.add(new Pereciveis("Pizza", 0.99, 1));
        list.add(new NaoPereciveis("Televisor", 2699.99, "Eletrodoméstico"));

        for (Produto produto : list) {
            System.out.printf("A compra de cinco produtos de nome %s totaliza o valor de R$%.2f.%n", produto.getNome(), produto.calcular(5));


        }
    }
}
