package com.cc.josaded.proyectosicopma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FormularioActivity extends AppCompatActivity {

    private ListView list;
    private String[] sistemas = {"\nx = incognita\nc = constante\nn = potencia\n", "d/dx x = 1", "d/dx c = 0", "d/dx x^n = x^n-1", "d/dx c x^n = (c)(n)x^n-1"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        list = (ListView)findViewById(R.id.lvForm);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sistemas);
        list.setAdapter(adaptador);

    }
}
