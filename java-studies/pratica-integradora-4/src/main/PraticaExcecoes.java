package main;

public class PraticaExcecoes {

    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        try {
            int result = b/a;

        } catch (ArithmeticException err) {
            System.out.println("Não pode ser dividido por zero.");
        }

        System.out.println("Programa finalizado.");
    }

}
