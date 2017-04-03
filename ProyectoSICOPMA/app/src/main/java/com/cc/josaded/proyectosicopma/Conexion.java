package com.cc.josaded.proyectosicopma;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Josaded on 22/03/2017.
 */

public class Conexion extends SQLiteOpenHelper {
    private static final String name = "historial3.sqlite";
    private static final String sql = "create table operaciones (tipo TEXT, operacion TEXT, resultado TEXT)";

    public Conexion(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + name);
        onCreate(db);
    }
}
