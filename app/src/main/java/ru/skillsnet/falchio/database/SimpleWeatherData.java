package ru.skillsnet.falchio.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity(indices = {@Index(value = {"city name"})}, tableName = "openweather")
public class SimpleWeatherData {

    @PrimaryKey(autoGenerate = true)
    private long idRoom;

    @ColumnInfo(name = "city name")
    private String cityName;

    @ColumnInfo(name = "dt")
    private long dt;

    @ColumnInfo(name = "temperature")
    private long temperature;

    public SimpleWeatherData(String cityName, long dt, long temperature) {
        this.cityName = cityName;
        this.dt = dt;
        this.temperature = temperature;
    }

    public String getSimpleDataString(){
        Date date = new java.util.Date(this.dt*1000L);
        SimpleDateFormat sdf = new java.text.SimpleDateFormat(" d MMM yyyy, HH:mm");
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+3"));
        return sdf.format(date)+" " + this.cityName + " " + this.temperature;
    }

    public long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(long idRoom) {
        this.idRoom = idRoom;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public long getTemperature() {
        return temperature;
    }

    public void setTemperature(long temperature) {
        this.temperature = temperature;
    }



}
