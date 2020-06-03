package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

public class RegistroUsuario extends AppCompatActivity {

    //Objetos

    Button btnAceptarU;
    EditText edtNumDoc,edtCelular,edtDepartamento,edtProvincia,edtDistrito,edtDireccion;
    Spinner spTDocumento, spNacionalidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        //Vinculación de los objetos a los controles en el Layout
        //Spinner
        spTDocumento = (Spinner) findViewById(R.id.spDocumento);
        String [] TipoDocumento = new String[] {"DNI","Pasaporte","CE"};
        ArrayAdapter<String> adTipo = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,TipoDocumento);
        spTDocumento.setAdapter(adTipo);

        //Spinner02
        spNacionalidad = (Spinner) findViewById(R.id.spNacionalidad);
        String [] Nacionalidad = new String[] {"Peruano","Venezolano","Boliviano","Argentino","Ecuatoriano","Brasileño"};
        ArrayAdapter<String> adNacionalidad = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Nacionalidad);
        spNacionalidad.setAdapter(adNacionalidad);
        //
        edtNumDoc = (EditText)findViewById(R.id.edtNumDoc);
        edtCelular = (EditText)findViewById(R.id.edtCelular);
        edtDepartamento= (EditText)findViewById(R.id.edtDepartamento);
        edtProvincia = (EditText)findViewById(R.id.edtProvincia);
        edtDistrito = (EditText)findViewById(R.id.edtDistrito);
        edtDireccion = (EditText)findViewById(R.id.edtDireccion);
        btnAceptarU = (Button) findViewById(R.id.btnAceptarU);


        btnAceptarU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecutarSerivcio("http://192.168.1.12:8080/proyectodb/insertar_usuario.php");
                startActivity(new Intent(RegistroUsuario.this, Menu.class));
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
                parametros.put("num_usu",edtNumDoc.getText().toString());
                parametros.put("doctipo_usu",spTDocumento.getSelectedItem().toString());
                parametros.put("cel_usu",edtCelular.getText().toString());
                parametros.put("nac_usu",spNacionalidad.getSelectedItem().toString());
                parametros.put("dept_usu",edtDepartamento.getText().toString());
                parametros.put("prov_usu",edtProvincia.getText().toString());
                parametros.put("dist_usu",edtDistrito.getText().toString());
                parametros.put("dir_usu",edtDireccion.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


}
