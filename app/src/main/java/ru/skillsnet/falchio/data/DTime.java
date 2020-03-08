package ru.skillsnet.falchio.data;

public class DTime {

    private long sunriseTime;
    private long sunsetTime;
    private long timezone;
    private long dataTime;

    public DTime(long sunriseTime, long sunsetTime, long timezone, long dataTime) {
        this.sunriseTime = sunriseTime;
        this.sunsetTime = sunsetTime;
        this.timezone = timezone;
        this.dataTime = dataTime;
    }

    public DTime() {
        this.sunriseTime = 0;
        this.sunsetTime = 0;
        this.timezone = 0;
        this.dataTime = 0;
    }

    public long getSunriseTime() {
        return sunriseTime;
    }

    public void setSunriseTime(long sunriseTime) {
        this.sunriseTime = sunriseTime;
    }

    public long getSunsetTime() {
        return sunsetTime;
    }

    public void setSunsetTime(long sunsetTime) {
        this.sunsetTime = sunsetTime;
    }

    public long getTimezone() {
        return timezone;
    }

    public void setTimezone(long timezone) {
        this.timezone = timezone;
    }

    public long getDataTime() {
        return dataTime;
    }

    public void setDataTime(long dataTime) {
        this.dataTime = dataTime;
    }
}
