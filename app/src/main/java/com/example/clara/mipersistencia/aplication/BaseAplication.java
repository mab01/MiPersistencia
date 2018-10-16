package com.example.clara.mipersistencia.aplication;

import android.app.Application;
import android.database.Cursor;

import com.example.clara.mipersistencia.Cliente;
import com.example.clara.mipersistencia.adapter.DBAdapter;

import java.util.ArrayList;


    public class BaseAplication extends Application {

        DBAdapter dbAdapter;

        @Override
        public void onCreate() {

            dbAdapter= new DBAdapter(getApplicationContext());
            dbAdapter.open();
            super.onCreate();
        }

        @Override
        public void onTerminate() {

            dbAdapter.close();
            super.onTerminate();
        }

        public void rellenarDatosTabla1(){

            if(dbAdapter.clienteIsEmpty()){
                for(int i=0; i<30;i++){

                    String nombre= "nombre"+ String.valueOf(i);
                    String apellido= "apellido"+ String.valueOf(i);
                    String numero= "555-"+String.valueOf(i);
                    dbAdapter.clienteInsert(nombre, apellido,numero);
                }
            }
        }

        public boolean insertarCliente(String nombre, String apellido, String telefono){

            return dbAdapter.clienteInsert(nombre,apellido,telefono);
        }


        public ArrayList<Cliente> nombresClientes(){

            ArrayList<Cliente> lista= new ArrayList<Cliente>();
            Cursor c= dbAdapter.getDatosCliente();
            Cliente c1;

            if(c.moveToFirst()){

                do{

                    c1=new Cliente(c.getString(1), c.getString(2), c.getString(3));
                    lista.add(c1);

                } while (c.moveToNext());
            }
            return lista;
        }
    }


