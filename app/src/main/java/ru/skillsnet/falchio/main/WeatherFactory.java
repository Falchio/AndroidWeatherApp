package ru.skillsnet.falchio.main;

import android.content.Context;
import android.widget.Toast;


import java.util.concurrent.ExecutionException;

import ru.skillsnet.falchio.R;
import ru.skillsnet.falchio.data.Clouds;
import ru.skillsnet.falchio.data.GlobalConstants;
import ru.skillsnet.falchio.data.DataWeather;
import ru.skillsnet.falchio.data.Location;
import ru.skillsnet.falchio.data.Temperature;
import ru.skillsnet.falchio.data.Time;
import ru.skillsnet.falchio.data.Weather;
import ru.skillsnet.falchio.data.Wind;
import ru.skillsnet.falchio.parsers.JsonTask;
import ru.skillsnet.falchio.parsers.OpenWeatherJsonJsonParser;

public class WeatherFactory implements GlobalConstants {
    private String TAG = this.getClass().getSimpleName();
    private String dataSource;
    private String userLocation;
    private Context context;


    public WeatherFactory(Context context, String dataSource, String userLocation) {
        this.context = context;
        this.dataSource = dataSource;
        this.userLocation = userLocation;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public DataWeather getDataWeather() {
        DataWeather dataWeather = null;

        switch (this.getDataSource()) {
            case (OPEN_WEATHER):

                String url = OW_DOMAIN + this.getUserLocation() + OW_API;
                String jsonStringFromHttp = null;

//                 запрос объекта JSON с url в виде строки
                try {
//                     запрашиваем данные по апи от OpenWeather, пытаемся получить JSON объект строкой.
                    jsonStringFromHttp = new JsonTask().execute(url).get();

                    // на случай если не удалось получить JSON объект строкой
                    if (jsonStringFromHttp==null) {
                        Toast.makeText(this.getContext(), R.string.no_connection + OPEN_WEATHER, Toast.LENGTH_SHORT ).show();
                        return new DataWeather(
                                new Location(),
                                new Time(),
                                new Temperature(),
                                new Clouds(),
                                new Weather(),
                                new Wind());
                    }

                  //запрашиваем создание объекта DataWeather из полученной строки
                    dataWeather = new OpenWeatherJsonJsonParser(jsonStringFromHttp).getDataWeather();

                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }

                break;
            case (YANDEX):
                break;
            default:
                break;
        }


        return dataWeather;
    }
}
