package pe.edu.ulima.pc1_pichangers.listadoequipos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import pe.edu.ulima.pc1_pichangers.R;
import pe.edu.ulima.pc1_pichangers.beans.Equipo;

public class EquiposActivity extends AppCompatActivity  implements ListadoEquipos{

    EquiposPresenter mPresenter;

    ListView lviEquipos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipos);


        lviEquipos = (ListView) findViewById(R.id.lviEquipos);

        setPresenter(new EquiposPresenterImpl(this));

        mPresenter.obtenerEquipos();
    }

    @Override
    public void setPresenter(EquiposPresenter presenter) {

    }

    @Override
    public void mostrarListadoEquipos(List<Equipo> equipos) {

    }
}
