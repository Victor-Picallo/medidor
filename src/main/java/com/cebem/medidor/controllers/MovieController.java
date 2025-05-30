package com.cebem.medidor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cebem.medidor.models.Movie;
import com.cebem.medidor.services.MovieService;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/peliculas")
    public String showForm() {
        return "index";
    }

@PostMapping("/search")
public String searchMovie(@RequestParam String title, Model model) {
    Movie movie = movieService.getMovieByTitle(title);
    System.out.println("DEBUG >>> " + movie);
    model.addAttribute("movie", movie);
    return "index";
}

}