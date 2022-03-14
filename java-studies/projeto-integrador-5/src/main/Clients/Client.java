package main.Clients;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

public abstract class Client implements Transaction {

    private BigDecimal balance;
    private String name;
    private String services;

    public Client(BigDecimal balance, String name, String services) {
        this.balance = balance;
        this.name = name;
        this.services = services;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    protected void calculation(String type) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Este é o seu saldo: R$" + this.getBalance());
        System.out.println("Informe o valor do " + type.toLowerCase(Locale.ROOT) + ": ");

        BigDecimal finalValue = this.getBalance().subtract(sc.nextBigDecimal());
        Boolean operation = finalValue.compareTo(new BigDecimal(0)) > 0 ? transacaoOk() : transacaoNotOk();
        if(operation) {
            System.out.println("Operação realizada!");
            this.setBalance(finalValue);
            System.out.println("O seu " + type.toLowerCase(Locale.ROOT) + " foi realizado. Seu saldo atual é R$" + this.getBalance());
        } else {
            System.out.println("Operação não realizada! Saldo isuficiente!");
        }
    }

    private boolean transacaoOk() {
        return true;
    }

    private boolean transacaoNotOk() {
        return false;
    }
}
