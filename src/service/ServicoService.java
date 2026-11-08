package service;

import model.Servico;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ServicoService {
    private final List<Servico> servicos = new ArrayList<>();
    private int proximoId = 1;

    public Servico cadastrar(String nome, BigDecimal preco, int duracaoMinutos) {
        Servico servico = new Servico(proximoId, nome, preco, duracaoMinutos);
        servicos.add(servico);
        proximoId++;
        return servico;
    }

    public List<Servico> listar() {
        return List.copyOf(servicos);
    }

    public Servico buscarPorId(int id) {
        for (Servico s : servicos) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
}
