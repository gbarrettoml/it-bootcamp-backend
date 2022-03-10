package main;

import java.util.HashMap;
import java.util.Scanner;

public class main {

    /*Corrida na Selva
    Todos os anos, na província de Misiones, no norte da Argentina, acontece um evento
    conhecido como "Corrida na Selva”. É uma competição onde os melhores maratonistas e
    corredores da América Latina se encontram para desafiar suas habilidades esportivas.
    A competição tem 3 categorias dependendo de sua dificuldade:
        ● Circuito pequeno: 2 km pela selva e riachos.
        ● Circuito médio: 5 km pela selva, riachos e lama.
        ● Circuito Avançado: 10 km pela selva, riachos, lama e escalada.
    Cada participante só pode se inscrever em uma categoria e precisa, para tal inscrição,
    fornecer as seguintes informações: RG, nome, sobrenome, idade, número de celular, número
    de emergência e grupo sanguíneo. A cada inscrito, por sua vez, é atribuído um número de
    participante consecutivo em relação à inscrição anterior; Por exemplo, se um participante se
    inscrever e o anterior for o número 36, será atribuído o número 37.

    Para concluir com a inscrição, deve ser calculado o valor a ser pago por cada participante.
    Para isso, são levados em consideração os seguintes valores:
        ● Inscrição no circuito pequeno: Menores de 18 anos R$1.300. Acima de 18 anos R$ 1.500.
        ● Inscrição no Circuito Médio: Menores de 18 anos R$ 2.000. Acima de 18 anos R$ 2.300.
        ● Inscrição no Circuito Avançado: A inscrição não é permitida para menores de 18
        anos. Maiores de 18 anos R$ 2.800

    Com base nesses dados fornecidos, os organizadores da corrida afirmaram que precisam de um
    aplicativo que seja capaz de:
        a) Inscrever um novo participante em uma categoria. (Observe que cada categoria tem uma
        lista de entradas diferente).
        b) Mostra na tela todos os cadastrados em uma determinada categoria com seus
        respectivos dados e número de registro.
        c) Cancelar a inscrição de um participante de uma categoria.
        d) Determine o valor que cada participante deve pagar ao se inscrever. Por exemplo: se o
    participante se inscrever na categoria Circuito Pequeno e tiver 21 anos, o valor a ser
    pago é de R$ 1.500.*/

    public static Participant participantSubscription (Scanner scanner) {
        System.out.println("Informe o RG: ");
        String rg = scanner.next();
        System.out.println("Informe o nome: ");
        String name = scanner.next();
        System.out.println("Informe o sobrenome: ");
        String surname = scanner.next();
        System.out.println("Informe a idade: ");
        Integer age = scanner.nextInt();
        System.out.println("Informe o número do celular: ");
        String cellPhoneNumber = scanner.next();
        System.out.println("Informe o número de emergência: ");
        String cellPhoneEmergency = scanner.next();
        System.out.println("Informe seu grupo sanguineo: ");
        String bloodGroup = scanner.next();
        System.out.println("Informe o circuito escolhido: ");
        String circuit = scanner.next();

        if(age < 18 && circuit.equals("Avancado")) {
            System.out.println("Você não pode se inscrever nesse circuito por não se enquadrar na faixa etária maior de 18 anos.");
            System.out.println("Tente novamente.");
            return null;
        }

        String price = priceCalculation(age, circuit);

        return new Participant(rg, name, surname, age, cellPhoneNumber, cellPhoneEmergency, bloodGroup, circuit, price);
    }

    public static String priceCalculation(Integer age, String circuit) {
        switch(circuit) {
            case "Pequeno":
                if(age < 18) {
                    return "R$ 1.300,00";
                } else {
                    return "R$ 1.500,00";
                }
            case "Médio":
                if(age < 18) {
                    return "R$ 2.000,00";
                } else {
                    return "R$ 2.300,00";
                }
            default:
                return "RS 2.800,00";

        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int menuAwnser = 0;
        Integer globalId = 1;
        HashMap<Integer, Participant> participantList = new HashMap<Integer, Participant>();

        // Menu
        do {
            System.out.println("------------ MENU ------------");
            System.out.println("1 - Inscrever um participante;");
            System.out.println("2 - Mostrar todos participantes inscritos;");
            System.out.println("3 - Cancelar a incricao de um participante;");
            System.out.println("0 - Sair");
            System.out.println("------------------------------");
            System.out.println("Informe a sua opcao: ");
            menuAwnser = scanner.nextInt();

            switch (menuAwnser) {
                case 1:
                    Participant participant = participantSubscription(scanner);
                    if(participant != null) {
                        System.out.println(participant.getName() + ", sua inscricao foi aprovada! Você é o corredor de n. " + globalId + ".");
                        participantList.put(globalId, participant);
                        globalId++;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    System.out.println("Lista de participantes por ordem de inscricao: ");
                    participantList.entrySet().forEach( entry -> {
                        System.out.println(entry.getKey() + " - " + entry.getValue().getName() + " " + entry.getValue().getSurname() + ". Valor da Inscricao: " + entry.getValue().getPrice());
                    });
                    break;
                case 3:
                    System.out.println("Informe o número de inscricao do participante que você deseja cancelar a participacao: ");
                    Integer key = scanner.nextInt();

                    Participant removedParticipant = participantList.remove(key);
                    if(removedParticipant != null) {
                        System.out.println("Participante removido");
                    } else {
                        System.out.println("Participante nao encontrado ou ja foi removido.");
                    }
                    break;
                case 0:
                    System.out.println("Programa encerrado. Até logo!");
            }
        } while(menuAwnser != 0);
    }
}