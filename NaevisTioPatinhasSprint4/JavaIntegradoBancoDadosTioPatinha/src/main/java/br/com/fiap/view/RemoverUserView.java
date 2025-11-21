package br.com.fiap.view;

import br.com.fiap.dao.UserDAO;
import br.com.fiap.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class RemoverUserView {
    public static void main(String[] args) {
        // Obter conexão com o banco de dados
        try (Connection connection = ConnectionFactory.getConnection()) {
            // Criar uma instância do UserDAO
            UserDAO userDAO = new UserDAO(connection);

            // Ler o ID do usuário a ser excluído
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o ID do usuário a ser excluído: ");
            int id = scanner.nextInt();

            // Excluir o usuário
            try {
                userDAO.deletar(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
