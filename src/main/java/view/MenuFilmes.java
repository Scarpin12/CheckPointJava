package view;
import model.vo.FilmeVo;
import service.OmdbApiService;
import java.io.IOException;
public class MenuFilmes {
    public static void main(String[] args) throws IOException {

    OmdbApiService omdb = new OmdbApiService();

                FilmeVo filme = omdb.buscarFilme("Inception");
                System.out.println(filme);
            }
        }


