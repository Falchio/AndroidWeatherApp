package ru.skillsnet.falchio.data;

import ru.skillsnet.falchio.R;

public class Location {
    private double coordLat;
    private double coordLon;
    private String country;
    private int cityId;
    private String cityName;

    public Location(double coordLat, double coordLon, String country, int cityId, String cityName) {
        this.coordLat = coordLat;
        this.coordLon = coordLon;
        this.country = country;
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public Location(){
        this.coordLat = 0;
        this.coordLon = 0;
        this.country = "Country not defined";
        this.cityId = 0;
        this.cityName = "City not defined";
    }

    public double getCoordLat() {
        return coordLat;
    }

    public void setCoordLat(double coordLat) {
        this.coordLat = coordLat;
    }

    public double getCoordLon() {
        return coordLon;
    }

    public void setCoordLon(double coordLon) {
        this.coordLon = coordLon;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
