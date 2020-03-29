package ru.skillsnet.falchio.data;

public class MyWeather {
    private int weatherId;
    private String weatherMain;
    private String description;
    private String weatherIcon;

    public MyWeather(int weatherId, String weatherMain, String description, String weatherIcon) {
        this.weatherId = weatherId;
        this.weatherMain = weatherMain;
        this.description = description;
        this.weatherIcon = weatherIcon;
    }

    public MyWeather() {
        this.weatherId = 0;
        this.weatherMain = "null";
        this.description = "null";
        this.weatherIcon = "01n";
    }

    public int getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }

    public String getWeatherMain() {
        return weatherMain;
    }

    public void setWeatherMain(String weatherMain) {
        this.weatherMain = weatherMain;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(String weatherIcon) {
        this.weatherIcon = weatherIcon;
    }
}
