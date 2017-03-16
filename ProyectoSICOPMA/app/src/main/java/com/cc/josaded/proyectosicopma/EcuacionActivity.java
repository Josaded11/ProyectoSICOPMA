package com.cc.josaded.proyectosicopma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class EcuacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecuacion);

        RadioButton rOpBa = (RadioButton) findViewById(R.id.rbOpBasicas);
        rOpBa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(EcuacionActivity.this, MainActivity.class);
                startActivity(e);
                finish();
            }
        });
        RadioButton rIntegral = (RadioButton) findViewById(R.id.rbIntegrales);
        rIntegral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(EcuacionActivity.this, IntegralActivity.class);
                startActivity(e);
                finish();
            }
        });
        RadioButton rDerivada = (RadioButton) findViewById(R.id.rbDerivadas);
        rDerivada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(EcuacionActivity.this, DerivadaActivity.class);
                startActivity(e);
                finish();
            }
        });
    }
}
