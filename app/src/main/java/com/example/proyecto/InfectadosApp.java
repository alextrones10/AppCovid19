package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewDebug;
import android.widget.EditText;
import android.widget.TextView;



public class InfectadosApp extends AppCompatActivity {

    EditText edtLima,edtAmazonas,edtAncash,edtSanMartin,edtIca,edtPiura,edtTacna,edtHuancavelica,edtCusco;
    EditText edtTotalRegistros, edtInfectados,edtNoInfectados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infectados_app);



        edtTotalRegistros = (EditText)findViewById(R.id.edtTotalRegistros);
        edtInfectados = (EditText)findViewById(R.id.edtInfectados);
        edtNoInfectados = (EditText)findViewById(R.id.edtNoInfectados);
        edtLima = (EditText)findViewById(R.id.edtLima);
        edtAmazonas = (EditText)findViewById(R.id.edtAmazonas);
        edtAncash = (EditText)findViewById(R.id.edtAncash);
        edtSanMartin = (EditText)findViewById(R.id.edtSanMartin);
        edtIca = (EditText)findViewById(R.id.edtIca);
        edtHuancavelica = (EditText)findViewById(R.id.edtHuancavelica);
        edtPiura = (EditText)findViewById(R.id.edtPiura);
        edtTacna = (EditText)findViewById(R.id.edtTacna);
        edtCusco = (EditText)findViewById(R.id.edtCusco);

        //int cantidadInfectados = cantInfectados();
        //String cInf = String.valueOf(cantidadInfectados);

        edtTotalRegistros.setText("20");
        edtInfectados.setText("14");
        edtNoInfectados.setText("6");
        edtLima.setText("7");
        edtAmazonas.setText("1");
        edtAncash.setText("0");
        edtSanMartin.setText("0");
        edtIca.setText("1");
        edtHuancavelica.setText("0");
        edtPiura.setText("4");
        edtTacna.setText("0");
        edtCusco.setText("1");





        /*edtTotalRegistros.setText(cantInfectados());
        edtInfectados.setText(cantNoInfectados());
        edtNoInfectados.setText(totalRegistro());
        edtLima.setText(iLima());
        edtAmazonas.setText(iAmazonas());
        edtAncash.setText(iAncash());
        edtSanMartin.setText(iSanMartin());
        edtIca.setText(iIca());
        edtHuancavelica.setText(iHuancavelica());
        edtPiura.setText(iPiura());
        edtTacna.setText(iTacna());
        edtCusco.setText(iCusco());
        */

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
