package br.com.fiap.model;

public class CriptoAtivo {
    private String nome;
    private double quantidade;
    private double precoUnit;

    //construtor
    public CriptoAtivo(){}

    public CriptoAtivo(String nome, double quantidade, double precoUnit){
        this.setNome(nome);
        this.setPreco(precoUnit);
        this.setQuantidade(quantidade);
    }

    //metodos

    public double calcularTotal(){
        return this.getQuantidade() * this.getPreco();
    }

    //getters setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return precoUnit;
    }

    public void setPreco(double preco) {
        this.precoUnit = preco;
    }
}
