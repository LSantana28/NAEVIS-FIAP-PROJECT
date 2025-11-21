package br.com.fiap;
import br.com.fiap.dao.ContaDAO;
import br.com.fiap.model.Conta;
import br.com.fiap.model.User;
import br.com.fiap.view.ContaView;
import br.com.fiap.view.MenuUserView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    //Primeiramente, crie o usuário, logo após associe o ID à conta. Caso dúvidas, no menu clique na opção listar usuários para primeira verificação!

    public static void main(String[] args) {
        // Configurações do banco de dados
        String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
        String user = "RM551430";
        String password = "301104";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexão com o banco de dados estabelecida!");

            boolean continuar = true;
            while (continuar) {
                System.out.println("\n=== MENU PRINCIPAL ===");
                System.out.println("1. Gerenciar Usuários");
                System.out.println("2. Gerenciar Contas");
                System.out.println("3. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer

                switch (opcao) {
                    case 1:
                        menuUsuarios(connection);
                        break;
                    case 2:
                        menuContas(connection);
                        break;
                    case 3:
                        System.out.println("Saindo...");
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
    private static void menuUsuarios(Connection connection){ //chamando a classe MenuUserView da pasta View
        MenuUserView menuUserView = new MenuUserView(connection);
        menuUserView.exibirMenu();
    }

    private static void menuContas (Connection connection){ //chamando o metodo menuContas da classe ContaView que contem o menu
        ContaView contaView = new ContaView(connection);
        contaView.exibirMenu();
    }


}
