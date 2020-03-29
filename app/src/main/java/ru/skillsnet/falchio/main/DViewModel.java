package ru.skillsnet.falchio.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import ru.skillsnet.falchio.data.DataWeather;
import ru.skillsnet.falchio.openweathergson.OpenweatherRequest;


public class DViewModel extends ViewModel {
    private MutableLiveData<DataWeather> weatherMutableLiveData;
    private MutableLiveData<OpenweatherRequest> openWeatherMutableLiveData;

    // мой старый класс
    public MutableLiveData<DataWeather> getWeatherMutableLiveData(){
        if (weatherMutableLiveData==null) {
            weatherMutableLiveData = new MutableLiveData<>();            // weatherMutableLiveData не присвоено значение!
        }

        return weatherMutableLiveData;
    }

    // для ретрофит
    public MutableLiveData<OpenweatherRequest> getOpenWeatherMutableLiveData(){
        if (openWeatherMutableLiveData==null) {
            openWeatherMutableLiveData = new MutableLiveData<>();            // weatherMutableLiveData не присвоено значение!
        }

        return openWeatherMutableLiveData;
    }
}
