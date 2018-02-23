
package com.magaliani.galoweather.models.OpenWeather;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Main implements Serializable, Parcelable
{

    @SerializedName("temp")
    @Expose
    private double temp;
    @SerializedName("pressure")
    @Expose
    private long pressure;
    @SerializedName("humidity")
    @Expose
    private long humidity;
    @SerializedName("temp_min")
    @Expose
    private double tempMin;
    @SerializedName("temp_max")
    @Expose
    private double tempMax;
    public final static Creator<Main> CREATOR = new Creator<Main>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Main createFromParcel(Parcel in) {
            return new Main(in);
        }

        public Main[] newArray(int size) {
            return (new Main[size]);
        }

    }
    ;
    private final static long serialVersionUID = -5324229832325262617L;

    protected Main(Parcel in) {
        this.temp = ((double) in.readValue((double.class.getClassLoader())));
        this.pressure = ((long) in.readValue((long.class.getClassLoader())));
        this.humidity = ((long) in.readValue((long.class.getClassLoader())));
        this.tempMin = ((double) in.readValue((double.class.getClassLoader())));
        this.tempMax = ((double) in.readValue((double.class.getClassLoader())));
    }

    public Main() {
    }

    public Main(double temp, long pressure, long humidity, double tempMin, double tempMax) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public long getPressure() {
        return pressure;
    }

    public void setPressure(long pressure) {
        this.pressure = pressure;
    }

    public long getHumidity() {
        return humidity;
    }

    public void setHumidity(long humidity) {
        this.humidity = humidity;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Main main = (Main) o;

        if (Double.compare(main.temp, temp) != 0) return false;
        if (pressure != main.pressure) return false;
        if (humidity != main.humidity) return false;
        if (Double.compare(main.tempMin, tempMin) != 0) return false;
        return Double.compare(main.tempMax, tempMax) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp1;
        temp1 = Double.doubleToLongBits(temp);
        result = (int) (temp1 ^ (temp1 >>> 32));
        result = 31 * result + (int) (pressure ^ (pressure >>> 32));
        result = 31 * result + (int) (humidity ^ (humidity >>> 32));
        temp1 = Double.doubleToLongBits(tempMin);
        result = 31 * result + (int) (temp1 ^ (temp1 >>> 32));
        temp1 = Double.doubleToLongBits(tempMax);
        result = 31 * result + (int) (temp1 ^ (temp1 >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Main{" +
                "temp=" + temp +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", tempMin=" + tempMin +
                ", tempMax=" + tempMax +
                '}';
    }

    public static Creator<Main> getCREATOR() {
        return CREATOR;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(temp);
        dest.writeValue(pressure);
        dest.writeValue(humidity);
        dest.writeValue(tempMin);
        dest.writeValue(tempMax);
    }

    public int describeContents() {
        return  0;
    }

}
