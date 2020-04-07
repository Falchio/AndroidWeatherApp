package ru.skillsnet.falchio.database;

import java.util.List;

import ru.skillsnet.falchio.roomdao.OpenWeatherDao;

public class OpenSimpleDataSource {
    private final OpenWeatherDao openWeatherDao;
    private List<SimpleWeatherData> simpleWeatherData;

    public OpenSimpleDataSource(OpenWeatherDao openWeatherDao){
        this.openWeatherDao = openWeatherDao;
    }

    public List<SimpleWeatherData> getAllSimpleWeatherData(){
        if (simpleWeatherData ==null){
            LoadSimpleWeatherData();
        }
        return simpleWeatherData;
    }

    public void LoadSimpleWeatherData(){
        simpleWeatherData = openWeatherDao.getAllOpenWeatherRequest();
    }

    public long getCountSimpleWeatherData(){
        return openWeatherDao.getCountOpenWeatherRequest();
    }

    public void addSimpleWeatherData(SimpleWeatherData simpleWeatherData){
        openWeatherDao.insertOpenWeatherRequest(simpleWeatherData);
        LoadSimpleWeatherData();
    }

    public void updateSimpleWeatherData(SimpleWeatherData simpleWeatherData){
        openWeatherDao.updateOpenWeatherRequest(simpleWeatherData);
        LoadSimpleWeatherData();
    }

    public void removeSimpleWeatherData(long id){
        openWeatherDao.deleteOpenWeatherRequestByIdRoom(id);
        LoadSimpleWeatherData();
    }

    public void deleteHistory(){
        openWeatherDao.deleteHistory();
        LoadSimpleWeatherData();
    }
}
