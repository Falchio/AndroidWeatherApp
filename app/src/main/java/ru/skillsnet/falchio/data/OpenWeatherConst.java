package ru.skillsnet.falchio.data;

public interface OpenWeatherConst {
    //Location class
    public final String COORDINATE = "coord";
    public final String LONGITUDE = "lon";
    public final String LATITUDE ="lat";
    public final String COUNTRY = "country";
    public final String CITY_ID = "id";
    public final String CITY_NAME = "name";

    //Weather class
    public final String WEATHER ="weather";
    public final String WEATHER_ID ="id";
    public final String WEATHER_MAIN ="main";
    public final String DESCRIPTION ="description";
    public final String WEATHER_ICON="icon";

    //Temperature class
    public final String TEMPERATURE="temp";
    public final String TEMPERATURE_FEELS_LIKE ="feels_like";
    public final String TEMP_MIN="temp_min";
    public final String TEMP_MAX="temp_max";

    //Clouds class
    public final String PRESSURE ="pressure";
    public final String HUMIDITY ="humidity";
    public final String VISIBILITY ="visibility";
    public final String CLOUDS="clouds";
    public final String CLOUDS_ALL = "all";

    //Wind class
    public final String WIND_SPEED ="speed";
    public final String WIND_DEGREES ="deg";

    //Time
    public final String DATA_TIME ="dt";
    public final String SUNRISE_TIME ="sunrise";
    public final String SUNSET_TIME ="sunset";
    public final String TIME_ZONE ="timezone";

}
