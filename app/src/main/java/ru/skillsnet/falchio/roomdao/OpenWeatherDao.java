package ru.skillsnet.falchio.roomdao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.skillsnet.falchio.openweathergson.OpenweatherRequest;
@Dao
public interface OpenWeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOpenWeatherRequest(OpenweatherRequest openweatherRequest);

    @Update
    void updateOpenWeatherRequest(OpenweatherRequest openweatherRequest);

    @Delete
    void deleteOpenWeatherRequest(OpenweatherRequest openweatherRequest);

    @Query("DELETE FROM openweather WHERE idRoom =:idRoom")
    void deleteOpenWeatherRequestByIdRoom(long idRoom);

    @Query("SELECT * FROM openweather")
    List<OpenweatherRequest> getAllOpenWeatherRequest();

    @Query("SELECT * FROM openweather WHERE idRoom=:idRoom")
    OpenweatherRequest getOpenWeatherRequestByIdRoom(long idRoom);

    @Query("SELECT COUNT() FROM openweather")
    long getCountOpenWeatherRequest();
}
