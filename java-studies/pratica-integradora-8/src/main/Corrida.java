package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Corrida {
    private double distancia;
    private double premioEmDolares;
    private String nome;
    private int numVeiculosPermitidos;
    private List<Veiculo> listaDeVeiculos = new ArrayList<>();

    public void addCarroOuMoto(double velocidade, double aceleracao, double anguloDeGiro, String placa) {
        Veiculo veiculo = new Veiculo();
        veiculo.setAceleracao(aceleracao);
        veiculo.setVelocidade(velocidade);
        veiculo.setAnguloDeGiro(anguloDeGiro);
        veiculo.setPlaca(placa);
        listaDeVeiculos.add(veiculo);
    }

    public void deleteVeiculo(Veiculo veiculo) {
        listaDeVeiculos.removeIf( v -> v.equals(veiculo));
    }
    public void deleteVeiculoComPlaca(String placa) {
        listaDeVeiculos.removeIf( v ->  v.getPlaca().equals(placa));
    }
    public void socorrer(Carro carro) {
        System.out.println("Socorro carro");
    }
    public void socorrer(Motocicleta motocicleta) {
        System.out.println("Socorro moto");
    }
    public void socorrerCarro(String placa) {}
    public void socorrerMoto(String placa) {}


}
