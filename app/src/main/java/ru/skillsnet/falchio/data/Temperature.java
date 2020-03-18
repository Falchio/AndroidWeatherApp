package ru.skillsnet.falchio.data;

public class Temperature {

    private int temp;
    private int tempFeelsLike;
    private int tempMin;
    private int tempMax;

    public Temperature(int temp, int tempFeelsLike, int tempMin, int tempMax) {
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

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getTempFeelsLike() {
        return tempFeelsLike;
    }

    public void setTempFeelsLike(int tempFeelsLike) {
        this.tempFeelsLike = tempFeelsLike;
    }

    public int getTempMin() {
        return tempMin;
    }

    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }

    public int getTempMax() {
        return tempMax;
    }

    public void setTempMax(int tempMax) {
        this.tempMax = tempMax;
    }
}
