package ru.skillsnet.falchio.main;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class DLiveData implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void getWeatherData(){
        Log.e("LiveDataObserver", "Запрашиваем данные");

    }

}
