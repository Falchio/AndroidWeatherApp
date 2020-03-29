package ru.skillsnet.falchio.main;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.preference.PreferenceManager;

import ru.skillsnet.falchio.R;
import ru.skillsnet.falchio.data.DataWeather;

import static ru.skillsnet.MyApplication.getContext;
import static ru.skillsnet.falchio.data.GlobalConstants.OPEN_WEATHER;

public class DLiveData implements LifecycleObserver {
    private String TAG = this.getClass().getSimpleName();
    private final DViewModel viewModel = new DViewModel();

    public DViewModel getViewModel() {
        return viewModel;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void getWeatherData() {
        Log.d("DLIVEDATA", "getWeatherData: update ");


        String userLocation = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getString("location",
                        getContext().getResources().getString(R.string.default_user_location));

        DataWeather dataWeather = new WeatherFactory(
                getContext(),
                OPEN_WEATHER,
                userLocation
        ).getDataWeather();

        viewModel.getWeatherMutableLiveData().setValue(dataWeather);
    }
}

