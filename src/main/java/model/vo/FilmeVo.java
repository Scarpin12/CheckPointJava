package model.vo;

public class FilmeVo {
    // Campos da API
    private String titulo;
    private String ano;
    private String genero;
    private String diretor;
    private String Poster;
    private String sinopse;
    private String avaliacao;
    private String imdbID;


    public FilmeVo(){

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    @Override
    public String toString() {
        return "FilmeVo{" +
                "titulo='" + titulo + '\'' +
                ", ano='" + ano + '\'' +
                ", genero='" + genero + '\'' +
                ", diretor='" + diretor + '\'' +
                ", Poster='" + Poster + '\'' +
                ", sinopse='" + sinopse + '\'' +
                ", avaliacao='" + avaliacao + '\'' +
                ", imdbID='" + imdbID + '\'' +
                '}';
    }
}

