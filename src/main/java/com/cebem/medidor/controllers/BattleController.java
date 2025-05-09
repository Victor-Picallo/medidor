package com.cebem.medidor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cebem.medidor.models.Superhero;
import com.cebem.medidor.services.SuperheroService;

import java.util.Random;

@Controller
public class BattleController {

    @Autowired
    private SuperheroService superheroService;

    @GetMapping("/battle/random")
    public String randomBattle(Model model) {
        int maxId = 731; // Cambia este valor si la API tiene otro número de héroes
        Random random = new Random();
        int id1 = random.nextInt(maxId) + 1;
        int id2;
        do {
            id2 = random.nextInt(maxId) + 1;
        } while (id2 == id1);

        Superhero hero1 = superheroService.getSuperheroById(String.valueOf(id1));
        Superhero hero2 = superheroService.getSuperheroById(String.valueOf(id2));
        Superhero winner = superheroService.getWinner(hero1, hero2);

        model.addAttribute("hero1", hero1);
        model.addAttribute("hero2", hero2);
        model.addAttribute("winner", winner);

        return "battle";
    }
}

