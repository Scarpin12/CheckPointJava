package controller;
import model.bo.FilmeBo;
import model.vo.FilmeResumoVo;
import model.vo.FilmeVo;

import java.io.IOException;
import java.util.List;

public class FilmeController {

    private FilmeBo filmeBO;

    public FilmeController() {
        this.filmeBO = new FilmeBo();
    }

    /**
     * Busca filmes por termo e sincroniza com banco
     */
    public List<FilmeResumoVo> buscarFilmes(String termoBusca) throws IOException {
        // Valida entrada
        if (!filmeBO.validarTermoBusca(termoBusca)) {
            throw new IllegalArgumentException("Termo de busca inválido");
        }

        return filmeBO.buscarESincronizarFilmes(termoBusca);
    }

    /**
     * Busca detalhes de um filme
     */
    public FilmeVo buscarDetalhes(String imdbId) throws IOException {
        if (imdbId == null || imdbId.trim().isEmpty()) {
            throw new IllegalArgumentException("ID do filme inválido");
        }

        return filmeBO.buscarDetalhesFilme(imdbId);
    }

    /**
     * Busca filmes por gênero no banco
     */
    public List<FilmeVo> listarPorGenero(String genero) {
        return filmeBO.buscarPorGenero(genero);
    }
}

