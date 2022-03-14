package main;

import main.Clients.Basic;
import main.Clients.Client;
import main.Clients.Collector;
import main.Clients.Executive;
import main.Documents.Book;
import main.Documents.Curriculum;
import main.Documents.Document;
import main.Documents.Report;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    /*Um banco possui diferentes tipos de transações que pode realizar, dentre elas estão:
    Depósito, Transferência, Saque em Dinheiro, Consulta de Saldo, Pagamento de
    Serviços. Todas as transações têm dois métodos em comum, que são transacaoOk() e
    transacaoNaoOk().
    Com base nisso, existem diferentes tipos de clientes que podem interagir com o
    banco:
            ● Executivos: Fazem Depósitos e Transferências.
            ● Básico: Realizam consultas de saldo, pagamentos de serviços e saques em
            dinheiro.
            ● Cobradores: Eles fazem saques em dinheiro e consultam saldos.

    Implemente o cenário acima permitindo aos clientes mencionados acima, o acesso
    aos diferentes métodos dependendo da operação que desejam realizar.*/

    public static void main(String[] args) {

        /*Client executive = new Executive("Gustavo", BigDecimal.valueOf(25000));
        Client basic = new Basic("Gustavo B", BigDecimal.valueOf(2000));
        Client collector = new Collector("Gustavo T", BigDecimal.valueOf(5000));

        Scanner sc = new Scanner(System.in);
        System.out.println(executive.getServices());
        executive.transacion(sc.next());
        System.out.println(basic.getServices());
        basic.transacion(sc.next());
        System.out.println(collector.getServices());
        collector.transacion(sc.next());*/


        Document curriculum = new Curriculum("Gustavo", "Jogar");
        Document book = new Book(100, "Gustavo", "Java Program", "Tecnologia");
        Document report = new Report(25, "Gustavo", "Barretto", "Grande");

        curriculum.printing();
        book.printing();
        report.printing();



    }
}
