package ru.skillsnet.falchio.openweathergson;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.skillsnet.falchio.openweathergson.OpenweatherRequest;

public interface OpenWeather {
    @GET("data/2.5/weather")
    Call<OpenweatherRequest> loadWeather(@Query("q") String cityCountry, @Query("appid") String keyApi);
}
