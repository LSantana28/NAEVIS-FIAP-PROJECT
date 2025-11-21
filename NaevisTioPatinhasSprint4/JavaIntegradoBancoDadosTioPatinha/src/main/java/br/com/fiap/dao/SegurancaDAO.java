package br.com.fiap.dao;
import br.com.fiap.model.Seguranca;
import java.sql.Connection;
import java.sql.SQLException;

public class SegurancaDAO {
    private Connection connection;

    public SegurancaDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para criar ou atualizar a segurança
    public void salvarSeguranca(Seguranca seguranca) throws SQLException {
        String sql;
        if (seguranca.getUser() == null) {
            // Inserir novo registro
            sql = "INSERT INTO Seguranca (usuario_id, perguntas_seguranca, autenticacao_dois_fatores) VALUES (?, ?, ?)";
        } else {
            // Atualizar registro existente
            sql = "UPDATE Seguranca SET usuario_id = ?, perguntas_seguranca = ?, autenticacao_dois_fatores = ? WHERE id = ?";
        }

    }
}

