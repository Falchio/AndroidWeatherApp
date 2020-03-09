package ru.skillsnet.falchio.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.preference.PreferenceManager;

import ru.skillsnet.falchio.R;
import ru.skillsnet.falchio.data.DataWeather;

import static ru.skillsnet.MyApplication.getContext;
import static ru.skillsnet.falchio.data.GlobalConstants.OPEN_WEATHER;

public class DViewModel extends ViewModel {
    private MutableLiveData<DataWeather> weatherMutableLiveData;

    public MutableLiveData<DataWeather> getWeatherMutableLiveData(){
        if (weatherMutableLiveData==null){
            weatherMutableLiveData = new MutableLiveData<>();
                                                                        // weatherMutableLiveData не присвоено значение!
            getDataWeatherData();
        }
        return weatherMutableLiveData;
    }

    private void getDataWeatherData(){
        String userLocation= PreferenceManager.getDefaultSharedPreferences(getContext())
                .getString("location",
                        getContext().getResources().getString(R.string.default_user_location));

        weatherMutableLiveData.setValue(new WeatherFactory(
                getContext(),
                OPEN_WEATHER,
                userLocation
        ).getDataWeather());

    }
}
