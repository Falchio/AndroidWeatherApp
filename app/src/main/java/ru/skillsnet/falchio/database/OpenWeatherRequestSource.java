package ru.skillsnet.falchio.database;

import java.util.List;

import ru.skillsnet.falchio.openweathergson.OpenweatherRequest;
import ru.skillsnet.falchio.roomdao.OpenWeatherDao;

public class OpenWeatherRequestSource {
    private final OpenWeatherDao openWeatherDao;
    private List<OpenweatherRequest> opRequest;

    public OpenWeatherRequestSource(OpenWeatherDao openWeatherDao){
        this.openWeatherDao = openWeatherDao;
    }

    public List<OpenweatherRequest> getOpRequest(){
        if (opRequest==null){
            LoadOpenWeatherRequest();
        }
        return opRequest;
    }

    public void LoadOpenWeatherRequest(){
        opRequest = openWeatherDao.getAllOpenWeatherRequest();
    }

    public long getCountOpenWeatherRequest(){
        return openWeatherDao.getCountOpenWeatherRequest();
    }

    public void addOpenWeatherRequest(OpenweatherRequest openweatherRequest){
        openWeatherDao.insertOpenWeatherRequest(openweatherRequest);
    }

    public void updateOpenWeatherRequest(OpenweatherRequest openweatherRequest){
        openWeatherDao.updateOpenWeatherRequest(openweatherRequest);
    }

    public void removeOpenWeatherRequest(long id){
        openWeatherDao.deleteOpenWeatherRequestByIdRoom(id);
        LoadOpenWeatherRequest();
    }
}
