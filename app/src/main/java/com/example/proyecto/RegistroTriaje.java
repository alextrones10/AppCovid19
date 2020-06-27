package com.example.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.proyecto.entidad.Triaje;
import com.example.proyecto.servicio.ServicioRest2;
import com.example.proyecto.util.ConnectionRest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroTriaje extends AppCompatActivity {

    int cantInfectados = 14;
    int cantNoInfectados = 6;
    int totalRegistro = 20;

    int iLima = 7;
    int iAmazonas = 1;
    int iAncash = 0;
    int iSanMartin = 0;
    int iIca = 1;
    int iHuancavelica = 0;
    int iPiura = 4;
    int iTacna = 0;
    int iCusco = 1;

    ServicioRest2 servicio;

    Button btnAceptarT,btnCancelarT;

    EditText edtDepartamento,edtProvincia,edtDistrito,edtDireccion,edtUbigeo,edtOtros, edtSituacion;
    CheckBox cbDifRespirar, cbFiebre,cbTosSeca, cbCansancio,  cbDolorGarganta,cbMalestares;
    int numSintomas;
    String estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_triaje);



        setTitle("Triaje");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        edtDepartamento = (EditText) findViewById(R.id.edtDepartamento);
        edtProvincia = (EditText) findViewById(R.id.edtProvincia);
        edtDistrito = (EditText) findViewById(R.id.edtDistrito);
        edtDireccion = (EditText) findViewById(R.id.edtDireccion);
        edtUbigeo = (EditText) findViewById(R.id.edtUbigeo);
        cbDifRespirar = (CheckBox) findViewById(R.id.cbDifRespirar);
        cbFiebre = (CheckBox) findViewById(R.id.cbFiebre);
        cbTosSeca = (CheckBox) findViewById(R.id.cbTosSeca);
        cbCansancio = (CheckBox) findViewById(R.id.cbCansancio);
        cbDolorGarganta = (CheckBox) findViewById(R.id.cbDolorGarganta);
        cbMalestares = (CheckBox) findViewById(R.id.cbMalestares);
        edtOtros = (EditText) findViewById(R.id.edtOtros);
        edtSituacion = (EditText) findViewById(R.id.edtSituacion);


        btnAceptarT = (Button) findViewById(R.id.btnAceptarT);

        servicio = ConnectionRest.getConnection().create(ServicioRest2.class);

        Bundle extras = getIntent().getExtras();
        final String codigo = extras.getString("codigo");

        btnAceptarT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Triaje t = new Triaje();
                t.setDepartamento(edtDepartamento.getText().toString());
                t.setProvincia(edtProvincia.getText().toString());
                t.setDistrito(edtDistrito.getText().toString());
                t.setDireccion(edtDireccion.getText().toString());
                t.setUbigeo(Integer.parseInt(edtUbigeo.getText().toString()));

                if (cbDifRespirar.isChecked()) {
                    t.setDificultadRespirar("si");
                    numSintomas = numSintomas + 1;
                }else {
                    t.setDificultadRespirar("no");
                }

                if (cbDifRespirar.isChecked()) {
                    t.setFiebre("si");
                    numSintomas = numSintomas + 1;
                }else {
                    t.setFiebre("no");
                }

                if (cbTosSeca.isChecked()) {
                    t.setTos("si");
                    numSintomas = numSintomas + 1;
                }else {
                    t.setTos("no");
                }

                if (cbCansancio.isChecked()) {
                    t.setCansancio("si");
                    numSintomas = numSintomas + 1;
                }else {
                    t.setCansancio("no");
                }

                if (cbDolorGarganta.isChecked()) {
                    t.setDolorGarganta("si");
                    numSintomas = numSintomas + 1;
                }else {
                    t.setDolorGarganta("no");
                }

                if (cbMalestares.isChecked()) {
                    t.setMalestarGeneral("si");
                    numSintomas = numSintomas + 1;
                }else {
                    t.setMalestarGeneral("no");
                }

                t.setOtros(edtOtros.getText().toString());
                t.setSituacionEconomica(edtSituacion.getText().toString());

                if(numSintomas>=3) {
                    estado = "Infectado";
                    cantInfectados = cantInfectados + 1;
                }else {
                    estado = "No Infectado";
                    cantNoInfectados = cantNoInfectados + 1;
                }
                t.setEstado(estado);
                t.setUserId(Integer.parseInt(codigoUsuario()));


                //Contadores
                totalRegistro = totalRegistro + 1;
                switch (edtDepartamento.getText().toString()) {
                    case "Lima":
                            if(estado=="Infectado") {
                                iLima = iLima + 1;
                            }
                    case "Amazonas":
                        if(estado=="Infectado") {
                            iAmazonas = iAmazonas + 1;
                        }
                    case "Ancash":
                        if(estado=="Infectado") {
                            iAncash = iAncash + 1;
                        }
                    case "San Martin":
                        if(estado=="Infectado") {
                            iSanMartin = iSanMartin + 1;
                        }
                    case "Ica":
                        if(estado=="Infectado") {
                            iIca = iIca + 1;
                        }
                    case "Huancavelica":
                        if(estado=="Infectado") {
                            iHuancavelica = iHuancavelica + 1;
                        }
                    case "Piura":
                        if(estado=="Infectado") {
                            iPiura = iPiura + 1;
                        }
                    case "Tacna":
                        if(estado=="Infectado") {
                            iTacna = iTacna + 1;
                        }
                    case "Cusco":
                        if(estado=="Infectado") {
                            iCusco = iCusco + 1;
                        }
                }
                addTriaje(t);
                Intent intent = new Intent(RegistroTriaje.this, Menu.class);
                intent.putExtra("cantInfectados",cantInfectados);
                intent.putExtra("cantNoInfectados",cantNoInfectados);
                intent.putExtra("totalRegistro",totalRegistro);
                intent.putExtra("iLima",iLima);
                intent.putExtra("iAmazonas",iAmazonas);
                intent.putExtra("iAncash",iAncash);
                intent.putExtra("iSanMartin",iSanMartin);
                intent.putExtra("iIca",iIca);
                intent.putExtra("iHuancavelica",iHuancavelica);
                intent.putExtra("iPiura",iPiura);
                intent.putExtra("iTacna",iTacna);
                intent.putExtra("iCusco",iCusco);
                startActivity(intent);

                //Intent i = new Intent(RegistroTriaje.this, Menu.class);



            }
        });
        btnCancelarT = (Button) findViewById(R.id.btnAtrasT);

        btnCancelarT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistroTriaje.this, Menu.class));
            }
        });
    }

    public void addTriaje(Triaje t){
        Call<Triaje> call = servicio.agregaTriaje(t);
        call.enqueue(new Callback<Triaje>() {
            @Override
            public void onResponse(Call<Triaje> call, Response<Triaje> response) {
                mensaje("-->" + response.isSuccessful());
                if(response.isSuccessful()){
                    Toast.makeText(RegistroTriaje.this, "Registro exitoso!", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Triaje> call, Throwable t) {
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

    public String codigoUsuario() {
        Bundle extras = getIntent().getExtras();
        final String codigo = extras.getString("codigo");
        return codigo;
    }

}
