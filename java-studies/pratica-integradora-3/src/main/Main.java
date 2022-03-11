package main;

public class Main {



    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa("João", 25, "1", 72.2, 1.70);

        int IMCResult = pessoa.calculateIMC();
        if(IMCResult < 0) System.out.println("Essa pessoa está abaixo do peso");
        if(IMCResult == 0) System.out.println("Essa pessoa está com peso saudável");
        if(IMCResult > 0) System.out.printf("Essa pessoa está com sobrepeso");
        if(pessoa.isOfAge()) System.out.println("Essa pessoa também é maior de idade.");
        else System.out.println("Essa pessoa não é maior de idade");
        System.out.println(pessoa);


    }
}
