package ru.skillsnet.falchio.main;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ru.skillsnet.falchio.openweathergson.OpenweatherRequest;


public class DViewModel extends ViewModel {
    private MutableLiveData<OpenweatherRequest> openWeatherMutableLiveData;

    public MutableLiveData<OpenweatherRequest> getOpenWeatherMutableLiveData(){
        if (openWeatherMutableLiveData==null) {
            openWeatherMutableLiveData = new MutableLiveData<>();            // weatherMutableLiveData не присвоено значение!
        }

        return openWeatherMutableLiveData;
    }
}
