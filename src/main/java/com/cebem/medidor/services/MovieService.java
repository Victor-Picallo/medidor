package com.cebem.medidor.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.cebem.medidor.models.Movie;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
public class MovieService {

    private final String API_KEY = "30361a34"; // Pon aquí tu API Key de OMDb

    public Movie getMovieByTitle(String title) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://www.omdbapi.com/?apikey=" + API_KEY + "&t=" + URLEncoder.encode(title, StandardCharsets.UTF_8);

            // Obtener la respuesta como un Map
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
            System.out.println("RAW RESPONSE >>> " + response); // Para depuración

            // Mapear manualmente los campos relevantes
            Movie movie = new Movie();
            movie.setTitle((String) response.get("Title"));
            movie.setYear((String) response.get("Year"));
            movie.setGenre((String) response.get("Genre"));
            movie.setDirector((String) response.get("Director"));
            movie.setPlot((String) response.get("Plot"));
            movie.setPoster((String) response.get("Poster"));
            movie.setResponse((String) response.get("Response"));
            movie.setError((String) response.get("Error"));

            return movie;
        } catch (Exception e) {
            Movie errorMovie = new Movie();
            errorMovie.setError("Error consultando OMDb API: " + e.getMessage());
            return errorMovie;
        }
    }
}
