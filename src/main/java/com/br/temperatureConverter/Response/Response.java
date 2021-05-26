package com.br.temperatureConverter.Response;

public class Response {
    private float temperature;
    private String coordinates;
    private int pressure;
    private int humidity;

    public Response() {

    }

    public Response(float temperature, String coordinates, int pressure, int humidity) {
        this.temperature = temperature;
        this.coordinates = coordinates;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

}
