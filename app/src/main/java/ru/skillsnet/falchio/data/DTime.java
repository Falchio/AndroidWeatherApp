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

    public long getSunsetTime() {
        return sunsetTime;
    }

    public long getTimezone() {
        return timezone;
    }

    public long getDataTime() {
        return dataTime;
    }

}
