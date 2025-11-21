package br.com.fiap.view;

import br.com.fiap.dao.UserDAO;
import br.com.fiap.model.User;

import java.sql.SQLException;

public class CreateUserView {
    public static void main(String[] args) {
        try {
            // Criar um novo usuário
            User novoUsuario = new User(2, "Yohana", "yohanafiap@fiap.com", "senhaforte");

            // Utilizar UserDAO para manipular o usuário
            UserDAO userDAO = new UserDAO();

            // Criar o usuário no banco de dados
            userDAO.criarUsuario(novoUsuario);
            System.out.println("Usuário criado com sucesso.");

            // Obter o usuário do banco de dados
            User usuarioExistente = userDAO.obterUsuarioPorId(1);
            if (usuarioExistente != null) {
                System.out.println("Usuário obtido: " + usuarioExistente.getName());
            }

            // Atualizar o usuário
            usuarioExistente.setName("João Silva Atualizado");
            userDAO.atualizarUsuario(usuarioExistente);
            System.out.println("Usuário atualizado com sucesso.");

            // Fechar a conexão
            userDAO.fecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
