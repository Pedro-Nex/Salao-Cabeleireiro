package service;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    private static final List<Cliente> clientes = new ArrayList<>();
    private static int proximoId = 1;

    public Cliente cadastrar(String nome, String telefone, String email) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("[ERRO] O nome não pode ser vazio!");
        }
        Cliente cliente = new Cliente(proximoId, nome, telefone, email);
        clientes.add(cliente);
        proximoId++;
        return cliente;
    }

    public List<Cliente> listar() {
        return List.copyOf(clientes);
    }

    public Cliente buscarPorId(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }
}
