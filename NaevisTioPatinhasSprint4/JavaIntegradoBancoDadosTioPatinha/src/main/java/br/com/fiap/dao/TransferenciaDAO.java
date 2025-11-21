package br.com.fiap.dao;
import java.sql.*;
import br.com.fiap.model.Transferencia;

public class TransferenciaDAO {
    private Connection connection;

    public TransferenciaDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para criar uma nova transferência
    public void criarTransferencia(Transferencia transferencia) throws SQLException {
        String sql = "INSERT INTO Transferencia (id, valor, data_transferencia, conta_origem_id, conta_destino_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, transferencia.getId());
            stmt.setDouble(2, transferencia.getValor());
            stmt.setDate(3, new java.sql.Date(transferencia.getDataTransferencia().getTime()));
            stmt.setInt(4, transferencia.getContaOrigem().getId());
            stmt.setInt(5, transferencia.getContaDestino().getId());
            stmt.executeUpdate();
        }
    }

}

