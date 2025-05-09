package com.cebem.medidor.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cebem.medidor.models.Superhero;

@Service
public class SuperheroService {
    private static final String API_KEY = "664d2ab5bcc2886fe0ae1b6f79541255";
    private static final String API_URL = "https://superheroapi.com/api/" + API_KEY + "/";

    private final RestTemplate restTemplate = new RestTemplate();

    public Superhero getSuperheroById(String id) {
        String url = API_URL + id;
        return restTemplate.getForObject(url, Superhero.class);
    }

    public Superhero getWinner(Superhero hero1, Superhero hero2) {
        return hero1.getTotalPower() >= hero2.getTotalPower() ? hero1 : hero2;
    }
}
