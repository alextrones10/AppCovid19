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
    EditText edtNumDoc,edtCelular,edtNacionalidad,edtDepartamento,edtProvincia,edtDistrito,edtDireccion;
    Spinner spTDoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        //Vinculación de los objetos a los controles en el Layout
        //Spinner
        spTDoc = (Spinner) findViewById(R.id.spDocumento);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.TipoDocumento,android.R.layout.simple_spinner_item);
        spTDoc.setAdapter(adapter);
        //
        edtNumDoc = (EditText)findViewById(R.id.edtNumDoc);
        edtCelular = (EditText)findViewById(R.id.edtCelular);
        edtNacionalidad = (EditText)findViewById(R.id.edtNacionalidad);
        edtDepartamento= (EditText)findViewById(R.id.edtDepartamento);
        edtProvincia = (EditText)findViewById(R.id.edtProvincia);
        edtDistrito = (EditText)findViewById(R.id.edtDistrito);
        edtDireccion = (EditText)findViewById(R.id.edtDireccion);
        btnAceptarU = (Button) findViewById(R.id.btnAceptarU);


        btnAceptarU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecutarSerivcio("http://192.168.1.12:8081/proyectodb/inserta_usuario.php");
                //startActivity(new Intent(RegistroUsuario.this, Menu.class));
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
                parametros.put("doctipo_usu",spTDoc.toString());
                parametros.put("cel_usu",edtCelular.getText().toString());
                parametros.put("nac_usu",edtNacionalidad.getText().toString());
                parametros.put("dept_usu",edtDepartamento.getText().toString());
                parametros.put("prov_usu",edtProvincia.getText().toString());
                parametros.put("dist_usu",edtDistrito.getText().toString());
                parametros.put("dir_usu",edtDireccion.getText().toString());
                return super.getParams();
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


}
