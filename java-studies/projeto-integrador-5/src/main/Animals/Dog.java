package main.Animals;

public class Dog extends Animal implements ICarne {

    @Override
    public void sound() {
        System.out.println("Au au!");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comendo ração de cachorro");
    }
}
