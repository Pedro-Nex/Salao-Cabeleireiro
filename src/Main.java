import model.Cliente;
import model.Servico;
import model.Agendamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(1, "Mayara Sena", "11999990000", "MayaraSena@gmail.com");
        Cliente cliente2 = new Cliente(2, "Pedro Neves", "11999990001", "PedroNeves@gmail.com");
        Cliente cliente3 = new Cliente(3, "Andreas Gigabyte", "11999990002", "AndreasGigabyte@gmail.com");

        Servico corteF = new Servico(1, "Corte Feminino", new BigDecimal("80.00"), 60);
        Servico corteM = new Servico(2, "Corte Masculino", new BigDecimal("30.00"), 45);
        Servico corteS = new Servico(3, "Corte Super", new BigDecimal("120.00"), 90);

        System.out.println("*** Clientes ***");
        System.out.println(cliente1);
        System.out.println(cliente2);
        System.out.println(cliente3);

        System.out.println("\n*** Cortes ***");
        System.out.println(corteF);
        System.out.println(corteM);
        System.out.println(corteS);

        List<Agendamento> agenda = new ArrayList<>();

        agenda.add(new Agendamento(1, cliente1, corteF, LocalDateTime.of(2026, 11,10,14,0)));
        agenda.add(new Agendamento(2, cliente2, corteM, LocalDateTime.of(2026, 11,10,15,30)));

        System.out.println("\n*** Agenda ***");
        for (Agendamento a : agenda) {
            System.out.println(a);
        }
    }
}