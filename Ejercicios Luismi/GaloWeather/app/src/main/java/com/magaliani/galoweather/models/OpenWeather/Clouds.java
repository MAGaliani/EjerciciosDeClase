
package com.magaliani.galoweather.models.OpenWeather;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Clouds implements Serializable, Parcelable
{

    @SerializedName("all")
    @Expose
    private long all;
    public final static Creator<Clouds> CREATOR = new Creator<Clouds>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Clouds createFromParcel(Parcel in) {
            return new Clouds(in);
        }

        public Clouds[] newArray(int size) {
            return (new Clouds[size]);
        }

    }
    ;
    private final static long serialVersionUID = -5429465913065030706L;

    protected Clouds(Parcel in) {
        this.all = ((long) in.readValue((long.class.getClassLoader())));
    }

    public Clouds() {
    }

    public Clouds(long all) {
        this.all = all;
    }

    public long getAll() {
        return all;
    }

    public void setAll(long all) {
        this.all = all;
    }

    public static Creator<Clouds> getCREATOR() {
        return CREATOR;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clouds clouds = (Clouds) o;

        return all == clouds.all;
    }

    @Override
    public int hashCode() {
        return (int) (all ^ (all >>> 32));
    }

    @Override
    public String toString() {
        return "Clouds{" +
                "all=" + all +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
