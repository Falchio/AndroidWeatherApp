package ru.skillsnet.falchio.openweathergson;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeather {
    @GET("data/2.5/weather")
    Call<OpenweatherRequest> loadWeather(@Query("q") String cityCountry, @Query("appid") String keyApi, @Query("units") String units, @Query("lang") String language);

    @GET("data/2.5/weather")
    Call<OpenweatherRequest> loadWeather(@Query("lat") String lat, @Query("lon") String lon, @Query("appid") String keyApi, @Query("units") String units, @Query("lang") String language);
}
