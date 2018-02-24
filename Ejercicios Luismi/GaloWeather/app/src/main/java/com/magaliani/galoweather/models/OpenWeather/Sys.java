
package com.magaliani.galoweather.models.OpenWeather;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Sys implements Serializable, Parcelable
{

    @SerializedName("type")
    @Expose
    private long type;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("message")
    @Expose
    private double message;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("sunrise")
    @Expose
    private double sunrise;
    @SerializedName("sunset")
    @Expose
    private double sunset;
    public final static Creator<Sys> CREATOR = new Creator<Sys>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Sys createFromParcel(Parcel in) {
            return new Sys(in);
        }

        public Sys[] newArray(int size) {
            return (new Sys[size]);
        }

    }
    ;
    private final static long serialVersionUID = -115037065550040417L;

    protected Sys(Parcel in) {
        this.type = ((long) in.readValue((long.class.getClassLoader())));
        this.id = ((long) in.readValue((long.class.getClassLoader())));
        this.message = ((double) in.readValue((double.class.getClassLoader())));
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        this.sunrise = ((long) in.readValue((long.class.getClassLoader())));
        this.sunset = ((long) in.readValue((long.class.getClassLoader())));
    }

    public Sys() {
    }

    public Sys(long type, long id, double message, String country, long sunrise, long sunset) {
        this.type = type;
        this.id = id;
        this.message = message;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public double getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

    public static Creator<Sys> getCREATOR() {
        return CREATOR;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sys sys = (Sys) o;

        if (type != sys.type) return false;
        if (id != sys.id) return false;
        if (Double.compare(sys.message, message) != 0) return false;
        if (Double.compare(sys.sunrise, sunrise) != 0) return false;
        if (Double.compare(sys.sunset, sunset) != 0) return false;
        return country != null ? country.equals(sys.country) : sys.country == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (type ^ (type >>> 32));
        result = 31 * result + (int) (id ^ (id >>> 32));
        temp = Double.doubleToLongBits(message);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (country != null ? country.hashCode() : 0);
        temp = Double.doubleToLongBits(sunrise);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sunset);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Sys{" +
                "type=" + type +
                ", id=" + id +
                ", message=" + message +
                ", country='" + country + '\'' +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                '}';
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
        dest.writeValue(id);
        dest.writeValue(message);
        dest.writeValue(country);
        dest.writeValue(sunrise);
        dest.writeValue(sunset);
    }

    public int describeContents() {
        return  0;
    }

}
