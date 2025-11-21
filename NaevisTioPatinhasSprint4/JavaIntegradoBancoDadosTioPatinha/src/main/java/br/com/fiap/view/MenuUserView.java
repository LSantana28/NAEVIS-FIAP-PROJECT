package br.com.fiap.view;

import br.com.fiap.dao.UserDAO;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MenuUserView {
    private UserDAO userDAO;

    public MenuUserView(Connection connection) {
        this.userDAO = new UserDAO(connection);
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar Usuário");
            System.out.println("2. Listar Usuários");
            System.out.println("3. Remover Usuário");
            System.out.println("4. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    adicionarUsuario(scanner);
                    break;
                case 2:
                    listarUsuarios();
                    break;
                case 3:
                    removerUsuario(scanner);
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void adicionarUsuario(Scanner scanner) {
        System.out.println("Digite o nome do usuário:");
        String nome = scanner.nextLine();
        System.out.println("Digite o e-mail do usuário:");
        String email = scanner.nextLine();
        System.out.println("Digite a senha do usuário:");
        String senha = scanner.nextLine();

        User usuario = new User();
        usuario.setName(nome);
        usuario.setEmail(email);
        usuario.setPassword(senha);

        try {
            userDAO.criarUsuario(usuario);
            System.out.println("Usuário adicionado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void listarUsuarios() {
        try {
            List<User> usuarios = userDAO.listar();
            if (usuarios.isEmpty()) {
                System.out.println("Nenhum usuário encontrado.");
            } else {
                for (User usuario : usuarios) {
                    System.out.println("ID: " + usuario.getId() + ", Nome: " + usuario.getName() +
                            ", E-mail: " + usuario.getEmail());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void removerUsuario(Scanner scanner) {
        System.out.println("Digite o ID do usuário a ser removido:");
        int id = scanner.nextInt();

        try {
            userDAO.deletar(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            MenuUserView menu = new MenuUserView(connection);
            menu.exibirMenu();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
