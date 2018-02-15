package com.magaliani.ejercicio15feb;

/**
 * Created by magaliani on 15/02/18.
 */

class Vuelo {

    private String company;
    private String horasalida;
    private String horallegada;
    private String precio;

    public Vuelo(String company, String horasalida, String horallegada, String precio) {
        this.company = company;
        this.horasalida = horasalida;
        this.horallegada = horallegada;
        this.precio = precio;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getHorasalida() {
        return horasalida;
    }

    public void setHorasalida(String horasalida) {
        this.horasalida = horasalida;
    }

    public String getHorallegada() {
        return horallegada;
    }

    public void setHorallegada(String horallegada) {
        this.horallegada = horallegada;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vuelo vuelo = (Vuelo) o;

        if (company != null ? !company.equals(vuelo.company) : vuelo.company != null) return false;
        if (horasalida != null ? !horasalida.equals(vuelo.horasalida) : vuelo.horasalida != null)
            return false;
        if (horallegada != null ? !horallegada.equals(vuelo.horallegada) : vuelo.horallegada != null)
            return false;
        return precio != null ? precio.equals(vuelo.precio) : vuelo.precio == null;
    }

    @Override
    public int hashCode() {
        int result = company != null ? company.hashCode() : 0;
        result = 31 * result + (horasalida != null ? horasalida.hashCode() : 0);
        result = 31 * result + (horallegada != null ? horallegada.hashCode() : 0);
        result = 31 * result + (precio != null ? precio.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "company='" + company + '\'' +
                ", horasalida='" + horasalida + '\'' +
                ", horallegada='" + horallegada + '\'' +
                ", precio='" + precio + '\'' +
                '}';
    }
}
