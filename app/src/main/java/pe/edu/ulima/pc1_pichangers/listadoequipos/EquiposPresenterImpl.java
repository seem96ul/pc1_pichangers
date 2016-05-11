package pe.edu.ulima.pc1_pichangers.listadoequipos;

import android.util.Log;

import java.util.List;

import pe.edu.ulima.pc1_pichangers.beans.Equipo;
import pe.edu.ulima.pc1_pichangers.beans.Usuario;
import pe.edu.ulima.pc1_pichangers.remote.EquiposService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by w3228 on 11/05/2016.
 */
public class EquiposPresenterImpl implements EquiposPresenter{

    private ListadoEquipos mView;

    public EquiposPresenterImpl(ListadoEquipos view){
        mView = view;
    }

    @Override
    public void obtenerEquipos() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://pichangers-api.mybluemix.net/rest")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EquiposService service = retrofit.create(EquiposService.class);
        service.obtenerEquipos().enqueue(new Callback<List<Equipo>>() {
            @Override
            public void onResponse(Call<List<Equipo>> call, Response<List<Equipo>> response) {
                mView.mostrarListadoEquipos(response.body());
            }

            @Override
            public void onFailure(Call<List<Equipo>> call, Throwable t) {
                Log.e("Pichangers", t.getMessage());
            }

        });
    }
}
