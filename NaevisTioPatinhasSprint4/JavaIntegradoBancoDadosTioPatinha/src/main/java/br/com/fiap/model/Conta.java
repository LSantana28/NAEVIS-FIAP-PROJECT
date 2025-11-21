package br.com.fiap.model;

public class Conta {
    private int id;
    private int numeroConta;
    private User user;
    private double saldo;
    private String tipoConta;
    private CriptoAtivo criptoAtivo;

    //construtor

    public Conta(){
    }
    public Conta(int id, User user, int numeroConta, double saldo, String tipoConta, CriptoAtivo criptoAtivo){
        this.setId(id);
        this.setNumeroConta(numeroConta);
        this.setUser(user);
        this.setSaldo(saldo);
        this.setCriptoAtivo(criptoAtivo);
    }

    public Conta(int id, String s, double saldo) {
    }

    //metodos
    public boolean depositar(double valor){
        if (valor > 0 ){
            this.saldo += valor;
            System.out.println("Deposito de R$" + valor + "realizado.");
        } else{
            System.out.println("Valor de depósito inválido");
        }
        return false;
    }

    public boolean sacar(double valor){
        if( valor >0 && valor <= this.saldo){
            this.saldo -= valor;
            System.out.println("Saque realizado!");
        }else{
            System.out.println("Valor de saque inválido ou saldo insuficiente");
        }
        return false;
    }

    public boolean visualizarSaldo(){
        System.out.println("saldo atual: R$" + this.saldo);
        return false;
    }

    //getters setters

    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public CriptoAtivo getCriptoAtivo() {
        return criptoAtivo;
    }

    public void setCriptoAtivo(CriptoAtivo criptoAtivo) {
        this.criptoAtivo = criptoAtivo;
    }
}