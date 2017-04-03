package com.cc.josaded.proyectosicopma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class PasosDerivadaActivity extends AppCompatActivity {

    private ListView list;
    private String[] pasosEc = new String[13];
    private String[] pasos = new String[6];
    private TextView nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasos_derivada);

        nota = (TextView) findViewById(R.id.tvNota);

        double c = getIntent().getExtras().getDouble("constante");
        double p = getIntent().getExtras().getDouble("potencia");
        String i = getIntent().getExtras().getString("incognita");
        String operacion = getIntent().getExtras().getString("operacion");

        double aEc = getIntent().getExtras().getDouble("a");
        double bEc = getIntent().getExtras().getDouble("b");
        double cEc = getIntent().getExtras().getDouble("c");

        list = (ListView)findViewById(R.id.lvPasosDerivada);

        if  (getIntent().getExtras().getString("clase").equals("i")){

            pasos[0] = "       Integral:      " + operacion;
            pasos[1] = "1. Multiplica la constante por la potencia:";
            pasos[2] = "       ( " + c + ") ( " + p + " ) " + i + "  =  " + (c * p);
            pasos[3] = "2. Suma 1 a la potencia de la incognita:";
            pasos[4] = "       "+(c * p) + " " + i + "^ (" + p + " + 1 )";
            pasos[5] = "Resultado:        " + (c*p) + i + "^" + (p+1);

            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pasos);
            list.setAdapter(adaptador);
        }

        if  (getIntent().getExtras().getString("clase").equals("d")){

            pasos[0] = "       Derivada:      " + operacion;
            pasos[1] = "1. Multiplica la constante por la potencia:";
            pasos[2] = "       ( " + c + ") ( " + p + " ) " + i + "  =  " + (c * p);
            pasos[3] = "2. Resta 1 a la potencia de la incognita:";
            pasos[4] = "       "+(c * p) + " " + i + "^ (" + p + " - 1 )";
            pasos[5] = "Resultado:        " + (c*p) + i + "^" + (p-1);

            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pasos);
            list.setAdapter(adaptador);

             nota.setText("Si la incognita no tiene una constante o pontencia visible, su valor por defecto es 1.");
        }

        if  (getIntent().getExtras().getString("clase").equals("e")){

            pasosEc[0] = "     Ecuación:      " + operacion;
            pasosEc[1] = "      a="+aEc+"  b="+bEc+"  c="+cEc;
            pasosEc[2] = "";
            pasosEc[3] = "     (-"+bEc+"± (√ ("+bEc+")² * 4("+aEc+")("+cEc+"))) / 2*"+aEc;
            pasosEc[4] = "1. Resuelve las operaciones del interior de la raíz cuadrada";
            pasosEc[5] = "     (-("+bEc+")± (√ "+((Math.pow(bEc,2))+4*(aEc*cEc))+")) / 2*"+aEc;
            pasosEc[6] = "2. Multiplica a("+aEc+") por 2:";
            pasosEc[7] = "     (-("+bEc+")± (√ ("+((Math.pow(bEc,2))+4*(aEc*cEc))+"))) /"+(aEc*2);
            pasosEc[8] = "3. Para el primer resultado, suma -b("+bEc+") mas la raíz cuadrada de "+((Math.pow(bEc,2))+4*(aEc*cEc))+":";
            pasosEc[9] = "     "+((-1*bEc) + (Math.sqrt((Math.pow(bEc,2))+4*(aEc*cEc))))+" /"+(aEc*2);
            pasosEc[10] = "4. Para el segundo resultado, resta -b("+bEc+") a la raíz cuadrada de "+((Math.pow(bEc,2))+4*(aEc*cEc))+":";
            pasosEc[11] = "    "+((-1*bEc) - (Math.sqrt((Math.pow(bEc,2))+4*(aEc*cEc))))+" /"+(aEc*2);
            pasosEc[12] = "Resultado:  x="+disminuirDecimales(String.valueOf(((-1*bEc) + (Math.sqrt((Math.pow(bEc,2))+4*(aEc*cEc))))/2*aEc))+"  y  x="+disminuirDecimales(String.valueOf(((-1*bEc) - (Math.sqrt((Math.pow(bEc,2))+4*(aEc*cEc))))/2*aEc));

            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pasosEc);
            list.setAdapter(adaptador);
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
