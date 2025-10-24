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

    public List<FilmeResumoVo> buscarFilmes(String termoBusca) throws IOException {
        return filmeBO.buscarESincronizarFilmes(termoBusca);
    }

    public FilmeVo buscarDetalhes(String imdbId) throws IOException {
        return filmeBO.buscarDetalhesFilme(imdbId);
    }
}
