package model.vo;

import java.util.ArrayList;
import java.util.List;

public class BuscaFilmeVo {
    private List<FilmeResumoVo> search;
    private String totalResults;
    private String response;

    public ArrayList<FilmeResumoVo> getSearch() {
        return (ArrayList<FilmeResumoVo>) search;
    }

    public void setSearch(List<FilmeResumoVo> search) {
        this.search = search;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

}
