package com.cc.josaded.proyectosicopma;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class EcuacionActivity extends AppCompatActivity implements View.OnClickListener {

    private String btn = "";
    private EditText pantalla;
    private String operacionEnviar = "";
    private double aEnviar = 0;
    private double bEnviar = 0;
    private double cEnviar = 0;
    private int numInc = 0;

    private boolean igualActivo, igualCActivo, puntoActivo, xActivo, yActivo = false;
    private Button cero,uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,punto,borrar,reiniciar,igual,igualC,sumar,restar,dividir,multiplicar,potencia, x ,y;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast t = Toast.makeText(getApplicationContext(),"Ejemplo de ecuación: 5x^2 + 4x + 3",Toast.LENGTH_LONG);
        t.setGravity(Gravity.CENTER,-65,-273);
        t.show();

        setContentView(R.layout.activity_ecuacion);
        pantalla = (EditText) findViewById(R.id.etPantallaResultado);

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


        Button next = (Button) findViewById(R.id.btnPasos);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(igualActivo){
                    Intent irPasos = new Intent(EcuacionActivity.this, PasosDerivadaActivity.class);
                    irPasos.putExtra("operacion",operacionEnviar);
                    irPasos.putExtra("a",aEnviar);
                    irPasos.putExtra("b",bEnviar);
                    irPasos.putExtra("c",cEnviar);
                    irPasos.putExtra("clase","e");
                    startActivity(irPasos);
                }else{
                    Toast.makeText(getApplication(),String.valueOf("No hay operación para mostrar"),Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button historialGen = (Button) findViewById(R.id.btnHistorial);
        historialGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irPasos = new Intent(EcuacionActivity.this, HistorialActivity.class);
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
        igualC = (Button) findViewById(R.id.button2);
        igualC.setOnClickListener(this);
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
                    if(!xActivo){
                        btn += "x";
                        xActivo = true;
                        puntoActivo = true;
                    }
                    break;
                case R.id.btnY:
                    if(!igualCActivo){
                        btn += "=";
                        igualCActivo = true;
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
                    xActivo = false;
                    break;
                case R.id.btnResta:
                    btn += "-";
                    xActivo = false;
                    break;
                case R.id.btnMultiplicar:
                    btn += "*";
                    xActivo = false;
                    break;
                case R.id.btnDivision:
                    btn += "/";
                    xActivo = false;
                    break;
                case R.id.btnPotencia:
                    btn += "^";
                    break;
                case R.id.btnIgual:
                    btn = resolver(btn);
                    igualActivo = true;
                    break;
            }
            escribir(btn);
        } catch (Exception e) {
            pantalla.setText("Error");
        }
    }

    public String resolver(String c){
        operacionEnviar = c;
        Conexion con = new Conexion(getApplicationContext(),"historial3.sqlite",null,1);
        SQLiteDatabase db = con.getWritableDatabase();
        String sql = "insert into operaciones (tipo,operacion,resultado) values ('Ecuación: ','"+ c +"','"+ transponer(c) +"')";
        db.execSQL(sql);
        db.close();
        return transponer(c);
    }

    private String transponer(String s){
        String a = "";
        String b = "";
        String c = "";
        boolean aOn = true;
        boolean bOn = false;
        boolean cOn = false;

        for(int i=0; i<s.length(); i++){

            if(aOn){
                if(!a.isEmpty() && esOperador(s.charAt(i))){
                    bOn = true;
                    cOn = false;
                    aOn = false;
                }else {
                    a += s.charAt(i);
                }
            }
            if(bOn) {
                if(!b.isEmpty() && esOperador(s.charAt(i))){
                    cOn = true;
                    aOn = false;
                    bOn = false;
                }else {
                    b += s.charAt(i);
                }
            }
            if(cOn){
                c += s.charAt(i);
            }
        }
        a = (a.charAt(0)=='+')?a.substring(1):a;
        b = (b.charAt(0)=='+')?b.substring(1):b;
        c = (c.charAt(0)=='+')?c.substring(1):c;

        return calcular(extraerNumero(a),extraerNumero(b),extraerNumero(c));
    }

    private Double extraerNumero(String c){
        String x = "";
        for(int i=0; i<c.length(); i++){
            if(!(c.charAt(i)=='x') && !(c.charAt(i)=='y')){
               x += c.charAt(i);
            }else{
                break;
            }
        }
        return Double.parseDouble(x);
    }

    private String calcular(double a, double b, double c){
        aEnviar = a;
        bEnviar = b;
        cEnviar = c;

        double r1 = ((-1*b) + (Math.sqrt((Math.pow(b,2))+4*(a*c))))/2*a;
        double r2 = ((-1*b) - (Math.sqrt((Math.pow(b,2))+4*(a*c))))/2*a;

        return "x="+disminuirDecimales(String.valueOf(r1))+"  x="+disminuirDecimales(String.valueOf(r2));
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

    private boolean esOperador(char c){return c=='-' || c=='+' || c=='*' || c=='/';}
}
