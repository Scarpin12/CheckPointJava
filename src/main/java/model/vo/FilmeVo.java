package model.vo;

public class FilmeVo {
        private String Title;
        private String Year;
        private String Genre;
        private String Director;
        private String Poster;
        private String Plot;

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public String getGenre() {
            return Genre;
        }

        public void setGenre(String genre) {
            Genre = genre;
        }

        public String getYear() {
            return Year;
        }

        public void setYear(String year) {
            Year = year;
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

        @Override
        public String toString() {
            return "\nFilme: " + Title +
                    "\nAno: " + Year +
                    "\nGênero: " + Genre +
                    "\nDiretor: " + Director +
                    "\nSinopse: " + Plot +
                    "\nPoster: " + Poster;
        }
    }


