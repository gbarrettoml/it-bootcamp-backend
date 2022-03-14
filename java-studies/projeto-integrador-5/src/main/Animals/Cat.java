package main.Animals;

public class Cat extends Animal implements ICarne {

    @Override
    public void sound() {
        System.out.println("Miau!!!");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comendo ração de gato");
    }
}
