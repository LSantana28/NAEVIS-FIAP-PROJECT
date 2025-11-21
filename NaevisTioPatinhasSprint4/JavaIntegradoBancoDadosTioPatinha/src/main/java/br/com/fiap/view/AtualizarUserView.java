package br.com.fiap.view;

import br.com.fiap.dao.UserDAO;
import br.com.fiap.exception.EntidadeNaoEncontradaException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.User;

import java.sql.Connection;
import java.util.Scanner;

public class AtualizarUserView {
    public static void main(String[] args) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            UserDAO userDAO = new UserDAO(connection);
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite o ID do usuário a ser atualizado: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            // Buscar o usuário existente
            User user = userDAO.encontrarPorId(id);

            // Atualizar informações do usuário
            System.out.print("Digite o novo nome: ");
            String name = scanner.nextLine();
            System.out.print("Digite o novo email: ");
            String email = scanner.nextLine();
            System.out.print("Digite a nova senha: ");
            String password = scanner.nextLine();

            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);

            // Atualizar usuário no banco de dados
            userDAO.atualizar(user);
            System.out.println("Usuário atualizado com sucesso!");
        } catch (EntidadeNaoEncontradaException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
