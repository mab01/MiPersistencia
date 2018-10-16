package com.example.clara.mipersistencia;

import android.content.ClipData;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.clara.mipersistencia.aplication.BaseAplication;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Cliente> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView= (ListView) findViewById(R.id.miLista);

        lista= ((BaseAplication)getApplication()).nombresClientes();

        AdapterLista ld= new AdapterLista();
        listView.setAdapter(ld);

    }

    private class AdapterLista extends ArrayAdapter<Cliente>{
        public AdapterLista(){


            super(ListActivity.this, R.layout.items, lista);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
           View itemView=convertView;
            if (itemView == null) {
                itemView= getLayoutInflater().inflate(R.layout.items, parent,false);
            }
            Cliente itemActual= lista.get(position);

            TextView nombres= (TextView) itemView.findViewById(R.id.nombre);
            nombres.setText(itemActual.getNombre());
            TextView apellidos= (TextView) itemView.findViewById(R.id.apellido);
            apellidos.setText(itemActual.getApellido());
            TextView telefonos= (TextView) itemView.findViewById(R.id.telefono);
            apellidos.setText(itemActual.getApellido());

            return itemView;

            }


        }

}
