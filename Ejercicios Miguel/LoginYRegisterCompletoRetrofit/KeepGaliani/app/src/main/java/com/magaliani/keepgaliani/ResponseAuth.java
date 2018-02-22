package com.magaliani.keepgaliani;

/**
 * Created by GaloMcTunki on 21/02/2018.
 */

class ResponseAuth {

    private String key;
    private String nombre;
    private String email;
    private String mensaje;

    public ResponseAuth() {
    }

    public ResponseAuth(String key, String nombre, String email, String mensaje) {
        this.key = key;
        this.nombre = nombre;
        this.email = email;
        this.mensaje = mensaje;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResponseAuth that = (ResponseAuth) o;

        if (key != null ? !key.equals(that.key) : that.key != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        return mensaje != null ? mensaje.equals(that.mensaje) : that.mensaje == null;
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (mensaje != null ? mensaje.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ResponseAuth{" +
                "key='" + key + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }
}
