package com.example.clara.mipersistencia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.clara.mipersistencia.aplication.BaseAplication;

public class ListActivity extends AppCompatActivity {

    private TextView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lista= findViewById(R.id.tvlista);

        for(String it:((BaseAplication)getApplication()).nombresClientes()){
            lista.setText(lista.getText()+it+"\n");

        }
    }
}
