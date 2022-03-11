package main;

public class Pessoa {

    private String name;
    private int age;
    private String id;
    private double weight;
    private double height;

    public Pessoa() {}

    public Pessoa(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public Pessoa(String name, int age, String id, double weight, double height) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.weight = weight;
        this.height = height;
    }

    public int calculateIMC () {
        double imc = weight / (height * height);
        if(imc < 20.0) return -1;
        if(imc < 25.0) return 0;
        return 1;

    }

    public boolean isOfAge () {
        return age > 18;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
