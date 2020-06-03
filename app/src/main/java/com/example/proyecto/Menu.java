package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Button btnTriaje;
    Button btnInfectados;
    Button btnMapa;
    Button btnAlertas;
    Button btnRecomendaciones;
    Button btnAcerca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnTriaje = (Button) findViewById(R.id.btnTriaje);
        btnInfectados = (Button) findViewById(R.id.btnInfectados);
        btnMapa = (Button) findViewById(R.id.btnMapa);
        btnAlertas = (Button) findViewById(R.id.btnAlertas);
        btnRecomendaciones = (Button) findViewById(R.id.btnRecomendaciones);
        btnAcerca = (Button) findViewById(R.id.btnAcerca);

        btnTriaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Triaje.class));

            }
        });
        btnInfectados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Infectados.class));

            }
        });
        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Mapa.class));

            }
        });
        btnAlertas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Alertas.class));

            }
        });
        btnRecomendaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Recomendaciones.class));

            }
        });
        btnAcerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Acerca.class));

            }
        });


    }
}
