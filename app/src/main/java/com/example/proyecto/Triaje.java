package com.example.proyecto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Triaje extends AppCompatActivity {

    Button btnAlertaT,btnCancelarT;
    EditText edOtros, edSituacion;
    CheckBox cbDifRespirar, cbFiebre,cbTosSeca, cbCansancio,  cbDolorGarganta,cbDiarrea,cbMalestares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triaje);

        btnAlertaT = (Button) findViewById(R.id.btnAceptarT);
        edOtros = (EditText) findViewById(R.id.edOtros);
        edSituacion = (EditText) findViewById(R.id.edSituacion);
        cbDifRespirar = (CheckBox) findViewById(R.id.cbDifRespirar);
        cbFiebre = (CheckBox) findViewById(R.id.cbFiebre);
        cbTosSeca = (CheckBox) findViewById(R.id.cbTosSeca);
        cbCansancio = (CheckBox) findViewById(R.id.cbCansancio);
        cbDolorGarganta = (CheckBox) findViewById(R.id.cbDolorGarganta);
        cbDiarrea = (CheckBox) findViewById(R.id.cbDiarrea);
        cbMalestares = (CheckBox) findViewById(R.id.cbMalestares);

        btnAlertaT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecutarSerivcio("http://192.168.1.12:8080/proyectodb/insertar_triaje.php");
                startActivity(new Intent(Triaje.this, Menu.class));
            }
        });
        btnCancelarT = (Button) findViewById(R.id.btnAtrasT);

        btnCancelarT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Triaje.this, Menu.class));
            }
        });

    }

    //Metodo para enviar peticiones al servidor
    private void ejecutarSerivcio(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),"Registro exitoso",Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("DifRespirar",cbDifRespirar.getText().toString());
                parametros.put("Fiebre",cbFiebre.getText().toString());
                parametros.put("TosSeca",cbTosSeca.getText().toString());
                parametros.put("Cansancio",cbCansancio.getText().toString());
                parametros.put("DolorGarganta",cbDolorGarganta.getText().toString());
                parametros.put("Diarrea",cbDiarrea.getText().toString());
                parametros.put("Malestares",cbMalestares.getText().toString());
                parametros.put("Otros",edOtros.getText().toString());
                parametros.put("Situacion",edSituacion.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
