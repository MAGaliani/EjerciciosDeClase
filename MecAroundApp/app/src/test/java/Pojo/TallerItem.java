package Pojo;

/**
 * Created by magaliani on 12/02/18.
 */

public class TallerItem {

    private String foto;
    private String nombre;
    private String telefono;
    private String direccion;

    public TallerItem(String foto, String nombre, String telefono, String direccion) {
        this.foto = foto;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
