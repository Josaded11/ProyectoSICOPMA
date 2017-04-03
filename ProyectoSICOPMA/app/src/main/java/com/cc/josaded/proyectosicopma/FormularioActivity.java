package com.cc.josaded.proyectosicopma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FormularioActivity extends AppCompatActivity {

    private ListView list;
    private String[] formDerivada = {"\nx = incognita\nc = constante\nn = potencia\n", "d/dx x = 1", "d/dx c = 0", "d/dx x^n = x^n-1", "d/dx c x^n = (c)(n)x^n-1"};
    private String[] formIntegral = {"\nx = incognita\nc = constante\nn = potencia\n", "∫ x = x^2", "∫ c = cx", "∫ x^n = x^n+1", "∫ c x^n = (c)(n)x^n+1"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        list = (ListView)findViewById(R.id.lvForm);

        if(getIntent().getExtras().getString("clase").equals("d")){
            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, formDerivada);
            list.setAdapter(adaptador);
        }

        if(getIntent().getExtras().getString("clase").equals("i")){
            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, formIntegral);
            list.setAdapter(adaptador);
        }
    }
}
