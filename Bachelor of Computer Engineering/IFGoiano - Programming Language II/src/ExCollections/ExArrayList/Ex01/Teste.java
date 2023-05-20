/*
[ ] Crie uma classe Data que contenha os atibutos, dia, mês e ano, todos do tipo inteiro.
[ ] Crie uma classe EventoDeAgenda que tenha como atributos um código e um nome, ambos String e que tenha ainda um atributo do tipo Data. Crie um comparador para EventoDeAgenda para que os eventos sejam ordenados de forma crescente de data (mais antigos para os mais recentes).
[ ] Crie uma classe Agenda, que possua como atributo uma lista de EventosDeAgenda.
[ ] Crie uma classe de testes, onde você vai pedir para que o usuário digite os códigos e os nomes para 10 eventos e, em seguida, os seus respectivos dias, meses e anos (usar a classe Scanner). Guarde esses eventos na lista de um objeto Agenda.
[ ] Ordene os eventos dentro da lista presente no objeto Agenda e exiba no console a lista ordenada.
*/

package ExCollections.ExArrayList.Ex01;

import java.util.Collections;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);

        String codigo, nome;
        int dia, mes, ano;
        Data data;

        for (int i = 0; i < 3; i++) {
            System.out.println("Evento " + (i + 1) + ":");
            System.out.println("Código:");
            codigo = scanner.nextLine();

            System.out.println("Nome:");
            nome = scanner.nextLine();

            System.out.println("Dia:");
            dia = scanner.nextInt();

            System.out.println("Mês:");
            mes = scanner.nextInt();

            System.out.println("Ano:");
            ano = scanner.nextInt();

            scanner.nextLine();

            data = new Data(dia, mes, ano);

            EventoDeAgenda eventoDeAgenda = new EventoDeAgenda(codigo, nome, data);
            agenda.lista.add(eventoDeAgenda);
            System.out.println();
        }

        Collections.sort(agenda.lista, new EventoDeAgendaComparator());

        int i = 1;
        for (EventoDeAgenda e : agenda.lista) {
            System.out.printf("Evento nro...: %d\n", i++);
            System.out.printf("Codigo.......: %s\n", e.codigo);
            System.out.printf("Nome.........: %s\n", e.nome);
            System.out.printf("Dia..........: %d\n", e.data.dia);
            System.out.printf("Mês..........: %d\n", e.data.mes);
            System.out.printf("Ano..........: %s\n\n", e.data.ano);
        }

        scanner.close();
    }
}