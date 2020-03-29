package ru.skillsnet.falchio.data;

public class MyClouds {
    private int clouds;
    private int pressure;
    private int humidity;
    private int visibility;

    public MyClouds(int clouds, int pressure, int humidity, int visibility) {
        this.clouds = clouds;
        this.pressure = pressure;
        this.humidity = humidity;
        this.visibility=visibility;
    }

    public MyClouds(int clouds, int pressure, int humidity) {
        this.clouds = clouds;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public MyClouds(){
        this.clouds = -99;
        this.pressure = -99;
        this.humidity = -99;
        this.visibility=-99;
    }

    public int getVisibility() {
        return visibility;
    }


    public int getAtmPressure(){
        int atmPressure;
        double pressure = this.getPressure();
        double RATIO = 0.75006375541921;
        atmPressure =(int) (pressure* RATIO);
        return atmPressure;
    }

    public int getClouds() {
        return clouds;
    }

    private int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

}
