package pe.edu.ulima.pc1_pichangers.beans;

/**
 * Created by w3228 on 11/05/2016.
 */
public class Equipo {

    private int id;
    private String nombre;
    private String urlImagen;

    public Equipo() {
    }

    public Equipo(int id, String urlImagen, String nombre) {
        this.id = id;
        this.urlImagen = urlImagen;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}
