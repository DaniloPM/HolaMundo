package com.example.android.holamundo;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Saludo extends AppCompatActivity {

    private TextView saludo;
    private Bundle b;
    private String aux, nomb, apell,genero,Estado_civil;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);

        saludo = (TextView)findViewById(R.id.txtSaludo);
        b = getIntent().getExtras();
        nomb = b.getString("Nombre");
        apell = b.getString("Apellido");
        genero = b.getString("Genero");
        Estado_civil = b.getString("Estado_civil");
        res = this.getResources();

        //aux = res.getString(R.string.parte_saludo)+" "+nomb+" "+apell+" "+res.getString(R.string.parte_saludo2);
        aux = aux+"\n"+getResources().getString(R.string.Datos);
        aux = aux+"\n\n"+getResources().getString(R.string.Nombre)+": "+nomb;
        aux = aux+"\n\n"+getResources().getString(R.string.Apellido)+": "+apell;
        aux = aux+"\n\n"+getResources().getString(R.string.Genero)+": "+genero;
        aux = aux+"\n\n"+getResources().getString(R.string.Estado_Civil)+": "+Estado_civil;




        saludo.setText(aux);
    }
}