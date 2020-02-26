package ru.skillsnet.falchio.data;

public class Clouds {
    private int clouds;
    private int pressure;
    private int humidity;

    public Clouds(int clouds, int pressure, int humidity) {
        this.clouds = clouds;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
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
