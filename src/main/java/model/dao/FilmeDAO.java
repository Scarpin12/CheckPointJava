package model.dao;

import model.vo.FilmeVo;
import service.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {

    public FilmeVo montarFilme(ResultSet rs) throws SQLException {
        FilmeVo filme = new FilmeVo();
        filme.setImdbID(rs.getString("id_filme"));
        filme.setTitulo(rs.getString("titulo"));
        filme.setAno(rs.getString("ano"));
        filme.setGenero(rs.getString("genero"));
        filme.setDiretor(rs.getString("diretor"));
        filme.setPoster(rs.getString("poster"));
        filme.setSinopse(rs.getString("sinopse"));
        filme.setAvaliacao(rs.getString("avaliacao"));
        return filme;
    }


    public List<FilmeVo> buscarPorGenero(String genero) {
        List<FilmeVo> filmes = new ArrayList<>();
        String sql = "SELECT * FROM TB_FILME WHERE genero = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, genero);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                FilmeVo filme = montarFilme(rs);
                filmes.add(filme);
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


}
