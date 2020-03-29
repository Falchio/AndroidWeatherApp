package ru.skillsnet.falchio.data;

public class MyWind {
    private int windSpeed;
    private int windDeg;

    public MyWind(int windSpeed, int windDeg) {
        this.windSpeed = windSpeed;
        this.windDeg = windDeg;
    }

    public MyWind(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public MyWind() {
        this.windSpeed = -1;
        this.windDeg = 0;
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

    public String getWindDirection(){
        String[] compass = new String[] {"N","NNE","NE","ENE","E","ESE","SE","SSE","S","SSW","SW","WSW","W","WNW","NW","NNW","N"};
        int index = (int) Math.round((this.windDeg % 360) / 22.5 );
        return compass[index];
    }
}
