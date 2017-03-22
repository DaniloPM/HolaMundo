package com.example.android.holamundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    private EditText cajaNombre;
    private EditText cajaApellido;
    private Intent i; //Pasar de una actividad a otra.
    private Bundle b; //Tener los datos encapsulados.
    private Spinner comboGenero;
    private RadioButton r1, r2, r3;
    private ArrayAdapter<String> adapter;
    private String[] opc;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Capturamos las cajas.
        cajaNombre = (EditText) findViewById(R.id.txtNombre);
        cajaApellido = (EditText) findViewById(R.id.txtApellido);

        //capturar combo
        comboGenero = (Spinner)findViewById(R.id.cmdGenero);



        //capturar Radios
        r1= (RadioButton)findViewById(R.id.r1);
        r2= (RadioButton)findViewById(R.id.r2);
        r3= (RadioButton)findViewById(R.id.r3);




        //Creamos el objeto Intent que sirve para pasar de una actividad a otra.
        i = new Intent(this, Saludo.class);
        //Creamos el objeto Bundle que sirve para encapsular datos.
        b = new Bundle();


        opc = this.getResources().getStringArray(R.array.generos);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc);

        comboGenero.setAdapter(adapter);


    }

    public void saludar(View v) { //Hacer boton.
        String nomb, apell,genero,estado_civil=" ";
        if (validar()) {
            //Tomo el valor que la persona ingresó tanto en nombre como en apellido.
            nomb = cajaNombre.getText().toString();//Traer texto.
            apell = cajaApellido.getText().toString();//Traer texto.

            //Capturar Genero
            genero = comboGenero.getSelectedItem().toString();

            //Capturar Estado Civil

            if(r1.isChecked())estado_civil = getResources().getString(R.string.Soltero);
            if(r2.isChecked())estado_civil = getResources().getString(R.string.Casado);
            if(r3.isChecked())estado_civil = getResources().getString(R.string.Divorciado);




            //Encapsulo los valores previamente tomados.
            b.putString("Nombre", nomb);//Meter en la capsula.
            b.putString("Apellido", apell);//Meter en la capsula.
            b.putString("Genero",genero);
            b.putString("Estado_civil",estado_civil);
            //Le paso al Intent todos los datos en forma encapsulada con el Bundle.
            i.putExtras(b);//Pasar la capsula.

            //Arranco la actividad que el Intent me diga.
            startActivity(i);//Pasa a la actividad que dijo el Intent.

        }

    }
    public void borrar(View v){
        cajaNombre.setText(" ");
        cajaNombre.requestFocus();
        cajaApellido.setText(" ");
        comboGenero.setSelection(0);
        r1.setChecked(true);

        

    }



    public boolean validar() {
        if (cajaNombre.getText().toString().isEmpty()) {
            //cajaNombre.setError(getResources().getString(R.string.error_1));
            Toast.makeText(this, "Digite Por Favor El Nombre.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (cajaApellido.getText().toString().isEmpty()) {
           //cajaApellido.setError(getResources().getString(R.string.error_2));
            Toast.makeText(this, "Digite Por Favor El Apellido.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }



}
