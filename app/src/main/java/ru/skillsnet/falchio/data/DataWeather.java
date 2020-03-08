package ru.skillsnet.falchio.data;

public class DataWeather {

    private DLocation DLocation;
    private DTime DTime;
    private Temperature temperature;
    private Clouds clouds;
    private Weather weather;
    private Wind wind;


    public DataWeather(DLocation DLocation, DTime DTime, Temperature temperature, Clouds clouds, Weather weather, Wind wind) {
        this.DLocation = DLocation;
        this.DTime = DTime;
        this.temperature = temperature;
        this.clouds = clouds;
        this.weather = weather;
        this.wind = wind;
    }

    public DataWeather(){
        this.DLocation = new DLocation();
        this.DTime = new DTime();
        this.temperature = new Temperature();
        this.clouds = new Clouds();
        this.weather = new Weather();
        this.wind = new Wind();
    }

    public DLocation getDLocation() {
        return DLocation;
    }

    public void setDLocation(DLocation DLocation) {
        this.DLocation = DLocation;
    }

    public DTime getDTime() {
        return DTime;
    }

    public void setDTime(DTime DTime) {
        this.DTime = DTime;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }


}
