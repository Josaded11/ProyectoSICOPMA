package com.cc.josaded.proyectosicopma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PasosDerivadaActivity extends AppCompatActivity {

    TextView col1,col2,col3,col4,col5,col6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasos_derivada);

        col1 = (TextView) findViewById(R.id.tvHistorialPasos);
        col2 = (TextView) findViewById(R.id.tvHistorialPasos2);
        col3 = (TextView) findViewById(R.id.tvHistorialPasos3);
        col4 = (TextView) findViewById(R.id.tvHistorialPasos4);
        col5 = (TextView) findViewById(R.id.tvHistorialPasos5);
        col6 = (TextView) findViewById(R.id.tvHistorialPasos6);

        double c = getIntent().getExtras().getDouble("constante");
        double p = getIntent().getExtras().getDouble("potencia");
        String i = getIntent().getExtras().getString("incognita");
        String operacion = getIntent().getExtras().getString("operacion");



        col1.setText("Derivada:      " + operacion);
        col2.setText("1. Multiplica la constante por la potencia:");
        col3.setText("( " + c + ") ( " + p + " ) " + i + "  =  " + (c * p));
        col4.setText("2. Resta 1 a la potencia de la incognita:");
        col5.setText((c * p) + " " + i + "^ (" + p + "- 1 )");
        col6.setText("Resultado:        " + (c*p) + i + "^" + (p-1));


    }
}
