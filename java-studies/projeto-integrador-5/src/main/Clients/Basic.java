package main.Clients;

import java.math.BigDecimal;
import java.util.Locale;

public class Basic extends Client {

    public Basic(String name, BigDecimal balance) {
        super(balance, name,"1 - SALDO\n2 - PAGAMENTO \n3 - SAQUE \n Escreva o serviço deseja realizar ao invés de inserir o número.");
    }

    @Override
    public void transacion(String type) {
        if(type.toUpperCase(Locale.ROOT).equals("SALDO")) System.out.println("Olá, " + this.getName() + " Seu saldo é: " + this.getBalance());
        if(type.toUpperCase(Locale.ROOT).equals("PAGAMENTO")) {
            calculation(type);
        }
        if(type.toUpperCase(Locale.ROOT).equals("SAQUE")) {
            calculation(type);
        }
    }
}
