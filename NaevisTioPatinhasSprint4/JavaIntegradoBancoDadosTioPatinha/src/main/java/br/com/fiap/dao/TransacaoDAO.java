package br.com.fiap.dao;
import br.com.fiap.model.Transacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public abstract class TransacaoDAO {
    protected Connection connection;

    public TransacaoDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para inserir uma transação
    public void inserirTransacao(Transacao transacao) throws SQLException {
        String sql = "INSERT INTO Transacao (id, valor, data) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, transacao.getId());
            stmt.setDouble(2, transacao.getValor());
            stmt.setDate(3, new java.sql.Date(transacao.getData().getTime()));
            stmt.executeUpdate();
        }
    }
}
