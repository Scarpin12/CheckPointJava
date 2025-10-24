package model.vo;

import java.util.ArrayList;

public class BuscaFilmeVo {
    private ArrayList<FilmeResumoVo> Search;
    private String totalResults;
    private String Response;

    // Getters e Setters
    public ArrayList<FilmeResumoVo> getSearch() {
        return Search;
    }

    public void setSearch(ArrayList<FilmeResumoVo> search) {
        Search = search;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }
}
