package com.example.clara.mipersistencia.adapter;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class ProyectoAdapter {
    private static final String NAME = "proyecto";
    private SQLiteDatabase sqlDB;

    public ProyectoAdapter(SQLiteDatabase sqlDB) {

        this.sqlDB = sqlDB;
    }

    private class Columns implements BaseColumns {

        public final static String ID = "proyecto_id";
        public final static String DESCRIPCION = "descripcion";
        public static final String COSTO = "costo";
        public static final String CLIENTE_ID = "cliente_id";

    }

    private final static String[] COLUMNS = {

            Columns.ID, Columns.DESCRIPCION, Columns.COSTO, Columns.CLIENTE_ID

    };

    public  final  static  String CR_TABLE= "create table if not exists " +NAME+ " ( " +Columns.ID
            +" integer primary key autoincrement, "
            +Columns.DESCRIPCION+ " text not null, "
            +Columns.COSTO+" real, "
            +Columns.CLIENTE_ID+" integer, FOREIGN KEY (cliente_id) REFERENCES cliente(cliente_id))";


    public  boolean insert(String descripcion, double costo, int cliente_id){
        //relacionamos campos con valores en el objeto ContentValues

        ContentValues values= new ContentValues();
        values.put(Columns.DESCRIPCION, descripcion);
        values.put(Columns.COSTO, costo);
        values.put(Columns.CLIENTE_ID, cliente_id);

        return  sqlDB.insert(NAME,null,values)>0;

    }
    //devuelve el cursor con todos los nobmres de proyectos registrados
    public Cursor getDescripciones(){
        String [] columns={Columns.DESCRIPCION};
        return sqlDB.query(NAME, columns, null,null,null,null,null);

    }


    // devuelve el nombre de la tabla

    public  String getName(){
        return NAME;

    }

    public String[] getColumns(){

        return  COLUMNS;
    }

    //comprueba si la tabla contiene datos

    public  boolean isEmpty(){

        return sqlDB.query(NAME,COLUMNS,null, null,null,null,null).getCount()==0;
    }

    public Cursor getDatos(){

        return sqlDB.query(NAME,COLUMNS,null,null,null,null,null);
    }
}
