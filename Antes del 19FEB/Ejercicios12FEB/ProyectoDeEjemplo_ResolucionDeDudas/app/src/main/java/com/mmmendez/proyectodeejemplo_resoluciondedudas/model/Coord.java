
package com.mmmendez.proyectodeejemplo_resoluciondedudas.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Coord implements Serializable
{

    @SerializedName("lat")
    @Expose
    private float lat;
    @SerializedName("lon")
    @Expose
    private float lon;
    private final static long serialVersionUID = -836121673452175160L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Coord() {
    }

    /**
     * 
     * @param lon
     * @param lat
     */
    public Coord(float lat, float lon) {
        super();
        this.lat = lat;
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coord)) return false;

        Coord coord = (Coord) o;

        if (Float.compare(coord.getLat(), getLat()) != 0) return false;
        return Float.compare(coord.getLon(), getLon()) == 0;
    }

    @Override
    public int hashCode() {
        int result = (getLat() != +0.0f ? Float.floatToIntBits(getLat()) : 0);
        result = 31 * result + (getLon() != +0.0f ? Float.floatToIntBits(getLon()) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Coord{" +
                "lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
