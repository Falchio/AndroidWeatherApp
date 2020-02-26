package ru.skillsnet.falchio.data;

public class Temperature {

    private double temp;
    private double tempFeelsLike;
    private double tempMin;
    private double tempMax;

    public Temperature(double temp, double tempFeelsLike, double tempMin, double tempMax) {
        this.temp = temp;
        this.tempFeelsLike = tempFeelsLike;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
    }

    public Temperature() {
        this.temp = -200;
        this.tempFeelsLike = -200;
        this.tempMin = -200;
        this.tempMax = -200;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getTempFeelsLike() {
        return tempFeelsLike;
    }

    public void setTempFeelsLike(double tempFeelsLike) {
        this.tempFeelsLike = tempFeelsLike;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }
}
