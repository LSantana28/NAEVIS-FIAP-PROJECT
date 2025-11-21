package br.com.fiap.view;

import br.com.fiap.dao.UserDAO;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.User;

import java.sql.Connection;
import java.util.List;

public class ListarUserView {
    public static void main(String[] args) {
        // Obter conexão com o banco de dados
        try (Connection connection = ConnectionFactory.getConnection()) {
            // Criar uma instância do UserDAO
            UserDAO userDAO = new UserDAO(connection);

            // Obter a lista de usuários
            List<User> usuarios = userDAO.listar();

            // Verificar se a lista está vazia
            if (usuarios.isEmpty()) {
                System.out.println("Nenhum usuário encontrado.");
            } else {
                System.out.println("Usuários encontrados:");
                for (User user : usuarios) {
                    System.out.println("ID: " + user.getId() +
                            ", Nome: " + user.getName() +
                            ", Email: " + user.getEmail() +
                            ", Senha: " + user.getPassword());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
