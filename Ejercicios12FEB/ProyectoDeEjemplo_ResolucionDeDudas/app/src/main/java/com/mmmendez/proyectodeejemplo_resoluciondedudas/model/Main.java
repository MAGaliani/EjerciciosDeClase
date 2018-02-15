
package com.mmmendez.proyectodeejemplo_resoluciondedudas.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Main implements Serializable
{

    @SerializedName("temp")
    @Expose
    private Double temp;
    @SerializedName("temp_min")
    @Expose
    private Double tempMin;
    @SerializedName("temp_max")
    @Expose
    private Double tempMax;
    @SerializedName("pressure")
    @Expose
    private Double pressure;
    @SerializedName("sea_level")
    @Expose
    private Double seaLevel;
    @SerializedName("grnd_level")
    @Expose
    private Double grndLevel;
    @SerializedName("humidity")
    @Expose
    private Long humidity;
    @SerializedName("temp_kf")
    @Expose
    private Double tempKf;
    private final static long serialVersionUID = 5782250852467373595L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Main() {
    }

    /**
     * 
     * @param seaLevel
     * @param humidity
     * @param pressure
     * @param grndLevel
     * @param tempMax
     * @param temp
     * @param tempKf
     * @param tempMin
     */
    public Main(Double temp, Double tempMin, Double tempMax, Double pressure, Double seaLevel, Double grndLevel, Long humidity, Double tempKf) {
        super();
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.pressure = pressure;
        this.seaLevel = seaLevel;
        this.grndLevel = grndLevel;
        this.humidity = humidity;
        this.tempKf = tempKf;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(Double seaLevel) {
        this.seaLevel = seaLevel;
    }

    public Double getGrndLevel() {
        return grndLevel;
    }

    public void setGrndLevel(Double grndLevel) {
        this.grndLevel = grndLevel;
    }

    public Long getHumidity() {
        return humidity;
    }

    public void setHumidity(Long humidity) {
        this.humidity = humidity;
    }

    public Double getTempKf() {
        return tempKf;
    }

    public void setTempKf(Double tempKf) {
        this.tempKf = tempKf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Main)) return false;

        Main main = (Main) o;

        if (getTemp() != null ? !getTemp().equals(main.getTemp()) : main.getTemp() != null)
            return false;
        if (getTempMin() != null ? !getTempMin().equals(main.getTempMin()) : main.getTempMin() != null)
            return false;
        if (getTempMax() != null ? !getTempMax().equals(main.getTempMax()) : main.getTempMax() != null)
            return false;
        if (getPressure() != null ? !getPressure().equals(main.getPressure()) : main.getPressure() != null)
            return false;
        if (getSeaLevel() != null ? !getSeaLevel().equals(main.getSeaLevel()) : main.getSeaLevel() != null)
            return false;
        if (getGrndLevel() != null ? !getGrndLevel().equals(main.getGrndLevel()) : main.getGrndLevel() != null)
            return false;
        if (getHumidity() != null ? !getHumidity().equals(main.getHumidity()) : main.getHumidity() != null)
            return false;
        return getTempKf() != null ? getTempKf().equals(main.getTempKf()) : main.getTempKf() == null;
    }

    @Override
    public int hashCode() {
        int result = getTemp() != null ? getTemp().hashCode() : 0;
        result = 31 * result + (getTempMin() != null ? getTempMin().hashCode() : 0);
        result = 31 * result + (getTempMax() != null ? getTempMax().hashCode() : 0);
        result = 31 * result + (getPressure() != null ? getPressure().hashCode() : 0);
        result = 31 * result + (getSeaLevel() != null ? getSeaLevel().hashCode() : 0);
        result = 31 * result + (getGrndLevel() != null ? getGrndLevel().hashCode() : 0);
        result = 31 * result + (getHumidity() != null ? getHumidity().hashCode() : 0);
        result = 31 * result + (getTempKf() != null ? getTempKf().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Main{" +
                "temp=" + temp +
                ", tempMin=" + tempMin +
                ", tempMax=" + tempMax +
                ", pressure=" + pressure +
                ", seaLevel=" + seaLevel +
                ", grndLevel=" + grndLevel +
                ", humidity=" + humidity +
                ", tempKf=" + tempKf +
                '}';
    }
}
