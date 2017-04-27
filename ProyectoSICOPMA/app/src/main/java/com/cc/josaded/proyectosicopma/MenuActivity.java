package com.cc.josaded.proyectosicopma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void operaciones(View view){
        Button form = (Button) findViewById(R.id.btnMenuOperaciones);
        form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irPasos = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(irPasos);
            }
        });
    }
}
