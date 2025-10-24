package model.dao;

import model.vo.FilmeVo;
import service.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {

    private FilmeVo montarFilme(ResultSet rs) throws SQLException {
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

    public List<FilmeVo> buscarPorGenero(String genero) {
        List<FilmeVo> filmes = new ArrayList<>();
        String sql = "SELECT * FROM TB_FILME WHERE genre = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, genero);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                filmes.add(montarFilme(rs));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar filmes: " + e.getMessage());
        }
        return filmes;
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
        String sql = "INSERT INTO TB_FILME (id_filme, title, year, genre, director, poster, plot, rating) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, filme.getImdbID());
            stmt.setString(2, filme.getTitle());
            stmt.setString(3, filme.getYear());
            stmt.setString(4, filme.getGenre());
            stmt.setString(5, filme.getDirector());
            stmt.setString(6, filme.getPoster());
            stmt.setString(7, filme.getPlot());
            stmt.setString(8, filme.getImdbRating());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("✅ Filme inserido no banco: " + filme.getTitle());
            }

        } catch (SQLException e) {
            // Ignora erro de duplicação (PK constraint)
            if (!e.getMessage().contains("unique constraint")) {
                System.err.println("Erro ao inserir filme: " + e.getMessage());
            }
        }
    }
}
