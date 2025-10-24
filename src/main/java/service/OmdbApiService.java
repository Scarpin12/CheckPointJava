package service;
import com.google.gson.Gson;
import model.vo.BuscaFilmeVo;
import model.vo.FilmeResumoVo;
import model.vo.FilmeVo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;

public class OmdbApiService {
    private Properties properties;
    private String apiUrl;
    private String apiKey;

    public OmdbApiService() {
        properties = new Properties();

        try (InputStream input = getClass().getClassLoader().getResourceAsStream("aplicacao.properties")) {

            if (input == null) {
                throw new RuntimeException("Arquivo aplicacao.properties não encontrado!");
            }

            properties.load(input);
            apiUrl = properties.getProperty("api_url");
            apiKey = properties.getProperty("chave_api");
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar configurações da API OMDb", e);
        }
    }

    public FilmeVo buscarFilme(String titulo) throws IOException {

        String formattedTitle = titulo.replace(" ", "%20");

        String urlString = apiUrl + "?t=" + formattedTitle + "&apikey=" + apiKey + "&plot=full";

        URL url = new URL(urlString);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        if (con.getResponseCode() == 200) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                Gson gson = new Gson();
                return gson.fromJson(reader, FilmeVo.class);
            }
        } else {
            throw new IOException("Erro ao chamar OMDb API: " + con.getResponseCode());
        }
    }

    public FilmeVo buscarFilmePorId(String imdbId) throws IOException {
        String urlString = apiUrl + "?i=" + imdbId + "&apikey=" + apiKey + "&plot=full";
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        if (con.getResponseCode() == 200) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                Gson gson = new Gson();
                return gson.fromJson(reader, FilmeVo.class);
            }
        } else {
            throw new IOException("Erro ao chamar OMDb API: " + con.getResponseCode());
        }
    }

    public ArrayList<FilmeResumoVo> buscarFilmes(String palavraChave) throws IOException {
        String formatted = palavraChave.replace(" ", "%20");
        String urlString = apiUrl + "?s=" + formatted + "&apikey=" + apiKey;

        // DEBUG
        System.out.println("🔗 URL: " + urlString);

        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        System.out.println("📡 Status Code: " + con.getResponseCode());

        if (con.getResponseCode() == 200) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }

                String jsonResponse = sb.toString();

                // DEBUG - Mostra resposta completa
                System.out.println("📦 Resposta da API:");
                System.out.println(jsonResponse);
                System.out.println("---");

                Gson gson = new Gson();
                BuscaFilmeVo resultado = gson.fromJson(jsonResponse, BuscaFilmeVo.class);

                if (resultado != null && resultado.getSearch() != null) {
                    System.out.println("✅ Filmes encontrados: " + resultado.getSearch().size());
                    return resultado.getSearch();
                } else {
                    System.out.println("⚠️ Resultado vazio ou nulo");
                }

                return new ArrayList<>();
            }
        } else {
            throw new IOException("Erro ao chamar OMDb API: " + con.getResponseCode());
        }
    }


}








