package ru.skillsnet.falchio.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import ru.skillsnet.falchio.data.DataWeather;


public class DViewModel extends ViewModel {
    private MutableLiveData<DataWeather> weatherMutableLiveData;

    public MutableLiveData<DataWeather> getWeatherMutableLiveData(){
        if (weatherMutableLiveData==null) {
            weatherMutableLiveData = new MutableLiveData<>();            // weatherMutableLiveData не присвоено значение!
        }

        return weatherMutableLiveData;
    }
}
