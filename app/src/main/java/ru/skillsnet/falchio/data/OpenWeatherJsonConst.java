package ru.skillsnet.falchio.data;

public interface OpenWeatherJsonConst {
    //Location class
    String COORDINATE = "coord";
    String LONGITUDE = "lon";
    String LATITUDE ="lat";
    String COUNTRY = "country";
    String CITY_ID = "id";
    String CITY_NAME = "name";
    String SYSTEM = "sys";

    //Weather class
    String WEATHER ="weather";
    String WEATHER_ID ="id";
    String WEATHER_MAIN ="main";
    String DESCRIPTION ="description";
    String WEATHER_ICON="icon";

    //Temperature class
    String MAIN_TEMPERATURE = "main";
    String TEMPERATURE="temp";
    String TEMPERATURE_FEELS_LIKE ="feels_like";
    String TEMP_MIN="temp_min";
    String TEMP_MAX="temp_max";

    //Clouds class
    String PRESSURE ="pressure";
    String HUMIDITY ="humidity";
    String VISIBILITY ="visibility";
    String CLOUDS="clouds";
    String CLOUDS_ALL = "all";

    //Wind class
    String WIND = "wind";
    String WIND_SPEED ="speed";
    String WIND_DEGREES ="deg";

    //Time
    String DATA_TIME ="dt";
    String SUNRISE_TIME ="sunrise";
    String SUNSET_TIME ="sunset";
    String TIME_ZONE ="timezone";

}
