package br.com.fiap.model;
import java.util.HashMap;
import java.util.Map;

public class Seguranca {
    private User User;
    private boolean autenticacaoDoisFat;
    private Map<String, String> perguntaSeguranca;

    public Seguranca(){
        this.perguntaSeguranca = new HashMap<>();
    }

    //Metodos

    public void definirPerguntaSeguranca(Map<String, String> perguntaEResposta){
        this.perguntaSeguranca = perguntaEResposta;
    }

    public boolean verificarRespostaSeguranca(String pergunta, String resposta){
        if(perguntaSeguranca.containsKey(pergunta)){
            return perguntaSeguranca.get(pergunta).equals(resposta);

        }
        return false;
    }

    public void enviarNotificacaoAlterarSenha(){
        if (User != null) {
            System.out.println("Notificação: A senha do usuário " + User.getName() + " foi alterada.");

        } else {
            System.out.println("Notificação: A senha foi alterada.");
        }
    }
    public void ativarAutenticacaoDoisFatores(){
        this.autenticacaoDoisFat = true;
        System.out.println("Autenticação de dois fatores ativada");
    }

    //Getters Setters

    public br.com.fiap.model.User getUser() {
        return User;
    }

    public void setUser(br.com.fiap.model.User user) {
        User = user;
    }

    public boolean isAutenticacaoDoisFat() {
        return autenticacaoDoisFat;
    }

    public void setAutenticacaoDoisFat(boolean autenticacaoDoisFat) {
        this.autenticacaoDoisFat = autenticacaoDoisFat;
    }

    public Map<String, String> getPerguntasSeguranca() {
        return perguntaSeguranca;
    }

    public void setPerguntasSeguranca(Map<String, String> perguntasSeguranca) {
        this.perguntaSeguranca = perguntasSeguranca;
    }
}
