package ru.skillsnet.falchio.roomdao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.skillsnet.falchio.database.SimpleWeatherData;

@Dao
public interface OpenWeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOpenWeatherRequest(SimpleWeatherData simpleWeatherData);

    @Update
    void updateOpenWeatherRequest(SimpleWeatherData simpleWeatherData);

    @Delete
    void deleteOpenWeatherRequest(SimpleWeatherData simpleWeatherData);

    @Query("DELETE FROM openweather WHERE idRoom =:idRoom")
    void deleteOpenWeatherRequestByIdRoom(long idRoom);

    @Query("SELECT * FROM openweather")
    List<SimpleWeatherData> getAllOpenWeatherRequest();

    @Query("SELECT * FROM openweather WHERE idRoom=:idRoom")
    SimpleWeatherData getOpenWeatherRequestByIdRoom(long idRoom);

    @Query("SELECT COUNT() FROM openweather")
    long getCountOpenWeatherRequest();

    @Query("DELETE FROM openweather")
    public void deleteHistory();
}
