
package com.mmmendez.proyectodeejemplo_resoluciondedudas.model;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ForecastInfo implements Serializable
{

    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("cnt")
    @Expose
    private Long cnt;
    @SerializedName("weatherList")
    @Expose
    private List<WeatherList> weatherList = null;
    @SerializedName("city")
    @Expose
    private City city;
    private final static long serialVersionUID = -2478488625717747879L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ForecastInfo() {
    }

    /**
     * 
     * @param message
     * @param cnt
     * @param cod
     * @param weatherList
     * @param city
     */
    public ForecastInfo(String cod, String message, Long cnt, List<WeatherList> weatherList, City city) {
        super();
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.weatherList = weatherList;
        this.city = city;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getCnt() {
        return cnt;
    }

    public void setCnt(Long cnt) {
        this.cnt = cnt;
    }

    public java.util.List<WeatherList> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(java.util.List<WeatherList> weatherList) {
        this.weatherList = weatherList;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ForecastInfo)) return false;

        ForecastInfo that = (ForecastInfo) o;

        if (getCod() != null ? !getCod().equals(that.getCod()) : that.getCod() != null)
            return false;
        if (getMessage() != null ? !getMessage().equals(that.getMessage()) : that.getMessage() != null)
            return false;
        if (getCnt() != null ? !getCnt().equals(that.getCnt()) : that.getCnt() != null)
            return false;
        if (getWeatherList() != null ? !getWeatherList().equals(that.getWeatherList()) : that.getWeatherList() != null)
            return false;
        return getCity() != null ? getCity().equals(that.getCity()) : that.getCity() == null;
    }

    @Override
    public int hashCode() {
        int result = getCod() != null ? getCod().hashCode() : 0;
        result = 31 * result + (getMessage() != null ? getMessage().hashCode() : 0);
        result = 31 * result + (getCnt() != null ? getCnt().hashCode() : 0);
        result = 31 * result + (getWeatherList() != null ? getWeatherList().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ForecastInfo{" +
                "cod='" + cod + '\'' +
                ", message=" + message +
                ", cnt=" + cnt +
                ", weatherList=" + weatherList +
                ", city=" + city +
                '}';
    }
}
