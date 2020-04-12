package ru.skillsnet;

import android.app.Application;

import androidx.room.Room;

import ru.skillsnet.falchio.database.OpenWeatherDatabase;
import ru.skillsnet.falchio.main.DLiveData;
import ru.skillsnet.falchio.main.DViewModel;
import ru.skillsnet.falchio.roomdao.OpenWeatherDao;

public class MyApplication extends  Application{
    private static  MyApplication instance;
    private OpenWeatherDatabase database;
    private final DLiveData liveData = new DLiveData();
    private final DViewModel model = liveData.getViewModel();

    public DLiveData getLiveData() {
        return liveData;
    }

    public DViewModel getModel() {
        return model;
    }

    public static MyApplication getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        database = Room.databaseBuilder(
                getApplicationContext(),
                OpenWeatherDatabase.class,
                "openweather")
                .allowMainThreadQueries()
                .build();
    }

    public OpenWeatherDao getOpenWeatherDao(){
        return database.getOpenWeatherDao();
    }
}
