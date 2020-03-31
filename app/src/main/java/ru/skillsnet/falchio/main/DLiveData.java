package ru.skillsnet.falchio.main;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.preference.PreferenceManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.skillsnet.falchio.R;
import ru.skillsnet.falchio.openweathergson.OpenWeather;
import ru.skillsnet.falchio.openweathergson.OpenweatherRequest;

import static ru.skillsnet.MyApplication.getContext;
import static ru.skillsnet.falchio.data.GlobalConstants.DOMAIN;
import static ru.skillsnet.falchio.data.GlobalConstants.KEY_API;
import static ru.skillsnet.falchio.data.GlobalConstants.LANG;
import static ru.skillsnet.falchio.data.GlobalConstants.UNITS;

public class DLiveData implements LifecycleObserver {
    private final String TAG = this.getClass().getSimpleName();
    private final DViewModel viewModel = new DViewModel();
    private OpenWeather openWeather;

    public DViewModel getViewModel() {
        return viewModel;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void getWeatherData() {

        String userLocation = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getString("location",
                        getContext().getResources().getString(R.string.default_user_location));

        initRetrofit();
        requestRetrofit(userLocation, KEY_API, UNITS, LANG);
    }

    private void initRetrofit(){
        Retrofit retrofit;
        retrofit = new  Retrofit.Builder()
                .baseUrl(DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        openWeather = retrofit.create(OpenWeather.class);
    }

    private void requestRetrofit(String userLocation, String keyApi, String units, String language){
        Log.e("DWeather", "requestRetrofit: send request");
        openWeather.loadWeather(userLocation, keyApi, units, language)
        .enqueue(new Callback<OpenweatherRequest>() {
            @Override
            public void onResponse(Call<OpenweatherRequest> call, Response<OpenweatherRequest> response) {
                viewModel.getOpenWeatherMutableLiveData().setValue(response.body());

            }

            @Override
            public void onFailure(Call<OpenweatherRequest> call, Throwable t) {
                Log.e("DWeather", "onFailure: have Failure  " + t.toString());
            }
        });
    }
}

