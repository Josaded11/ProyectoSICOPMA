package com.cc.josaded.proyectosicopma;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DerivadaActivity extends AppCompatActivity implements View.OnClickListener {

    private String btn = "";
    private EditText pantalla;
    private TextView sd;
    //Enviar a activity pasos:
    private double cons = 0;
    private double pot = 0;
    private String inc = "";
    private String enviarDerivada = "";

    private boolean igualActivo, puntoActivo, xActivo, yActivo = false;
    private Button cero,uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,punto,borrar,reiniciar,igual,sumar,restar,dividir,multiplicar,potencia, x ,y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_derivada);
        pantalla = (EditText) findViewById(R.id.etPantallaResultado);
        sd = (TextView) findViewById(R.id.tvDerivada);


        RadioButton rOpBa = (RadioButton) findViewById(R.id.rbOpBasicas);
        rOpBa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(DerivadaActivity.this, MainActivity.class);
                startActivity(e);
                finish();
            }
        });
        RadioButton rIntegral = (RadioButton) findViewById(R.id.rbIntegrales);
        rIntegral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(DerivadaActivity.this, IntegralActivity.class);
                startActivity(e);
                finish();
            }
        });
        RadioButton rEcuacion = (RadioButton) findViewById(R.id.rbEcuaciones);
        rEcuacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(DerivadaActivity.this, EcuacionActivity.class);
                startActivity(e);
                finish();
            }
        });

        Button next = (Button) findViewById(R.id.btnPasos);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(igualActivo){
                    Intent irPasos = new Intent(DerivadaActivity.this, PasosDerivadaActivity.class);
                    irPasos.putExtra("constante", cons);
                    irPasos.putExtra("potencia", pot);
                    irPasos.putExtra("incognita", inc);
                    irPasos.putExtra("operacion", enviarDerivada);
                    irPasos.putExtra("clase","d");
                    startActivity(irPasos);
                }else{
                    Toast.makeText(getApplication(),String.valueOf("No hay operación para mostrar"),Toast.LENGTH_SHORT).show();
                }
            }
        });


        Button form = (Button) findViewById(R.id.btnForm);
        form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irPasos = new Intent(DerivadaActivity.this, FormularioActivity.class);
                irPasos.putExtra("clase","d");
                startActivity(irPasos);
            }
        });

        Button historialGen = (Button) findViewById(R.id.btnHistorial);
        historialGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irPasos = new Intent(DerivadaActivity.this, HistorialActivity.class);
                startActivity(irPasos);
            }
        });
        //NÚMEROS:
        cero = (Button) findViewById(R.id.btnCero);
        cero.setOnClickListener(this);
        uno = (Button) findViewById(R.id.btnUno);
        uno.setOnClickListener(this);
        dos = (Button) findViewById(R.id.btnDos);
        dos.setOnClickListener(this);
        tres = (Button) findViewById(R.id.btnTres);
        tres.setOnClickListener(this);
        cuatro = (Button) findViewById(R.id.btnCuatro);
        cuatro.setOnClickListener(this);
        cinco = (Button) findViewById(R.id.btnCinco);
        cinco.setOnClickListener(this);
        seis = (Button) findViewById(R.id.btnSeis);
        seis.setOnClickListener(this);
        siete = (Button) findViewById(R.id.btnSiete);
        siete.setOnClickListener(this);
        ocho = (Button) findViewById(R.id.btnOcho);
        ocho.setOnClickListener(this);
        nueve = (Button) findViewById(R.id.btnNueve);
        nueve.setOnClickListener(this);
        //OPERADORES:
        multiplicar = (Button) findViewById(R.id.btnMultiplicar);
        multiplicar.setOnClickListener(this);
        dividir = (Button) findViewById(R.id.btnDivision);
        dividir.setOnClickListener(this);
        sumar = (Button) findViewById(R.id.btnSuma);
        sumar.setOnClickListener(this);
        restar = (Button) findViewById(R.id.btnResta);
        restar.setOnClickListener(this);
        potencia = (Button) findViewById(R.id.btnPotencia);
        potencia.setOnClickListener(this);
        //EXTRAS:
        x = (Button) findViewById(R.id.btnX);
        x.setOnClickListener(this);
        y = (Button) findViewById(R.id.btnY);
        y.setOnClickListener(this);
        punto = (Button) findViewById(R.id.btnPunto);
        punto.setOnClickListener(this);
        borrar = (Button) findViewById(R.id.btnBorrar);
        borrar.setOnClickListener(this);
        reiniciar = (Button) findViewById(R.id.btnReiniciar);
        reiniciar.setOnClickListener(this);
        igual = (Button) findViewById(R.id.btnIgual);
        igual.setOnClickListener(this);
    }

    public void escribir(String c){
        pantalla.setText(c);
    }

    @Override
    public void onClick(View v) {
        try {
            switch (v.getId()){
                case R.id.btnCero:
                    if (igualActivo){btn = "0"; xActivo = false; yActivo = false; igualActivo= false;}else{btn += "0";}
                    break;
                case R.id.btnUno:
                    if (igualActivo){btn = "1"; xActivo = false; yActivo = false; igualActivo= false;}else{btn += "1";}
                    break;
                case R.id.btnDos:
                    if (igualActivo){btn = "2"; xActivo = false; yActivo = false; igualActivo= false;}else{btn += "2";}
                    break;
                case R.id.btnTres:
                    if (igualActivo){btn = "3"; xActivo = false; yActivo = false; igualActivo= false;}else{btn += "3";}
                    break;
                case R.id.btnCuatro:
                    if (igualActivo){btn = "4"; xActivo = false; yActivo = false; igualActivo= false;}else{btn += "4";}
                    break;
                case R.id.btnCinco:
                    if (igualActivo){btn = "5"; xActivo = false; yActivo = false; igualActivo= false;}else{btn += "5";}
                    break;
                case R.id.btnSeis:
                    if (igualActivo){btn = "6"; xActivo = false; yActivo = false; igualActivo= false;}else{btn += "6";}
                    break;
                case R.id.btnSiete:
                    if (igualActivo){btn = "7"; xActivo = false; yActivo = false; igualActivo= false;}else{btn += "7";}
                    break;
                case R.id.btnOcho:
                    if (igualActivo){btn = "8"; xActivo = false; yActivo = false; igualActivo= false;}else{btn += "8";}
                    break;
                case R.id.btnNueve:
                    if (igualActivo){btn = "9"; xActivo = false; yActivo = false; igualActivo= false;}else{btn += "9";}
                    break;
                case R.id.btnX:
                        if(!xActivo && !yActivo){
                            btn += "x";
                            sd.setText("d/dx");
                            xActivo = true;
                            puntoActivo = true;
                        }
                    break;
                case R.id.btnY:
                        if(!xActivo && !yActivo){
                            btn += "y";
                            sd.setText("d/dy");
                            yActivo = true;
                            puntoActivo = true;
                        }
                    break;
                case R.id.btnPunto:
                    if (btn.isEmpty()){
                        if (!puntoActivo){btn = "0.";}
                    }else{
                        if (!puntoActivo){btn += ".";}
                    }
                    puntoActivo = true;
                    break;
                case R.id.btnBorrar:
                    if (!btn.isEmpty()){
                        if (btn.charAt(btn.length()-1)=='.'){
                            puntoActivo = false;
                        }else if(btn.charAt(btn.length()-1)=='x'){
                            xActivo = false;
                        }else if(btn.charAt(btn.length()-1)=='y'){
                            yActivo = false;
                        }
                        btn = btn.substring(0,btn.length()-1);
                    }
                    break;
                case R.id.btnReiniciar:
                    btn = "";
                    xActivo = false;
                    yActivo = false;
                    puntoActivo = false;
                    igualActivo = false;
                    break;
                case R.id.btnSuma:
                    btn += "+";
                    break;
                case R.id.btnResta:
                    btn += "-";
                    break;
                case R.id.btnMultiplicar:
                    btn += "*";
                    break;
                case R.id.btnDivision:
                    btn += "/";
                    break;
                case R.id.btnPotencia:
                        btn += "^";
                    break;
                case R.id.btnIgual:
                    enviarDerivada = btn;
                    if (btn.equals("x") || btn.equals("y")){
                        inc = btn;
                        btn = "1";
                        pot = 1;
                        cons = 1;
                    }else{
                        String constante = "";
                        String potencia = "";
                        String incognita = "";
                        boolean es = false;
                        for (int i=0; i<btn.length(); i++){

                            if(es == false){
                                try{
                                    if ((btn.charAt(i)=='x' || btn.charAt(i)=='y') && btn.charAt(i+1)=='^'){
                                        incognita = String.valueOf(btn.charAt(i));
                                        es = true;
                                        i++;
                                    }else{
                                        constante += String.valueOf(btn.charAt(i));
                                    }
                                }catch (IndexOutOfBoundsException ie){
                                    incognita = String.valueOf(btn.charAt(i));
                                }
                            }else{
                                potencia += String.valueOf(btn.charAt(i));
                            }
                        }

                        Conexion con = new Conexion(getApplicationContext(),"historial3.sqlite",null,1);
                        SQLiteDatabase db = con.getWritableDatabase();
                        String sql = "insert into operaciones (tipo,operacion,resultado) values ('Derivada: ','"+ btn +"','"+ resolver(constante,potencia,incognita) +"')";
                        db.execSQL(sql);
                        db.close();
                        btn = resolver(constante,potencia,incognita);
                    }
                    igualActivo = true;
                    puntoActivo = false;
                    break;
            }
            escribir(btn);
        } catch (Exception e) {
            pantalla.setText("Error");
        }
    }

    public String resolver(String c, String p, String i){
        String res = "";
        if (!c.equals("") && p.equals("") && i.equals("")){
            cons = Double.parseDouble(c);
            pot = 0;
            inc = "";
            return "0";
        }else if(!c.equals("") && p.equals("") && !i.equals("")){
            cons = Double.parseDouble(c);
            pot = 0;
            inc = i;
            return c;
        }else{
            double op1 = Double.parseDouble(c);
            double op2 = Double.parseDouble(p);
            double r = op1 * op2;
            cons = op1;
            pot = op2;
            inc = i;
            res = disminuirDecimales(String.valueOf(r));
            if (r == 0 || r == 0.0){
                return i + disminuirPotencia(p);
            }else{
                p = disminuirPotencia(p);
                if(p.equals("1") || p.equals("0")){
                    return res + i;
                }else{
                    return res + i + "^" + p;
                }
            }
        }
    }

    public String disminuirPotencia(String p){
        double pot = Double.parseDouble(p)-1;
        String cadena = String.valueOf(pot);
        return disminuirDecimales(cadena);
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

    public boolean esOperador(char c){
        return c=='+' || c=='-' || c=='*' || c=='/' || c=='^';
    }

}
