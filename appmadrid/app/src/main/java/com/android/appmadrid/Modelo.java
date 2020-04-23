package com.android.appmadrid;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class Modelo extends SQLiteOpenHelper {

    private static Modelo modelo = null;

    private static final String NOMBRE_DB="app_db";
    private static final int VERSION_DB=2;

    private static final String NOMBRE_TABLA_USUARIOS="users";
    private static final String NOMBRE_TABLA_EVENTOS="events";
    private static final String NOMBRE_TABLA_FAVORITOS="fav";

    private static final String CREACION_TABLA_USUARIOS="CREATE TABLE "+NOMBRE_TABLA_USUARIOS+" (id_user INTEGER  PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT, password TEXT);";
    private static final String CREACION_TABLA_EVENTOS="CREATE TABLE "+NOMBRE_TABLA_EVENTOS+" (id_event INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, place TEXT, Dstart TEXT, Dend TEXT, price TEXT);";
    private static final String CREACION_TABLA_FAVORITOS="CREATE TABLE "+NOMBRE_TABLA_FAVORITOS+" (" +
            "id_user_fk INTEGER, id_event_fk INTEGER," +
            " PRIMARY KEY (id_user_fk, id_event_fk)," +
            " FOREIGN KEY (id_user_fk) REFERENCES users (id_user)," +
            " FOREIGN KEY (id_event_fk) REFERENCES events (id_event)" +
            ");";


    private Modelo(@Nullable Context context) {
        super(context, NOMBRE_DB, null, VERSION_DB);
    }

    public static Modelo getModelo(Context contexto){

        if (modelo == null){
            modelo = new Modelo(contexto);
        }
        return modelo;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREACION_TABLA_USUARIOS);
        db.execSQL(CREACION_TABLA_EVENTOS);
        db.execSQL(CREACION_TABLA_FAVORITOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //de momento no lo voy a usar esto es para actualizar la base de datos
        //a una nueva version
    }
    public void consultar(){

        SQLiteDatabase db = modelo.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM 'users'",null);
        if (c.moveToFirst()){
            do {

                String column_0= c.getString(0);
                String column_1= c.getString(1);
                String column_2= c.getString(2);
                String column_3= c.getString(3);
                Log.d("registro_1",column_0+" "+column_1+" "+column_2+" "+column_3);

            }while (c.moveToNext());
        }
        db.close();
    }
    public void insertar(){


        SQLiteDatabase db = modelo.getWritableDatabase();

        db.execSQL("INSERT INTO users (name,email,password) VALUES ('Juan','ejemplo@ejemplo.com','123456')");
        Log.d("etiqueta","Insertado");

        db.close();


    }
}
