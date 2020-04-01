package ru.skillsnet;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import ru.skillsnet.falchio.database.OpenWeatherDatabase;
import ru.skillsnet.falchio.roomdao.OpenWeatherDao;

public class MyApplication extends  Application{
    private static  MyApplication instance;

    private OpenWeatherDatabase database;

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
                "education_database").build();
    }

    public OpenWeatherDao getOpenWeatherDao(){
        return database.getOpenWeatherDao();
    }
}

//public class MyApplication extends Application {
//    private static Context context;
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        MyApplication.context=getApplicationContext();
//    }
//
//    public static Context getContext() {
//        return MyApplication.context;
//    }
//}

