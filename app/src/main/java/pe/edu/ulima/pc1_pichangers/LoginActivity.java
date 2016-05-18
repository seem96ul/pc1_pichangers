package pe.edu.ulima.pc1_pichangers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import pe.edu.ulima.pc1_pichangers.beans.Usuario;
import pe.edu.ulima.pc1_pichangers.listadoequipos.EquiposActivity;
import pe.edu.ulima.pc1_pichangers.remote.EquiposService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    EditText eteUsuario, etePassword;
    Usuario usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        eteUsuario = (EditText) findViewById(R.id.eteUsuario);
        etePassword = (EditText) findViewById(R.id.etePassword);
    }

    public void crearUsuario(Usuario usuario){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://pichangers-api.mybluemix.net/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EquiposService service = retrofit.create(EquiposService.class);
        service.crearUsuario(usuario).enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Context context = getApplicationContext();
                CharSequence text = response.body().toString();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Log.e("Pichangers", t.getMessage());
            }
        });
    }

    public void onLoginClicked(View view){
        String username = eteUsuario.getText().toString();
        String password = etePassword.getText().toString();


        if (username.equals("20142424") &&
                password.equals("123")){

            Usuario usuario = new Usuario(username, password);
            Intent intent = new Intent(this, EquiposActivity.class);
            intent.putExtra(usuario.getUsuario(), username);
            intent.putExtra(usuario.getUsuario(), "20142424");

            startActivity(intent);
            crearUsuario(usuario);
        }else{
            Context context = getApplicationContext();
            CharSequence text = "Login incorrecto";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }


    }
}
