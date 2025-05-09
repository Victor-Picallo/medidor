package com.cebem.medidor.models;

public class Superhero {
    private String id;
    private String name;
    private String imageUrl;
    private Powerstats powerstats;

    // Getters y setters

    public static class Powerstats {
        private int intelligence;
        private int strength;
        private int speed;
        private int durability;
        private int power;
        private int combat;

        // Getters y setters
    }

    // Método para sumar todas las estadísticas
    public int getTotalPower() {
        return powerstats.intelligence + powerstats.strength + powerstats.speed +
               powerstats.durability + powerstats.power + powerstats.combat;
    }
}
