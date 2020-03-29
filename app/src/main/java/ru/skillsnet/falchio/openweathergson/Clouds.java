package ru.skillsnet.falchio.openweathergson;

import com.google.gson.annotations.SerializedName;

public class Clouds {

    @SerializedName("all")
    private int allClouds;

    public int getAllClouds() {
        return allClouds;
    }

    public void setAllClouds(int allClouds) {
        this.allClouds = allClouds;
    }
}
