package com.magaliani.fragmentlist13feb;

/**
 * Created by magaliani on 13/02/18.
 */

public class Restaurante {

    private String nombre;
    private int rate;
    private String urlfoto;
    private String adress;

    public Restaurante(String nombre, int rate, String urlfoto, String adress) {
        this.nombre = nombre;
        this.rate = rate;
        this.urlfoto = urlfoto;
        this.adress = adress;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getUrlfoto() {
        return urlfoto;
    }

    public void setUrlfoto(String urlfoto) {
        this.urlfoto = urlfoto;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Restaurante that = (Restaurante) o;

        if (rate != that.rate) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (urlfoto != null ? !urlfoto.equals(that.urlfoto) : that.urlfoto != null) return false;
        return adress != null ? adress.equals(that.adress) : that.adress == null;
    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        result = 31 * result + rate;
        result = 31 * result + (urlfoto != null ? urlfoto.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        return result;
    }
}
