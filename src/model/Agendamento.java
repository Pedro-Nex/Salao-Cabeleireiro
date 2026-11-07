package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Agendamento {
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private int id;
    private Cliente cliente;
    private Servico servico;
    private LocalDateTime dataHora;

    public Agendamento(int id, Cliente cliente, Servico servico, LocalDateTime dataHora) {
        this.id = id;
        this.cliente = cliente;
        this.servico = servico;
        this.dataHora = dataHora;
    }

    public int getId() {
        return id;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public Servico getServico() {
        return servico;
    }
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHora.plusMinutes(servico.getDuracaoMinutos());
    }

    @Override
    public String toString() {
        return id + " - " + cliente.getNome() + " | " + servico.getNome()
                + " | " + dataHora.format(FORMATO)
                + " até " + getDataHoraFim().format(FORMATO);
    }
}
