package com.cebem.medidor.models;

public class Superhero {
    private String id;
    private String name;
    private Powerstats powerstats;
    private Image image;

    // Getters y setters

    public Powerstats getPowerstats() {
        return powerstats;
    }

    public void setPowerstats(Powerstats powerstats) {
        this.powerstats = powerstats;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Suma de estadísticas (conversión de String a int)
    public int getTotalPower() {
        return parseStat(powerstats.intelligence)
                + parseStat(powerstats.strength)
                + parseStat(powerstats.speed)
                + parseStat(powerstats.durability)
                + parseStat(powerstats.power)
                + parseStat(powerstats.combat);
    }

    private int parseStat(String stat) {
        try {
            return Integer.parseInt(stat);
        } catch (Exception e) {
            return 0;
        }
    }

    public static class Powerstats {
        private String intelligence;
        private String strength;
        private String speed;
        private String durability;
        private String power;
        private String combat;

        // Getters y setters
        public String getIntelligence() { return intelligence; }
        public void setIntelligence(String intelligence) { this.intelligence = intelligence; }
        public String getStrength() { return strength; }
        public void setStrength(String strength) { this.strength = strength; }
        public String getSpeed() { return speed; }
        public void setSpeed(String speed) { this.speed = speed; }
        public String getDurability() { return durability; }
        public void setDurability(String durability) { this.durability = durability; }
        public String getPower() { return power; }
        public void setPower(String power) { this.power = power; }
        public String getCombat() { return combat; }
        public void setCombat(String combat) { this.combat = combat; }
    }

    public static class Image {
        private String url;

        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }
    }
}
