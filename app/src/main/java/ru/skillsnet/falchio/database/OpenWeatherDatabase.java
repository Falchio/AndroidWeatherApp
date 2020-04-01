package ru.skillsnet.falchio.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.skillsnet.falchio.openweathergson.OpenweatherRequest;
import ru.skillsnet.falchio.roomdao.OpenWeatherDao;

@Database(entities={OpenweatherRequest.class}, version = 1, exportSchema = false)
public abstract class OpenWeatherDatabase extends RoomDatabase {
    public abstract OpenWeatherDao getOpenWeatherDao();

}
