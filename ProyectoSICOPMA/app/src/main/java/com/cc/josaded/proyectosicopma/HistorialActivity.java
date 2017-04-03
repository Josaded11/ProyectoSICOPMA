package com.cc.josaded.proyectosicopma;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class HistorialActivity extends AppCompatActivity {

    private ListView li;
    private ArrayList lista = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        Button historial = (Button) findViewById(R.id.btnLimpiarHistorial);
        historial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Conexion con = new Conexion(getApplicationContext(),"historial3.sqlite",null,1);
                SQLiteDatabase db = con.getWritableDatabase();
                db.execSQL("delete from operaciones");
                finish();
            }
        });
        li = (ListView) findViewById(R.id.lvHistorial);

        Conexion con = new Conexion(getApplicationContext(),"historial3.sqlite",null,1);
        SQLiteDatabase db = con.getWritableDatabase();
        Cursor c = db.rawQuery("select * from operaciones", null);

        int i = 1;
        if(c.moveToFirst()){
            do{
                lista.add(" " + i + ".  " + c.getString(0) + "  " + c.getString(1) + "  =  " + c.getString(2));
                i++;
            }while (c.moveToNext());
        }

        ArrayAdapter adap = new ArrayAdapter(getApplication(), android.R.layout.simple_list_item_1, lista);
        li.setAdapter(adap);
        db.close();
    }
}
