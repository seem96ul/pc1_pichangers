package pe.edu.ulima.pc1_pichangers.remote;

import java.util.List;

import pe.edu.ulima.pc1_pichangers.beans.Equipo;
import pe.edu.ulima.pc1_pichangers.beans.Usuario;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by w3228 on 11/05/2016.
 */
public interface EquiposService {

    @GET("/alumnos/login")
    Call<Usuario> obtenerUsuarios();

    @GET("/equipos")
    Call<List<Equipo>> obtenerEquipos();
}
