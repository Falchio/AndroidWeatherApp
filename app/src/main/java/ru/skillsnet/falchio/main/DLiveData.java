package ru.skillsnet.falchio.main;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class DLiveData implements LifecycleObserver {
    private final DViewModel viewModel = new DViewModel();

    public DViewModel getViewModel() {
        return viewModel;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void getWeatherData(){
        Log.d("DLIVEDATA", "getWeatherData: update ");
        viewModel.getWeatherMutableLiveData();
    }

}
