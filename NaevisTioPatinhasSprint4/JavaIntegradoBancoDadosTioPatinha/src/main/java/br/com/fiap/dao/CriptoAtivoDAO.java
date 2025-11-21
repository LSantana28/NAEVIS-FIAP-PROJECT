package br.com.fiap.dao;

import br.com.fiap.model.CriptoAtivo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CriptoAtivoDAO {
    private Connection connection;

    public CriptoAtivoDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para criar um novo criptoativo
    public void criarCriptoAtivo(CriptoAtivo criptoAtivo) throws SQLException {
        String sql = "INSERT INTO CriptoAtivo (nome, quantidade, preco_unit) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, criptoAtivo.getNome());
            stmt.setDouble(2, criptoAtivo.getQuantidade());
            stmt.setDouble(3, criptoAtivo.getPreco());
            stmt.executeUpdate();
        }
    }

    // Método para buscar um criptoativo pelo nome
    public CriptoAtivo buscarPorNome(String nome) throws SQLException {
        String sql = "SELECT * FROM CriptoAtivo WHERE nome = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new CriptoAtivo(
                            rs.getString("nome"),
                            rs.getDouble("quantidade"),
                            rs.getDouble("preco_unit")
                    );
                } else {
                    return null; // Ou lançar uma exceção, dependendo da lógica
                }
            }
        }
    }
}