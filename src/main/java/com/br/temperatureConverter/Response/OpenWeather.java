package com.br.temperatureConverter.Response;

import java.io.Serializable;

public class OpenWeather implements Serializable {

    private Content main;
    private Coordinates coord;
    private int visibility;

    public OpenWeather() {
    }

    public OpenWeather(Content main, Coordinates coord, int visibility) {
        this.main = main;
        this.coord = coord;
        this.visibility = visibility;
    }

    public Content getMain() {
        return main;
    }

    public void setMain(Content main) {
        this.main = main;
    }

    public Coordinates getCoord() {
        return coord;
    }

    public void setCoord(Coordinates coord) {
        this.coord = coord;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

}