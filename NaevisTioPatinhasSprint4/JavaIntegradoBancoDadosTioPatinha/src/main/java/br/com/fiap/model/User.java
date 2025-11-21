package br.com.fiap.model;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private Seguranca seguranca;

    //Construtor

    public User(){}
    public User(int id, String name, String email, String password){
        this.setId(id);
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.seguranca = new Seguranca();
        this.seguranca.setUser(this);
    }


    //Métodos
    public void registrar(String name, String email, String senha){
        System.out.println("Usuário " + this.getName() + "registrado com sucesso!");

    }

    public void alterarSenha(String novaSenha, String perguntaSeguranca, String respostaSeguranca){
        if (seguranca.verificarRespostaSeguranca(perguntaSeguranca, respostaSeguranca)){
            this.setPassword(novaSenha);
            seguranca.enviarNotificacaoAlterarSenha();
        } else {
            throw new SecurityException("Resposta de segurança incorreta");
        }
    }


    //Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Seguranca getSeguranca() {
        return seguranca;
    }

    public void setSeguranca(Seguranca seguranca) {
        this.seguranca = seguranca;
    }
}
