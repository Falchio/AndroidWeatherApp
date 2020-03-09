package ru.skillsnet.falchio.data;

public class DLocation {
    private double coordLat;
    private double coordLon;
    private String country;
    private int cityId;
    private String cityName;

    public DLocation(double coordLon, double coordLat, String country, int cityId, String cityName) {
        this.coordLon = coordLon;
        this.coordLat = coordLat;
        this.country = country;
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public DLocation(){
        this.coordLat = 0;
        this.coordLon = 0;
        this.country = "Country not defined";
        this.cityId = 0;
        this.cityName = "City not defined";
    }

    public double getCoordLat() {
        return coordLat;
    }

    public double getCoordLon() {
        return coordLon;
    }

    public String getCountry() {
        return country;
    }

    public int getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

}
