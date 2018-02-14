
package com.magaliani.restartingretrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wind {

    @SerializedName("speed")
    @Expose
    private Long speed;
    @SerializedName("deg")
    @Expose
    private Long deg;

    public Wind(Long speed, Long deg) {
        this.speed = speed;
        this.deg = deg;
    }

    public Long getSpeed() {
        return speed;
    }

    public void setSpeed(Long speed) {
        this.speed = speed;
    }

    public Long getDeg() {
        return deg;
    }

    public void setDeg(Long deg) {
        this.deg = deg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wind wind = (Wind) o;

        if (speed != null ? !speed.equals(wind.speed) : wind.speed != null) return false;
        return deg != null ? deg.equals(wind.deg) : wind.deg == null;
    }

    @Override
    public int hashCode() {
        int result = speed != null ? speed.hashCode() : 0;
        result = 31 * result + (deg != null ? deg.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Wind{" +
                "speed=" + speed +
                ", deg=" + deg +
                '}';
    }
}
