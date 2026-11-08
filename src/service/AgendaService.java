package service;

import model.Agendamento;
import model.Cliente;
import model.Servico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AgendaService {
    private final List<Agendamento> agenda = new ArrayList<>();
    private int proximoId = 1;

    public Agendamento agendar(Cliente cliente, Servico servico, LocalDateTime inicio) {
        LocalDateTime fim = inicio.plusMinutes(servico.getDuracaoMinutos());

        if (temConflito(inicio, fim)) {
            throw new IllegalStateException("Já existe um agendamento neste horário ou com sobreposição!");
        }

        Agendamento agendamento = new Agendamento(proximoId, cliente, servico, inicio);
        agenda.add(agendamento);
        proximoId++;
        return agendamento;
    }

    public List<Agendamento> listar() {
        return List.copyOf(agenda);
    }

    private boolean temConflito(LocalDateTime inicio, LocalDateTime fim) {
        for (Agendamento existente : agenda) {
            if (inicio.isBefore(existente.getDataHoraFim()) && fim.isAfter(existente.getDataHora())) {
                return true;
            }
        }
        return false;
    }

    public Agendamento cancelar(int id) {
        Agendamento agendamento = agenda.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado com o ID: " + id));
        agenda.remove(agendamento);
        return agendamento;
    }
}
