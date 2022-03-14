package main.Clients;

import java.math.BigDecimal;
import java.util.Locale;

public class Executive extends Client {

    public Executive(String name, BigDecimal balance) {
        super(balance, name,"1 - DEPOSITO\n2 - TRANSFERENCIA\nEscreva o serviço deseja realizar ao invés de inserir o número.");
    }

    @Override
    public void transacion(String type) {
        if(type.toUpperCase(Locale.ROOT).equals("DEPOSITO")) calculation(type);
        if(type.toUpperCase(Locale.ROOT).equals("TRANSFERENCIA")) calculation(type);
    }
}
