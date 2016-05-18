package pe.edu.ulima.pc1_pichangers.remote;

import java.util.List;

import pe.edu.ulima.pc1_pichangers.beans.Alumno;
import pe.edu.ulima.pc1_pichangers.beans.Equipo;
import pe.edu.ulima.pc1_pichangers.beans.Usuario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by w3228 on 11/05/2016.
 */
public interface EquiposService {

    @POST("/alumnos/login")
    Call<Usuario> crearUsuario(@Body Usuario usuario);

    @GET("/equipos")
    Call<List<Equipo>> obtenerEquipos();

    @GET("/alumnos?sin_equipo={flag_equipo}")
    Call<List<Alumno>> obtenerAlumnossinEquipo();

    @GET("/equipos/{id}")
    Call<Equipo> obtenerInfoEquipo();

    @POST("/equipos/{id}/{codigo_alumno}")
    Call<Alumno> agregarAlumno(@Body Alumno alumno);

}
