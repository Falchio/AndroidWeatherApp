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
            int temp = (int) Math.round(tempJson.getDouble(TEMPERATURE));
            int tempFeelsLike = (int) Math.round(tempJson.getDouble(TEMPERATURE_FEELS_LIKE));
            int tempMin = (int)Math.round(tempJson.getDouble(TEMP_MIN));
            int tempMax = (int) Math.round(tempJson.getDouble(TEMP_MAX));
            temperature= new Temperature(temp, tempFeelsLike, tempMin, tempMax);

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

            if (readerJson.has(VISIBILITY)){
                clouds = new Clouds(
                        cloudsJsonObject.getInt(CLOUDS_ALL),
                        cloudsJsonMain.getInt(PRESSURE),
                        cloudsJsonMain.getInt(HUMIDITY),
                        readerJson.getInt(VISIBILITY));
            } else {
                clouds = new Clouds(
                        cloudsJsonObject.getInt(CLOUDS_ALL),
                        cloudsJsonMain.getInt(PRESSURE),
                        cloudsJsonMain.getInt(HUMIDITY));
            }

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
            // не у всех городов есть направление ветра

            int windSpeed = (int) Math.round(windJson.getDouble(WIND_SPEED));
            
            if (windJson.has(WIND_DEGREES)){
                wind = new Wind(
                        windSpeed,
                        windJson.getInt(WIND_DEGREES));
            } else {
                wind = new Wind(windSpeed);
            }

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
