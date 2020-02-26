package ru.skillsnet.falchio.data;

public class DataWeather {

    private Location location;
    private Time time;
    private Temperature temperature;
    private Clouds clouds;
    private Weather weather;
    private Wind wind;


    public DataWeather(Location location, Time time, Temperature temperature, Clouds clouds, Weather weather, Wind wind) {
        this.location = location;
        this.time = time;
        this.temperature = temperature;
        this.clouds = clouds;
        this.weather = weather;
        this.wind = wind;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
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
