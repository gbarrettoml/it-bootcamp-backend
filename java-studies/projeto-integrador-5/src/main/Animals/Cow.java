package main.Animals;

public class Cow extends Animal implements IPasto {

    @Override
    public void sound() {
        System.out.println("Muuuuu!");
    }

    @Override
    public void comerPasto() {
        System.out.println("Comendo grama do pasto");
    }
}
