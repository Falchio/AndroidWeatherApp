package ru.skillsnet.falchio.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;


import ru.skillsnet.falchio.roomdao.OpenWeatherDao;

@Database(entities={SimpleWeatherData.class}, version = 1, exportSchema = false)
public abstract class OpenWeatherDatabase extends RoomDatabase {
    public abstract OpenWeatherDao getOpenWeatherDao();

}
