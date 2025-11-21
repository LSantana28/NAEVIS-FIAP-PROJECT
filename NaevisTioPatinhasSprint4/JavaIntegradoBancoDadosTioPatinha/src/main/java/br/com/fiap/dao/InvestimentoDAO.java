package br.com.fiap.dao;
import br.com.fiap.model.CriptoAtivo;
import br.com.fiap.model.Investimento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvestimentoDAO {
    private Connection connection;

    public InvestimentoDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para criar um novo investimento
    public void criarInvestimento(Investimento investimento) throws SQLException {
        String sql = "INSERT INTO Investimento (id, valor_investido, data_investimento, cripto_nome) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, investimento.getId());
            stmt.setDouble(2, investimento.getValorInvestido());
            stmt.setDate(3, new java.sql.Date(investimento.getDataInvestimento().getTime()));
            stmt.setString(4, investimento.getCriptoAtivo().getNome());
            stmt.executeUpdate();
        }
    }

    // Método para listar todos os investimentos
    public List<Investimento> listarInvestimentos() throws SQLException {
        List<Investimento> investimentos = new ArrayList<>();
        String sql = "SELECT * FROM Investimento";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                CriptoAtivo criptoAtivo = new CriptoAtivo(
                        rs.getString("cripto_nome"),
                        0, // quantidade deve ser consultada de outra maneira se necessário
                        0  // preço deve ser consultado de outra maneira se necessário
                );

                Investimento investimento = new Investimento(
                        rs.getInt("id"),
                        rs.getDouble("valor_investido"),
                        rs.getDate("data_investimento"),
                        criptoAtivo
                );
                investimentos.add(investimento);
            }
        }
        return investimentos;
    }
}
