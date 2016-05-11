package pe.edu.ulima.pc1_pichangers.listadoequipos;

import java.util.List;

import pe.edu.ulima.pc1_pichangers.beans.Equipo;

/**
 * Created by w3228 on 11/05/2016.
 */
public interface ListadoEquipos {

    public void setPresenter(EquiposPresenter presenter);
    public void mostrarListadoEquipos(List<Equipo> equipos);
}
