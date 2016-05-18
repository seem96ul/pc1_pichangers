package pe.edu.ulima.pc1_pichangers.listadoequipos;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.List;

import pe.edu.ulima.pc1_pichangers.AgregarActivity;
import pe.edu.ulima.pc1_pichangers.InfoActivity;
import pe.edu.ulima.pc1_pichangers.R;
import pe.edu.ulima.pc1_pichangers.adapters.ListadoEquiposAdapter;
import pe.edu.ulima.pc1_pichangers.beans.Equipo;

public class EquiposActivity extends AppCompatActivity implements ListadoEquipos {

    EquiposPresenter mPresenter;
    EquiposPresenter presenter;
    ListView lviEquipos;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipos);


        lviEquipos = (ListView) findViewById(R.id.lviEquipos);

        setPresenter(new EquiposPresenterImpl(this));
        Log.i("mensaje","12+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++3");
        mPresenter.obtenerEquipos();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }

    @Override
    public void setPresenter(EquiposPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void mostrarListadoEquipos(List<Equipo> equipos) {
        ListadoEquiposAdapter adapter = new ListadoEquiposAdapter(this, equipos);

        lviEquipos.setAdapter(adapter);
    }

    public void agregarClicked(View view) {
        Intent intent = new Intent(this, AgregarActivity.class);
    }

    public void mostrarInfoClicked(View view) {

        Intent intent = new Intent(this, InfoActivity.class);

;
    }
}
