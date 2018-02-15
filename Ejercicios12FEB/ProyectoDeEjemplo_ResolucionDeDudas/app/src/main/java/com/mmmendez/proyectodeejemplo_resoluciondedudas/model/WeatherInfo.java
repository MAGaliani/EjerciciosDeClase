
package com.mmmendez.proyectodeejemplo_resoluciondedudas.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherInfo {

    @SerializedName("coord")
    @Expose
    private Coord coord;
    @SerializedName("weather")
    @Expose
    private List<Weather> weather = null;
    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("main")
    @Expose
    private Main main;
    @SerializedName("visibility")
    @Expose
    private Long visibility;
    @SerializedName("wind")
    @Expose
    private Wind wind;
    @SerializedName("clouds")
    @Expose
    private Clouds clouds;
    @SerializedName("dt")
    @Expose
    private Long dt;
    @SerializedName("sys")
    @Expose
    private Sys sys;
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cod")
    @Expose
    private Long cod;

    /**
     * No args constructor for use in serialization
     * 
     */
    public WeatherInfo() {
    }

    /**
     * 
     * @param id
     * @param dt
     * @param clouds
     * @param coord
     * @param wind
     * @param cod
     * @param visibility
     * @param sys
     * @param name
     * @param base
     * @param weather
     * @param main
     */
    public WeatherInfo(Coord coord, List<Weather> weather, String base, Main main, Long visibility, Wind wind, Clouds clouds, Long dt, Sys sys, Long id, String name, Long cod) {
        super();
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Long getVisibility() {
        return visibility;
    }

    public void setVisibility(Long visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeatherInfo)) return false;

        WeatherInfo that = (WeatherInfo) o;

        if (!getCoord().equals(that.getCoord())) return false;
        if (!getWeather().equals(that.getWeather())) return false;
        if (!getBase().equals(that.getBase())) return false;
        if (!getMain().equals(that.getMain())) return false;
        if (!getVisibility().equals(that.getVisibility())) return false;
        if (!getWind().equals(that.getWind())) return false;
        if (!getClouds().equals(that.getClouds())) return false;
        if (!getDt().equals(that.getDt())) return false;
        if (!getSys().equals(that.getSys())) return false;
        if (!getId().equals(that.getId())) return false;
        if (!getName().equals(that.getName())) return false;
        return getCod().equals(that.getCod());
    }

    @Override
    public int hashCode() {
        int result = getCoord().hashCode();
        result = 31 * result + getWeather().hashCode();
        result = 31 * result + getBase().hashCode();
        result = 31 * result + getMain().hashCode();
        result = 31 * result + getVisibility().hashCode();
        result = 31 * result + getWind().hashCode();
        result = 31 * result + getClouds().hashCode();
        result = 31 * result + getDt().hashCode();
        result = 31 * result + getSys().hashCode();
        result = 31 * result + getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getCod().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "WeatherInfo{" +
                "coord=" + coord +
                ", weather=" + weather +
                ", base='" + base + '\'' +
                ", main=" + main +
                ", visibility=" + visibility +
                ", wind=" + wind +
                ", clouds=" + clouds +
                ", dt=" + dt +
                ", sys=" + sys +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", cod=" + cod +
                '}';
    }
}
