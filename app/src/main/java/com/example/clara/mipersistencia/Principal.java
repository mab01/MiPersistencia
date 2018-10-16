package com.example.clara.mipersistencia;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.clara.mipersistencia.aplication.BaseAplication;

import java.util.List;

public class Principal extends AppCompatActivity {
    private EditText nombre;
    private EditText apellido;
    private EditText telefono;
    private Button guardar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        nombre= findViewById(R.id.etnombre);
        apellido= findViewById(R.id.etapellido);
        telefono= findViewById(R.id.ettelefono);

        guardar= findViewById(R.id.btguardar);

         guardar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 ((BaseAplication)getApplication()).insertarCliente(nombre.getText().toString(), apellido.getText().toString(),telefono.getText().toString());
                 Intent in= new Intent(Principal.this,ListActivity.class);
                 nombre.setText(" ");
                 apellido.setText(" ");
             }
         });

        }



    public void onClick(View view) {

        Intent miIntent= new Intent(Principal.this, ListActivity.class);
        startActivity(miIntent);

    }
}
