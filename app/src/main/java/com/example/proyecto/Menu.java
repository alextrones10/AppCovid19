package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Button btnTriaje;
    Button btnInfectadosMinsa;
    Button btnMapa;
    Button btnInfectadosApp;
    Button btnRecomendaciones;
    Button btnAcerca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        setTitle("Menú");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnTriaje = (Button) findViewById(R.id.btnTriaje);
        btnInfectadosMinsa = (Button) findViewById(R.id.btnInfectadosMinsa);
        btnMapa = (Button) findViewById(R.id.btnMapa);
        btnInfectadosApp = (Button) findViewById(R.id.btnInfectadosApp);
        btnRecomendaciones = (Button) findViewById(R.id.btnRecomendaciones);
        btnAcerca = (Button) findViewById(R.id.btnAcerca);

        btnTriaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, RegistroTriaje.class);
                intent.putExtra("codigo",codigoUsuario());
                startActivity(intent);
            }
        });

        btnInfectadosMinsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Infectados.class);
                startActivity(intent);
            }
        });

        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Mapa.class);
                startActivity(intent);
            }
        });

        btnInfectadosApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,InfectadosApp.class);
                intent.putExtra("cantInfectados",cantInfectados());
                intent.putExtra("cantNoInfectados",cantNoInfectados());
                intent.putExtra("totalRegistro",totalRegistro());
                intent.putExtra("iLima",iLima());
                intent.putExtra("iAmazonas",iAmazonas());
                intent.putExtra("iAncash",iAncash());
                intent.putExtra("iSanMartin",iSanMartin());
                intent.putExtra("iIca",iIca());
                intent.putExtra("iHuancavelica",iHuancavelica());
                intent.putExtra("iPiura",iPiura());
                intent.putExtra("iTacna",iTacna());
                intent.putExtra("iCusco",iCusco());
                startActivity(intent);
            }
        });

        btnRecomendaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,Recomendaciones.class);
                startActivity(intent);
            }
        });

        btnAcerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Acerca.class);
                startActivity(intent);
            }
        });


    }

    public String codigoUsuario() {
        Bundle extras = getIntent().getExtras();
        final String codigo = extras.getString("codigo");
        return codigo;
    }

    public int cantInfectados() {
        Bundle extras = getIntent().getExtras();
        int cantInfectados = extras.getInt("cantInfectados");
        return cantInfectados;
    }
    public int cantNoInfectados() {
        Bundle extras = getIntent().getExtras();
        int cantNoInfectados = extras.getInt("cantNoInfectados");
        return cantNoInfectados;
    }
    public int totalRegistro() {
        Bundle extras = getIntent().getExtras();
        int totalRegistro = extras.getInt("totalRegistro");
        return totalRegistro;
    }
    public int iLima() {
        Bundle extras = getIntent().getExtras();
        int iLima = extras.getInt("iLima");
        return iLima;
    }
    public int iAmazonas() {
        Bundle extras = getIntent().getExtras();
        int iAmazonas = extras.getInt("iAmazonas");
        return iAmazonas;
    }
    public int iAncash() {
        Bundle extras = getIntent().getExtras();
        int iAncash = extras.getInt("iAncash");
        return iAncash;
    }
    public int iSanMartin() {
        Bundle extras = getIntent().getExtras();
        int iSanMartin = extras.getInt("iSanMartin");
        return iSanMartin;
    }
    public int iIca() {
        Bundle extras = getIntent().getExtras();
        int iIca = extras.getInt("iIca");
        return iIca;
    }
    public int iHuancavelica() {
        Bundle extras = getIntent().getExtras();
        int iHuancavelica = extras.getInt("iHuancavelica");
        return iHuancavelica;
    }
    public int iPiura() {
        Bundle extras = getIntent().getExtras();
        int iPiura = extras.getInt("iPiura");
        return iPiura;
    }
    public int iTacna() {
        Bundle extras = getIntent().getExtras();
        int iTacna = extras.getInt("iTacna");
        return iTacna;
    }

    public int iCusco() {
        Bundle extras = getIntent().getExtras();
        int iCusco = extras.getInt("iCusco");
        return iCusco;
    }




}
