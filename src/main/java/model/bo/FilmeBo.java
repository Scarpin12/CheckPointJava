package model.bo;

import model.dao.FilmeDAO;
import model.vo.FilmeResumoVo;
import model.vo.FilmeVo;
import service.OmdbApiService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilmeBo {

    private OmdbApiService omdbService;
    private FilmeDAO filmeDAO;

    public FilmeBo() {
        this.omdbService = new OmdbApiService();
        this.filmeDAO = new FilmeDAO();
    }
/// faz uma lista de filmes atravez da busca
    public List<FilmeResumoVo> buscarESincronizarFilmes(String termoBusca) throws IOException {
        ArrayList<FilmeResumoVo> filmesApi = omdbService.buscarFilmes(termoBusca);

        for (FilmeResumoVo resumo : filmesApi) {
            sincronizarFilme(resumo.getImdbID());
        }

        return filmesApi;
    }
/// salvar no banco
    private void sincronizarFilme(String imdbId) throws IOException {
        FilmeVo filmeExistente = filmeDAO.buscarPorId(imdbId);

        if (filmeExistente == null) {
            FilmeVo filmeCompleto = omdbService.buscarFilmePorId(imdbId);

            if (filmeCompleto != null && filmeCompleto.getTitle() != null) {
                filmeDAO.inserir(filmeCompleto);
                System.out.println("✅ Salvo: " + filmeCompleto.getTitle());
            }
        }
    }

    public FilmeVo buscarDetalhesFilme(String imdbId) throws IOException {
        FilmeVo filme = filmeDAO.buscarPorId(imdbId);

        if (filme == null) {
            System.out.println("🔍 Carregando busca da  API...");
            filme = omdbService.buscarFilmePorId(imdbId);

            if (filme != null && filme.getTitle() != null) {
                filmeDAO.inserir(filme);
                System.out.println("✅ salvo no Banco de dados");
            }
        } else {
            System.out.println("📦 Carregando Banco de Dados");
        }

        return filme;
    }
}