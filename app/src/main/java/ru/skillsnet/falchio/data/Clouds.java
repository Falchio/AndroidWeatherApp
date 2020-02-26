package ru.skillsnet.falchio.data;

public class Clouds {
    private int clouds;
    private int pressure;
    private int humidity;
    private int visibility;

    public Clouds(int clouds, int pressure, int humidity, int visibility) {
        this.clouds = clouds;
        this.pressure = pressure;
        this.humidity = humidity;
        this.visibility=visibility;
    }

    public Clouds(){
        this.clouds = 0;
        this.pressure = 0;
        this.humidity = 0;
        this.visibility=0;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
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
