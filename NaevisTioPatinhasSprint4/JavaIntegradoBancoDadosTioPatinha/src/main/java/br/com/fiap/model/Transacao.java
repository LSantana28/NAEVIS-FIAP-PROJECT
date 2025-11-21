package br.com.fiap.model;
import java.util.Date;

public abstract class Transacao {
    private int id;
    private double valor;
    private Date data;

    // Construtor
    public Transacao() {}

    public Transacao(int id, double valor, Date data) {
        this.id = id;
        this.valor = valor;
        this.data = data;
    }

    // Métodos abstratos
    public abstract void processar();

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
