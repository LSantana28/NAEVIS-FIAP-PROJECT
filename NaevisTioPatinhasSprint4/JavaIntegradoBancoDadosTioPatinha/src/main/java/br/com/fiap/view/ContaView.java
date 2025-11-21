package br.com.fiap.view;

import br.com.fiap.dao.ContaDAO;
import br.com.fiap.model.Conta;
import br.com.fiap.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class ContaView {
    private ContaDAO contaDAO;
    private Scanner scanner;

    public ContaView(Connection connection) {
        this.contaDAO = new ContaDAO(connection);
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu(){
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- MENU DE CONTAS ---");
            System.out.println("1. Criar Conta");
            System.out.println("2. Atualizar Saldo da Conta");
            System.out.println("3. Deletar Conta");
            System.out.println("4. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    atualizarSaldo();
                    break;
                case 3:
                    deletarConta();
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    public void criarConta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ID da conta: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        System.out.print("Digite o nome da conta: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o saldo inicial: ");
        double saldo = scanner.nextDouble();

        // Solicita o ID do usuário
        System.out.print("Digite o ID do usuário associado: ");
        int userId = scanner.nextInt();

        // Cria o objeto Conta e associa um User
        Conta conta = new Conta();
        conta.setId(id);
        conta.setSaldo(saldo);

        // Cria o objeto User e associa à conta
        User user = new User();
        user.setId(userId);
        conta.setUser(user);

        try {
            contaDAO.criarConta(conta);
            System.out.println("Conta criada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void atualizarSaldo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ID da conta: ");
        int id = scanner.nextInt();
        System.out.print("Digite o novo saldo: ");
        double saldo = scanner.nextDouble();

        try {
            Conta conta = new Conta(id, "", saldo);
            contaDAO.atualizarSaldo(conta);
            System.out.println("Saldo atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarConta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ID da conta a ser deletada: ");
        int id = scanner.nextInt();

        try {
            contaDAO.deletarConta(id);
            System.out.println("Conta deletada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}