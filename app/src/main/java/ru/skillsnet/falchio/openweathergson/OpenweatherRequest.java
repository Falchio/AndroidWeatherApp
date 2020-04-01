package ru.skillsnet.falchio.openweathergson;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(indices = {@Index(value = {"name"})}, tableName = "openweather")
public class OpenweatherRequest {

    @PrimaryKey(autoGenerate = true)
    public long idRoom;

    @ColumnInfo(name = "coord")
    @SerializedName("coord")
    private Coord coord;

    @ColumnInfo(name = "weather")
    @SerializedName("weather")
    private Weather[] weather;

    @ColumnInfo(name = "info")
    @SerializedName("base")
    private String base;

    @ColumnInfo(name = "main")
    @SerializedName("main")
    private Main main;

    @ColumnInfo(name = "visibility")
    @SerializedName("visibility")
    private int visibility;

    @ColumnInfo(name = "wind")
    @SerializedName("wind")
    private Wind wind;

    @ColumnInfo(name = "clouds")
    @SerializedName("clouds")
    private Clouds clouds;

    @ColumnInfo(name ="dt")
    @SerializedName("dt")
    private long dt;

    @ColumnInfo(name = "sys")
    @SerializedName("sys")
    private Sys sys;

    @ColumnInfo(name = "id")
    @SerializedName("id")
    private long id;

    @ColumnInfo(name = "name")
    @SerializedName("name")
    private String name;

    @ColumnInfo(name = "cod")
    @SerializedName("cod")
    private int cod;


    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

}
