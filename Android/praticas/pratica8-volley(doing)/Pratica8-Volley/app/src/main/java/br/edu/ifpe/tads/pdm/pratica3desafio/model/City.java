package br.edu.ifpe.tads.pdm.pratica3desafio.model;

public class City {
    private String name;
    private String weather;

    public City(String name) {
        this.name = name;
    }


    public String getName() {
        return this.name;
    }
    public String getInfo() {
        return this.weather;
    }
}