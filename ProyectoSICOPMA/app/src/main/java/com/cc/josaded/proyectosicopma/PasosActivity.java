package com.cc.josaded.proyectosicopma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class PasosActivity extends AppCompatActivity{

    TextView col1,col2,col3,col4,col5,col6;
    BeanOperacion bo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasos);
        bo = new BeanOperacion();
        col1 = (TextView) findViewById(R.id.tvHistorialPasos);
        col2 = (TextView) findViewById(R.id.tvHistorialPasos2);
        col3 = (TextView) findViewById(R.id.tvHistorialPasos3);
        col4 = (TextView) findViewById(R.id.tvHistorialPasos4);
        col5 = (TextView) findViewById(R.id.tvHistorialPasos5);
        col6 = (TextView) findViewById(R.id.tvHistorialPasos6);

        String historial = getIntent().getExtras().getString("pasos");
        String resultado = getIntent().getExtras().getString("resultado");

        String op1 = "";
        String op2 = "";
        boolean opOk = false;
        char c;
        for (int i=0; i<historial.length();i++){
            c = historial.charAt(i);
            if (bo.esDecimal(c)){
                if (opOk){
                    op2 += c;
                }else{
                    op1 += c;
                }
            }else{
                opOk = true;
            }
        }

        op1 = disminuirDecimales(op1);
        op2 = disminuirDecimales(op2);


        //BÚSQUEDA DE LA OPERACIÓN ACTIVA:
        if (getIntent().getExtras().getBoolean("suma")){
            col1.setText("Suma");
            col2.setText(op1+" + "+op2);
            col5.setText("Agrega "+op2+" al "+op1+".");
            col6.setText("Resultado:  "+resultado);
        }
        if (getIntent().getExtras().getBoolean("multi")){
            col1.setText("Multiplicación");
            col2.setText(op1+" * "+op2);
            col5.setText("Suma "+op1+" más "+op1+", "+op2+" veces.");
            col6.setText("Resultado:  "+resultado);
        }
        if (getIntent().getExtras().getBoolean("resta")){
            col1.setText("Resta");
            col2.setText(op1+" - "+op2);
            col5.setText("Resta "+op2+" al "+op1);
            col6.setText("Resultado:  "+resultado);
        }
        if (getIntent().getExtras().getBoolean("div")){
            col1.setText("División");
            col2.setText(op1+" / "+op2);
            col5.setText("Divide "+op2+" entre "+op1);
            col6.setText("Resultado:  "+resultado);
        }
        if (getIntent().getExtras().getBoolean("pot")){
            col1.setText("Potencia");
            col2.setText(op1+" ^ "+op2);
            col5.setText("Multiplica "+op1+" por "+op1+", "+op2+" veces.");
            col6.setText("Resultado:  "+resultado);
        }
        if (getIntent().getExtras().getBoolean("por")){
            col1.setText("Porcentaje");
            col2.setText("1. Multiplica " + op1 + " por 100:");
            col3.setText(op1+" * 100   =   " + (Double.parseDouble(op1)*100));
            col4.setText("2. Divide el resultado entre " + op2 + ":");
            col5.setText((Double.parseDouble(op1)*100)+" / "+op2 + "   =   " + ((Double.parseDouble(op1)*100)/Double.parseDouble(op2)) );
            col6.setText("Resultado:  " + ((Double.parseDouble(op1)*100)/Double.parseDouble(op2)));
        }
        if (getIntent().getExtras().getBoolean("raiz")){
            col1.setText("Raíz");
            col2.setText("1. Saca la raíz cuadrada de " + op2 + ":");
            col3.setText("√ "+op2 + "    =   " + (Math.sqrt(Double.parseDouble(op2))));
            col4.setText("2. Multiplica el resultado " + (Math.sqrt(Double.parseDouble(op2))) + " por " + op1 + ":");
            col5.setText(op1+" * "+(Math.sqrt(Double.parseDouble(op2))));
            col6.setText("Resultado:  "+ ((Math.sqrt(Double.parseDouble(op2))) + op1));
        }
    }

    public String disminuirDecimales(String cadena){
        String r = "";
        for (int i=0;i<cadena.length(); i++){
            if (cadena.charAt(i) == '.' && cadena.charAt(i+1) == '0'){
                return r;
            }else if (cadena.charAt(i) == '.' && !(cadena.charAt(i+1) == '0')){
                return r+cadena.charAt(i)+cadena.charAt(i+1);
            }else{
                r += cadena.charAt(i);
            }
        }
        return r;
    }
}
