package ru.skillsnet.falchio.openweathergson;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings({"ALL", "unused"})
public class Wind {
    @SerializedName("speed")
    private double speed;

    @SerializedName("deg")
    private double deg;

    @SuppressWarnings("unused")
    public double getSpeed() {
        return speed;
    }

    @SuppressWarnings("unused")
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @SuppressWarnings("unused")
    public double getDeg() {
        return deg;
    }

    @SuppressWarnings("unused")
    public void setDeg(double deg) {
        this.deg = deg;
    }
}
