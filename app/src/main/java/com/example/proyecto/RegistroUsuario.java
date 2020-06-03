package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class RegistroUsuario extends AppCompatActivity {

    Button btnAceptarU;
    Spinner spTDoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        spTDoc = (Spinner) findViewById(R.id.spDocumento);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.TipoDocumento,android.R.layout.simple_spinner_item);

        spTDoc.setAdapter(adapter);


        btnAceptarU = (Button) findViewById(R.id.btnAceptarU);

        btnAceptarU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistroUsuario.this, Menu.class));

            }
        });




    }
}
