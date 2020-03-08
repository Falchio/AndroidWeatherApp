package ru.skillsnet.falchio.parsers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ru.skillsnet.falchio.data.Clouds;
import ru.skillsnet.falchio.data.DLocation;
import ru.skillsnet.falchio.data.DTime;
import ru.skillsnet.falchio.data.DataWeather;
import ru.skillsnet.falchio.data.OpenWeatherJsonConst;
import ru.skillsnet.falchio.data.Temperature;
import ru.skillsnet.falchio.data.Weather;
import ru.skillsnet.falchio.data.Wind;

public class OpenWeatherJsonJsonParser implements OpenWeatherJsonConst {
    private String jsonStringHttp;

    public String getJsonStringHttp() {
        return jsonStringHttp;
    }

    public void setJsonStringHttp(String jsonStringHttp) {
        this.jsonStringHttp = jsonStringHttp;
    }

    public OpenWeatherJsonJsonParser(String jsonStringHttp) {
        this.jsonStringHttp = jsonStringHttp;
    }

    public DataWeather getDataWeather() {
        JSONObject readerJson;
        DataWeather dataWeather = null;

        try {
            readerJson = new JSONObject(getJsonStringHttp());

            if(readerJson.getString(COD).equals(NOT_FOUND)){ // город не найден
                dataWeather = new DataWeather();
                String message = readerJson.getString(MESSAGE);
                dataWeather.getWeather().setDescription(message);

                return dataWeather;
            }

            dataWeather = new DataWeather(
                    getLocation(readerJson),
                    getTime(readerJson),
                    getTemperature(readerJson),
                    getClouds(readerJson),
                    getWeather(readerJson),
                    getWind(readerJson)
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataWeather;
    }

    //сделать так чтобы в случае ошибки использовался конструктор по умолчанию, на случай ошибок, чтобы обеспечить хоть какую-нибудь функциональность.
    private DLocation getLocation(JSONObject readerJson) {
        DLocation DLocation;
        try{
            JSONObject coordJson = readerJson.getJSONObject(COORDINATE);
            JSONObject sysJson = readerJson.getJSONObject(SYSTEM);

            DLocation = new DLocation(
                    coordJson.getDouble(LONGITUDE),
                    coordJson.getDouble(LATITUDE),
                    sysJson.getString(COUNTRY),
                    readerJson.getInt(CITY_ID),
                    readerJson.getString(CITY_NAME)
            );

        }catch (JSONException e){
            e.printStackTrace();
            DLocation = new DLocation();
        }

        return DLocation;
    }

    private Weather getWeather(JSONObject readerJson) {
        Weather weather;

        try{
            JSONArray weatherArr = readerJson.getJSONArray(WEATHER);
            JSONObject weatherObj = weatherArr.getJSONObject(0);
            weather = new Weather(
                    weatherObj.getInt(WEATHER_ID),
                    weatherObj.getString(WEATHER_MAIN),
                    weatherObj.getString(DESCRIPTION),
                    weatherObj.getString(WEATHER_ICON)
            );
        }catch (JSONException e){
            e.printStackTrace();
            weather = new Weather();
        }

        return weather;
    }

    private Temperature getTemperature(JSONObject readerJson) {
        Temperature temperature;
        try {
            JSONObject tempJson = readerJson.getJSONObject(MAIN_TEMPERATURE);
            temperature= new Temperature(
                    tempJson.getDouble(TEMPERATURE),
                    tempJson.getDouble(TEMPERATURE_FEELS_LIKE),
                    tempJson.getDouble(TEMP_MIN),
                    tempJson.getDouble(TEMP_MAX)
            );

        } catch (JSONException e){
            e.printStackTrace();
            temperature = new Temperature();
        }
        return temperature;
    }

    private Clouds getClouds(JSONObject readerJson) {
        Clouds clouds;

        try{
            JSONObject cloudsJsonObject = readerJson.getJSONObject(CLOUDS);
            JSONObject cloudsJsonMain = readerJson.getJSONObject(MAIN_TEMPERATURE);

            //не у всех городов есть поле VISIBILITY
            int visibility;
            if (readerJson.has(VISIBILITY)){
                visibility=readerJson.getInt(VISIBILITY);
            } else {
                visibility=3000;
            }

            clouds = new Clouds(
                    cloudsJsonObject.getInt(CLOUDS_ALL),
                    cloudsJsonMain.getInt(PRESSURE),
                    cloudsJsonMain.getInt(HUMIDITY),
                    visibility
            );
        } catch (JSONException e){
            e.printStackTrace();
            clouds = new Clouds();
        }

        return clouds;
    }

    private Wind getWind(JSONObject readerJson) {
        Wind wind;

        try {
            JSONObject windJson = readerJson.getJSONObject(WIND);
            wind = new Wind(
                    windJson.getInt(WIND_SPEED),
                    windJson.getInt(WIND_DEGREES));
        } catch (JSONException e) {
            e.printStackTrace();
            wind = new Wind();
        }
        return wind;
    }

    private DTime getTime(JSONObject readerJson) {
        DTime DTime;

        try {
            JSONObject timeJsonSys = readerJson.getJSONObject(SYSTEM);
            DTime = new DTime(
                    timeJsonSys.getLong(SUNRISE_TIME),
                    timeJsonSys.getLong(SUNSET_TIME),
                    readerJson.getLong(TIME_ZONE),
                    readerJson.getLong(DATA_TIME)
            );

        }catch (JSONException e){
            e.printStackTrace();
            DTime = new DTime();
        }
        return DTime;
    }

}
