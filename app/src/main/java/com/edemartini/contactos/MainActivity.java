package com.edemartini.contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Método para ir a la otra actividad
    public void mostrarDatos (View view) {
        //Genero el intent
        Intent intent = new Intent(this, DetalleContacto.class);

        EditText etNombre = (EditText) findViewById(R.id.etNombre);
        EditText etTelefono = (EditText) findViewById(R.id.etTelefono);
        EditText etEmail = (EditText) findViewById(R.id.etEmail);
        EditText etDescripcion = (EditText) findViewById(R.id.etDescripcion);
        DatePicker dpFechaNacimiento = (DatePicker) findViewById(R.id.dpFechaNacimiento);

        //Genero String con parámetros a enviar de nombre, teléfono, email y descripción
        String Nombre = etNombre.getText().toString();
        String Telefono = etTelefono.getText().toString();
        String Email = etEmail.getText().toString();
        String Descripcion = etDescripcion.getText().toString();

        //Genero String con parámetro a enviar de fecha de nacimiento
        //Obtengo día, mes y año de la fecha ingresada en el picker de fecha de nacimiento
        //Armo string con formato dd/MM/yyyy
        //Uso el método dosDigitos para llevar a formato dd o MM (con dos dígitos)
        //En el mes sumo 1 porque Enero es el mes 0 cuando aplico getMonth()
        int day = dpFechaNacimiento.getDayOfMonth();
        int month = dpFechaNacimiento.getMonth();
        int year = dpFechaNacimiento.getYear();
        String FechaNacimiento = dosDigitos(day) + "/" + dosDigitos(month+1) + "/" + year;

        //Genero putExtras para pasarle a DetalleContacto.java
        intent.putExtra("Nombre", Nombre);
        intent.putExtra("Telefono", Telefono);
        intent.putExtra("Email", Email);
        intent.putExtra("Descripcion", Descripcion);
        intent.putExtra("FechaNacimiento", FechaNacimiento);

        startActivity(intent);

    }

    private String dosDigitos(int n) {
        return (n<=9) ? ("0"+n) : String.valueOf(n);
    }

}