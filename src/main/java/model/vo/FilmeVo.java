package model.vo;

public class FilmeVo {

    // Campos com letra MAIÚSCULA para o Gson mapear automaticamente
    private String Title;
    private String Year;
    private String Genre;
    private String Director;
    private String Poster;
    private String Plot;
    private String imdbRating;
    private String imdbID;

    public FilmeVo() {}

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public String getPlot() {
        return Plot;
    }

    public void setPlot(String plot) {
        Plot = plot;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    @Override
    public String toString() {
        return "\n╔════════════════════════════════════════════════════╗\n" +
                "  🎬 " + Title + "\n" +
                "╠════════════════════════════════════════════════════╣\n" +
                "  📅 Ano: " + Year + "\n" +
                "  🎭 Genero: " + Genre + "\n" +
                "  🎬 Diretor: " + Director + "\n" +
                "  ⭐ Avaliação: " + imdbRating + "\n" +
                "  📖 Sinopse: " + "\n"  + Plot + "\n" +
                "╚════════════════════════════════════════════════════╝";
    }
}
