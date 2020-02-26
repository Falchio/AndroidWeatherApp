package ru.skillsnet.falchio.parsers;

import org.json.JSONException;
import org.json.JSONObject;

import ru.skillsnet.falchio.data.Clouds;
import ru.skillsnet.falchio.data.DataWeather;
import ru.skillsnet.falchio.data.Location;
import ru.skillsnet.falchio.data.Temperature;
import ru.skillsnet.falchio.data.Time;
import ru.skillsnet.falchio.data.Weather;
import ru.skillsnet.falchio.data.Wind;

public class OpenWeatherJsonParser {
    private String jsonStringHttp;

    public String getJsonStringHttp() {
        return jsonStringHttp;
    }

    public void setJsonStringHttp(String jsonStringHttp) {
        this.jsonStringHttp = jsonStringHttp;
    }

    public OpenWeatherJsonParser(String jsonStringHttp) {
        this.jsonStringHttp = jsonStringHttp;
    }

    public DataWeather getDataWeather(){
        JSONObject readerJson;
        Location location;
        Weather weather;
        Temperature temperature;
        Clouds clouds;
        Wind wind;
        Time time;
        DataWeather dataWeather = null;

        try {
            readerJson = new JSONObject(getJsonStringHttp());
            location = getLocation(readerJson);
            weather = getWeather(readerJson);
            temperature = getTemperature(readerJson);
            clouds = getClouds(readerJson);
            wind = getWind(readerJson);
            time = getTime(readerJson);
            dataWeather = new DataWeather(location,time,temperature,clouds,weather,wind);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }


        return dataWeather;
    }

    //сделать так чтобы в случае ошибки использовался конструктор по умолчанию, на случай ошибок, чтобы обеспечить хоть какую-нибудь функциональность.
    private Location getLocation(JSONObject readerJson){
        Location location = null;
        return location;
    }

    private Weather getWeather(JSONObject readerJson){
        Weather weather = null;
        return weather;
    }

    private Temperature getTemperature(JSONObject readerJson){
        Temperature temperature = null;
        return temperature;
    }

    private Clouds getClouds(JSONObject readerJson){
        Clouds clouds = null;
        return clouds;
    }

    private Wind getWind(JSONObject readerJson){
        Wind wind = null;
        return wind;
    }

    private Time getTime(JSONObject readerJson){
        Time time= null;
        return time;
    }




}
