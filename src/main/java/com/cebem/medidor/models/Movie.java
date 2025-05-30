package com.cebem.medidor.models;

import lombok.Data;

@Data
public class Movie {
    private String Title;
    private String Year;
    private String Genre;
    private String Director;
    private String Plot;
    private String Poster;
    private String Error;    // para mostrar errores de la API
    private String Response; // para saber si la búsqueda fue exitosa
}

