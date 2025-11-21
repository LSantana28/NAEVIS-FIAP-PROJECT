package br.com.fiap.model;

import java.util.Date;

public class Investimento {
    private int id;
    private double valorInvestido;
    private Date dataInvestimento;
    private CriptoAtivo criptoAtivo;

    // Construtor
    public Investimento() {}

    public Investimento(int id, double valorInvestido, Date dataInvestimento, CriptoAtivo criptoAtivo) {
        this.id = id;
        this.valorInvestido = valorInvestido;
        this.dataInvestimento = dataInvestimento;
        this.criptoAtivo = criptoAtivo;
    }

    // Métodos
    public double calcularQuantidadeCripto() {
        return valorInvestido / criptoAtivo.getPreco();
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    public Date getDataInvestimento() {
        return dataInvestimento;
    }

    public void setDataInvestimento(Date dataInvestimento) {
        this.dataInvestimento = dataInvestimento;
    }

    public CriptoAtivo getCriptoAtivo() {
        return criptoAtivo;
    }

    public void setCriptoAtivo(CriptoAtivo criptoAtivo) {
        this.criptoAtivo = criptoAtivo;
    }
}

