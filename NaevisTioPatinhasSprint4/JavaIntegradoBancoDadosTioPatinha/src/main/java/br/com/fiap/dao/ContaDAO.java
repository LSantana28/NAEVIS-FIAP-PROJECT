package br.com.fiap.dao;

import br.com.fiap.model.Conta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ContaDAO {
    private Connection connection;

    public ContaDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para criar uma nova conta
    public void criarConta(Conta conta) throws SQLException {
        String sql = "INSERT INTO Conta (id, saldo, usuario_id) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, conta.getId());
            stmt.setDouble(2, conta.getSaldo());
            stmt.setInt(3, conta.getUser().getId());
            stmt.executeUpdate();
        }
    }

    // Método para atualizar o saldo de uma conta
    public void atualizarSaldo(Conta conta) throws SQLException {
        String sql = "UPDATE Conta SET saldo = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, conta.getSaldo());
            stmt.setInt(2, conta.getId());
            stmt.executeUpdate();
        }
    }

    // Método para deletar uma conta
    public void deletarConta(int id) throws SQLException {
        String sql = "DELETE FROM Conta WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}