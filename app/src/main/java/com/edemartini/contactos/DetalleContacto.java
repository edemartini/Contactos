package com.edemartini.contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle parametros = getIntent().getExtras();

        //Recibo los parámetros
        String Nombre = parametros.getString("Nombre");
        String Telefono = parametros.getString("Telefono");
        String Email = parametros.getString("Email");
        String Descripcion = parametros.getString("Descripcion");
        String FechaNacimiento = parametros.getString("FechaNacimiento");

        //Conecto variables textview con el layout
        TextView tvNombre = (TextView) findViewById(R.id.tvNombre);
        TextView tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        TextView tvEmail = (TextView) findViewById(R.id.tvEmail);
        TextView tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);
        TextView tvFechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);

        //Despliego parámetros recibidos en el layout
        tvNombre.setText(Nombre);
        tvTelefono.setText(Telefono);
        tvEmail.setText(Email);
        tvDescripcion.setText(Descripcion);
        tvFechaNacimiento.setText(FechaNacimiento);

    }

    public void editarDatos (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        finish();
    }

}