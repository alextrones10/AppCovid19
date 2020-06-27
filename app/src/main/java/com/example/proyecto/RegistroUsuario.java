package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.proyecto.entidad.Triaje;
import com.example.proyecto.entidad.Usuario;
import com.example.proyecto.servicio.ServicioRest;
import com.example.proyecto.util.ConnectionRest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroUsuario extends AppCompatActivity {

    //Objetos
    ServicioRest servicio;
    Button btnAceptarU;
    EditText edtNumeroDoc,edtContraseña, edtCelular, edtCorreo;
    Spinner spTipoDocumento, spNacionalidad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        setTitle("Usuario");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Vinculación de los objetos a los controles en el Layout
        //Spinner
        spTipoDocumento = (Spinner) findViewById(R.id.spTipoDocumento);
        String [] TipoDocumento = new String[] {"DNI","CE"};
        ArrayAdapter<String> adTipo = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,TipoDocumento);
        spTipoDocumento.setAdapter(adTipo);

        //Spinner02
        spNacionalidad = (Spinner) findViewById(R.id.spNacionalidad);
        String [] Nacionalidad = new String[] {"Peruano","Venezolano","Boliviano","Argentino","Ecuatoriano"};
        ArrayAdapter<String> adNacionalidad = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Nacionalidad);
        spNacionalidad.setAdapter(adNacionalidad);


        edtNumeroDoc = (EditText)findViewById(R.id.edtNumeroDoc);
        edtContraseña = (EditText)findViewById(R.id.edtContraseña);
        edtCelular = (EditText)findViewById(R.id.edtCelular);
        edtCorreo = (EditText)findViewById(R.id.edtCorreo);

        btnAceptarU = (Button) findViewById(R.id.btnAceptarU);

        servicio = ConnectionRest.getConnection().create(ServicioRest.class);

        btnAceptarU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validar()) {
                    Usuario u = new Usuario();

                    u.setIdUsuario(Integer.parseInt(edtNumeroDoc.getText().toString()));
                    u.setContraseña(edtContraseña.getText().toString());
                    u.setTipodoc(spTipoDocumento.getSelectedItem().toString());
                    u.setNacionalidad(spNacionalidad.getSelectedItem().toString());
                    u.setCelular(edtCelular.getText().toString());
                    u.setCorreo(edtCorreo.getText().toString());

                    final String codigoUsuario = edtNumeroDoc.getText().toString();

                    addUser(u);
                    Intent intent = new Intent(RegistroUsuario.this, Menu.class);
                    intent.putExtra("codigo",codigoUsuario);
                    startActivity(intent);
                }
            }
        });

    }

    public void addUser(Usuario u){
        Call<Usuario> call = servicio.agregaUsuario(u);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                mensaje("-->" + response.isSuccessful());
                if(response.isSuccessful()){
                    Toast.makeText(RegistroUsuario.this, "Registro exitoso!", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    void mensaje(String mensaje){
        Toast toast1 =  Toast.makeText(getApplicationContext(),mensaje, Toast.LENGTH_LONG);
        toast1.show();
    }

    public boolean validar() {

        boolean var = true;

        String id = edtNumeroDoc.getText().toString();
        String contraseña = edtContraseña.getText().toString();
        String cel = edtCelular.getText().toString();
        String email = edtCorreo.getText().toString();

        if(id.isEmpty()) {
            edtNumeroDoc.setError("Numero de Documento Obligatorio");
            var = false;
        }
        if(contraseña.isEmpty()) {
            edtContraseña.setError("Campo  Obligatorio");
            var = false;
        }
        if(cel.isEmpty()) {
            edtCelular.setError("Campo Obligatorio");
            var = false;
        }
        if(email.isEmpty()) {
            edtCorreo.setError("Campo Obligatorio");
            var = false;
        }
        return var;
    }



}
