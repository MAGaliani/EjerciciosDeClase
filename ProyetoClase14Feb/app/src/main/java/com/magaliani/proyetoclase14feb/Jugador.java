package com.magaliani.proyetoclase14feb;

/**
 * Created by magaliani on 14/02/18.
 */

class Jugador {

    private String nombre;
    private String dorsal;
    private String edad;
    private String foto;

    public Jugador(String nombre, String dorsal, String edad, String foto) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.edad = edad;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDorsal() {
        return dorsal;
    }

    public void setDorsal(String dorsal) {
        this.dorsal = dorsal;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jugador jugador = (Jugador) o;

        if (nombre != null ? !nombre.equals(jugador.nombre) : jugador.nombre != null) return false;
        if (dorsal != null ? !dorsal.equals(jugador.dorsal) : jugador.dorsal != null) return false;
        if (edad != null ? !edad.equals(jugador.edad) : jugador.edad != null) return false;
        return foto != null ? foto.equals(jugador.foto) : jugador.foto == null;
    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        result = 31 * result + (dorsal != null ? dorsal.hashCode() : 0);
        result = 31 * result + (edad != null ? edad.hashCode() : 0);
        result = 31 * result + (foto != null ? foto.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", dorsal='" + dorsal + '\'' +
                ", edad='" + edad + '\'' +
                ", foto='" + foto + '\'' +
                '}';
    }
}
