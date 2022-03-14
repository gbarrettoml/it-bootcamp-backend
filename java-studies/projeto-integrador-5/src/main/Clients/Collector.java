package main.Clients;

import java.math.BigDecimal;
import java.util.Locale;

public class Collector extends Client {

    public Collector(String name, BigDecimal balance) {
        super(balance, name,"1 - SALDO\n2 - SAQUE \nEscreva o serviço deseja realizar ao invés de inserir o número.");
    }

    @Override
    public void transacion(String type) {
        if(type.toUpperCase(Locale.ROOT).equals("SALDO")) System.out.println("Olá, " + this.getName() + " Seu saldo é: " + this.getBalance());
        if(type.toUpperCase(Locale.ROOT).equals("SAQUE")) calculation(type);
    }
}
