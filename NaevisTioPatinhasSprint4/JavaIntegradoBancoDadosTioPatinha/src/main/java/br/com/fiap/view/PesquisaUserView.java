package br.com.fiap.view;


import br.com.fiap.dao.UserDAO;
import br.com.fiap.model.User;
import br.com.fiap.exception.EntidadeNaoEncontradaException;
import br.com.fiap.factory.ConnectionFactory;

import java.sql.Connection;

public class PesquisaUserView {
    public static void main(String[] args) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            UserDAO userDAO = new UserDAO(connection);

            // Testar encontrar um usuário por ID
            try {
                User user = userDAO.encontrarPorId(1);
                System.out.println("Usuário encontrado: ID: " + user.getId() + ", Nome: " + user.getName() + ", Email: " + user.getEmail());
            } catch (EntidadeNaoEncontradaException e) {
                System.out.println(e.getMessage());
            }

            // Testar listar todos os usuários
            System.out.println("Listando todos os usuários:");
            for (User user : userDAO.listar()) {
                System.out.println("ID: " + user.getId() + ", Nome: " + user.getName() + ", Email: " + user.getEmail());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
