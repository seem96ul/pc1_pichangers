package pe.edu.ulima.pc1_pichangers.beans;

/**
 * Created by w3119 on 13/05/2016.
 */
public class Alumno {

    private int codigo;
    private Equipo equipo;
    private int id;
    private String nombre;

    public Alumno() {

    }

    public Alumno(String nombre, int id, Equipo equipo, int codigo) {
        this.nombre = nombre;
        this.id = id;
        this.equipo = equipo;
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
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
}
