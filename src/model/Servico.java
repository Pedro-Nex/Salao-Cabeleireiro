package model;

import java.math.BigDecimal;

public class Servico {
    private int id;
    private String nome;
    private BigDecimal preco;
    private int duracaoMinutos;

    public Servico(int id, String nome, BigDecimal preco, int duracaoMinutos) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.duracaoMinutos = duracaoMinutos;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    @Override
    public String toString() {
        return id + " - " + nome + " | R$ " + preco + " | " + duracaoMinutos + "min";
    }
}
