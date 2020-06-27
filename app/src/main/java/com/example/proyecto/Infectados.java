package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Infectados extends AppCompatActivity {

    private WebView vistaIfectados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infectados);

        setTitle("Infectados");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        vistaIfectados = findViewById(R.id.wvInfectados);
        vistaIfectados.getSettings().setJavaScriptEnabled(true);
        vistaIfectados.setWebViewClient(new WebViewClient());
        vistaIfectados.loadUrl("https://covid19.minsa.gob.pe/sala_situacional.asp");

    }
}
