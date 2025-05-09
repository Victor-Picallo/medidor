package com.cebem.medidor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cebem.medidor.models.Superhero;
import com.cebem.medidor.services.SuperheroService;

@Controller
public class BattleController {

    @Autowired
    private SuperheroService superheroService;

    @GetMapping("/battle")
    public String battle(
        @RequestParam String id1,
        @RequestParam String id2,
        Model model
    ) {
        Superhero hero1 = superheroService.getSuperheroById(id1);
        Superhero hero2 = superheroService.getSuperheroById(id2);
        Superhero winner = superheroService.getWinner(hero1, hero2);

        model.addAttribute("hero1", hero1);
        model.addAttribute("hero2", hero2);
        model.addAttribute("winner", winner);

        return "battle";
    }
}
