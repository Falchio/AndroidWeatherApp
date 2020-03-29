package ru.skillsnet.falchio.data;

public class DataWeather {

    private DLocation DLocation;
    private DTime DTime;
    private Temperature temperature;
    private MyClouds myClouds;
    private MyWeather myWeather;
    private MyWind myWind;


    public DataWeather(DLocation DLocation, DTime DTime, Temperature temperature, MyClouds myClouds, MyWeather myWeather, MyWind myWind) {
        this.DLocation = DLocation;
        this.DTime = DTime;
        this.temperature = temperature;
        this.myClouds = myClouds;
        this.myWeather = myWeather;
        this.myWind = myWind;
    }

    public DataWeather(){
        this.DLocation = new DLocation();
        this.DTime = new DTime();
        this.temperature = new Temperature();
        this.myClouds = new MyClouds();
        this.myWeather = new MyWeather();
        this.myWind = new MyWind();
    }

    public DLocation getDLocation() {
        return DLocation;
    }

    public DTime getDTime() {
        return DTime;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public MyClouds getMyClouds() {
        return myClouds;
    }

    public MyWeather getMyWeather() {
        return myWeather;
    }

    public MyWind getMyWind() {
        return myWind;
    }


}
