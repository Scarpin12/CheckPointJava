package model.dao;
import model.vo.FilmeVo;
import service.Conexao;
import java.sql.*;

public class FilmeDAO {

    public FilmeVo montarFilme(ResultSet rs) throws SQLException {
        FilmeVo filme = new FilmeVo();
        filme.setImdbID(rs.getString("id_filme"));
        filme.setTitle(rs.getString("title"));
        filme.setYear(rs.getString("year"));
        filme.setGenre(rs.getString("genre"));
        filme.setDirector(rs.getString("director"));
        filme.setPoster(rs.getString("poster"));
        filme.setPlot(rs.getString("plot"));
        filme.setImdbRating(rs.getString("rating"));
        return filme;
    }

    public FilmeVo buscarPorId(String idFilme) {
        String sql = "SELECT * FROM TB_FILME WHERE id_filme = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idFilme);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return montarFilme(rs);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar filme: " + e.getMessage());
        }

        return null;
    }

    public void inserir(FilmeVo filme) {

    }

}

