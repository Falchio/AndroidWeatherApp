package ru.skillsnet.falchio.data;

public class Wind {
    private int windSpeed;
    private int windDeg;

    public Wind(int windSpeed, int windDeg) {
        this.windSpeed = windSpeed;
        this.windDeg = windDeg;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(int windDeg) {
        this.windDeg = windDeg;
    }
}
