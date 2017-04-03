package com.cc.josaded.proyectosicopma;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

/**
 * Created by Josaded on 12/02/2017.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText pantalla;
    private TextView h,op;
    private Button cero,uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,punto,borrar,reiniciar,igual,sumar,restar,dividir,multiplicar,raiz,potencia,porcentaje;

    private String historial, btn, pasosMostrar;
    private double op1, op2, resultado;
    private boolean igualUsado, puntoUsado;
    private boolean isSuma, isResta, isDivision, isMultiplicacion, isPotencia, isRaiz, isPorcentaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pasosMostrar = "";
        historial = "";
        btn = "";
        igualUsado = false;
        puntoUsado = false;
        op1 = 0;
        op2 = 0;
        resultado = 0;
        isSuma = false;
        isResta = false;
        isDivision = false;
        isMultiplicacion = false;
        isPotencia = false;
        isRaiz = false;
        isPorcentaje = false;

        RadioButton rDerivada = (RadioButton) findViewById(R.id.rbDerivadas);
        rDerivada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(MainActivity.this, DerivadaActivity.class);
                startActivity(e);
                finish();
            }
        });
        RadioButton rIntegral = (RadioButton) findViewById(R.id.rbIntegrales);
        rIntegral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(MainActivity.this, IntegralActivity.class);
                startActivity(e);
                finish();
            }
        });
        RadioButton rEcuacion = (RadioButton) findViewById(R.id.rbEcuaciones);
        rEcuacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(MainActivity.this, EcuacionActivity.class);
                startActivity(e);
                finish();
            }
        });

        Button next = (Button) findViewById(R.id.btnPasos);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (igualUsado){
                    Intent irPasos = new Intent(MainActivity.this, PasosActivity.class);
                    irPasos.putExtra("pasos", pasosMostrar);

                    irPasos.putExtra("suma", isSuma);
                    irPasos.putExtra("resta", isResta);
                    irPasos.putExtra("multi", isMultiplicacion);
                    irPasos.putExtra("div", isDivision);
                    irPasos.putExtra("pot", isPotencia);
                    irPasos.putExtra("por", isPorcentaje);
                    irPasos.putExtra("raiz", isRaiz);

                    irPasos.putExtra("resultado", historial);
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
                Intent irPasos = new Intent(MainActivity.this, HistorialActivity.class);
                startActivity(irPasos);
            }
        });

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
        porcentaje = (Button) findViewById(R.id.btnPorcentaje);
        porcentaje.setOnClickListener(this);
        potencia = (Button) findViewById(R.id.btnPotencia);
        potencia.setOnClickListener(this);
        raiz = (Button) findViewById(R.id.btnRaiz);
        raiz.setOnClickListener(this);
        //EXTRAS:
        punto = (Button) findViewById(R.id.btnPunto);
        punto.setOnClickListener(this);
        borrar = (Button) findViewById(R.id.btnBorrar);
        borrar.setOnClickListener(this);
        reiniciar = (Button) findViewById(R.id.btnReiniciar);
        reiniciar.setOnClickListener(this);
        igual = (Button) findViewById(R.id.btnIgual);
        igual.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        op = (TextView) findViewById(R.id.tvOperador);
        h = (TextView) findViewById(R.id.tvHistorial);
        pantalla = (EditText) findViewById(R.id.etPantallaResultado);

        try {
            switch (v.getId()){
                //CONDICIÓN NÚMEROS:
                case R.id.btnCero:
                    if (igualUsado){
                        btn = "0";
                        historial = btn;
                        puntoUsado = false;
                        igualUsado = false;
                        desactivarOperadores();
                        op.setText("");
                    }else{
                        btn = btn+"0";
                        historial = historial + "0";
                    }
                    break;
                case R.id.btnUno:
                    if (igualUsado){
                        btn = "1";
                        historial = btn;
                        puntoUsado = false;
                        igualUsado = false;
                        desactivarOperadores();
                        op.setText("");
                    }else{
                        btn = btn+"1";
                        historial = historial + "1";
                    }
                    break;
                case R.id.btnDos:
                    if (igualUsado){
                        btn = "2";
                        historial = btn;
                        puntoUsado = false;
                        igualUsado = false;
                        desactivarOperadores();
                        op.setText("");
                    }else{
                        btn = btn+"2";
                        historial = historial + "2";
                    }
                    break;
                case R.id.btnTres:
                    if (igualUsado){
                        btn = "3";
                        historial = btn;
                        puntoUsado = false;
                        igualUsado = false;
                        desactivarOperadores();
                        op.setText("");
                    }else{
                        btn = btn+"3";
                        historial = historial + "3";
                    }
                    break;
                case R.id.btnCuatro:
                    if (igualUsado){
                        btn = "4";
                        historial = btn;
                        puntoUsado = false;
                        igualUsado = false;
                        desactivarOperadores();
                        op.setText("");
                    }else{
                        btn = btn+"4";
                        historial = historial + "4";
                    }
                    break;
                case R.id.btnCinco:
                    if (igualUsado){
                        btn = "5";
                        historial = btn;
                        puntoUsado = false;
                        igualUsado = false;
                        desactivarOperadores();
                        op.setText("");
                    }else{
                        btn = btn+"5";
                        historial = historial + "5";
                    }
                    break;
                case R.id.btnSeis:
                    if (igualUsado){
                        btn = "6";
                        historial = btn;
                        puntoUsado = false;
                        igualUsado = false;
                        desactivarOperadores();
                        op.setText("");
                    }else{
                        btn = btn+"6";
                        historial = historial + "6";
                    }
                    break;
                case R.id.btnSiete:
                    if (igualUsado){
                        btn = "7";
                        historial = btn;
                        puntoUsado = false;
                        igualUsado = false;
                        desactivarOperadores();
                        op.setText("");
                    }else{
                        btn = btn+"7";
                        historial = historial + "7";
                    }
                    break;
                case R.id.btnOcho:
                    if (igualUsado){
                        btn = "8";
                        historial = btn;
                        puntoUsado = false;
                        igualUsado = false;
                        desactivarOperadores();
                        op.setText("");
                    }else{
                        btn = btn+"8";
                        historial = historial + "8";
                    }
                    break;
                case R.id.btnNueve:
                    if (igualUsado){
                        btn = "9";
                        historial = btn;
                        puntoUsado = false;
                        igualUsado = false;
                        desactivarOperadores();
                        op.setText("");
                    }else{
                        btn = btn+"9";
                        historial = historial + "9";
                    }
                    break;
                //CONDICIÓN EXTRAS:
                case R.id.btnPunto:
                    if (btn.isEmpty()){
                        if (!puntoUsado){
                            btn = "0.";
                            historial = historial+"0.";
                            puntoUsado = true;
                        }
                    }else{
                        if (!puntoUsado){
                            btn = btn +".";
                            historial = historial + ".";
                            puntoUsado = true;
                        }
                    }

                    if (igualUsado){
                        historial = btn;
                        puntoUsado = true;
                        desactivarOperadores();
                        op.setText("");
                    }
                    break;
                case R.id.btnBorrar:
                    if (!btn.isEmpty()){
                        if (btn.charAt(btn.length()-1)=='.'){
                            puntoUsado = false;
                        }
                        btn = btn.substring(0,btn.length()-1);
                        historial = historial.substring(0,historial.length()-1);
                    }
                    break;
                case R.id.btnReiniciar:
                    btn = "";
                    historial = "";
                    puntoUsado = false;
                    igualUsado = false;
                    desactivarOperadores();
                    op.setText("");
                    h.setText("");
                    break;
                //CONDICIÓN OPERADORES:
                case R.id.btnSuma:
                    if (esOperador() && !igualUsado){
                        op2 = Double.parseDouble(btn);
                        calcular();
                    }else{
                        op1 = Double.parseDouble(btn);
                    }
                    historial = historial + "+";
                    op.setText("+");
                    btn = "";
                    igualUsado = false;
                    puntoUsado = false;
                    desactivarOperadores();
                    isSuma = true;
                    break;
                case R.id.btnResta:
                    if (esOperador() && !igualUsado){
                        op2 = Double.parseDouble(btn);
                        calcular();
                    }else{
                        op1 = Double.parseDouble(btn);
                    }
                    historial = historial + "-";
                    op.setText("-");
                    btn = "";
                    igualUsado = false;
                    puntoUsado = false;
                    desactivarOperadores();
                    isResta = true;
                    break;
                case R.id.btnMultiplicar:
                    if (esOperador() && !igualUsado){
                        op2 = Double.parseDouble(btn);
                        calcular();
                    }else{
                        op1 = Double.parseDouble(btn);
                    }
                    historial = historial + "*";
                    op.setText("*");
                    btn = "";
                    igualUsado = false;
                    puntoUsado = false;
                    desactivarOperadores();
                    isMultiplicacion = true;
                    break;
                case R.id.btnDivision:
                    if (esOperador() && !igualUsado){
                        op2 = Double.parseDouble(btn);
                        calcular();
                    }else{
                        op1 = Double.parseDouble(btn);
                    }
                    historial = historial + "/";
                    op.setText("/");
                    btn = "";
                    igualUsado = false;
                    puntoUsado = false;
                    desactivarOperadores();
                    isDivision = true;
                    break;
                case R.id.btnPotencia:
                    if (esOperador()){
                        if (btn.equals("")){
                            op2 = 0;
                        }else{
                            op2 = Double.parseDouble(btn);
                        }
                        calcular();
                    }else{
                        op1 = Double.parseDouble(btn);
                    }
                    historial = historial + "^";
                    op.setText("^");
                    btn = "";
                    igualUsado = false;
                    puntoUsado = false;
                    desactivarOperadores();
                    isPotencia = true;
                    break;
                case R.id.btnRaiz:
                    if (esOperador()){
                        if (btn.equals("")){
                            op2 = 0;
                        }else{
                            op2 = Double.parseDouble(btn);
                        }
                        calcular();
                    }else{
                        op1 = Double.parseDouble(btn);
                    }
                    historial = historial + "√";
                    op.setText("√");
                    btn = "";
                    igualUsado = false;
                    puntoUsado = false;
                    desactivarOperadores();
                    isRaiz = true;
                    break;
                case R.id.btnPorcentaje:
                    if (esOperador()){
                        if (btn.equals("")){
                            op2 = 0;
                        }else{
                            op2 = Double.parseDouble(btn);
                        }
                        calcular();
                    }else{
                        op1 = Double.parseDouble(btn);
                    }
                    historial = historial + "%";
                    op.setText("%");
                    btn = "";
                    igualUsado = false;
                    puntoUsado = false;
                    desactivarOperadores();
                    isPorcentaje = true;
                    break;
                case R.id.btnIgual:
                    if (btn.equals("")){
                        op2 = 0;
                    }else{
                        op2 = Double.parseDouble(btn);
                    }
                    calcular();
                    resultado = 0;
                    igualUsado = true;
                    puntoUsado = false;
                    break;
            }
            pantalla.setText(btn);
            h.setText(historial);
        } catch (Exception e) {
            pantalla.setText("Error");
        }
    }

    public void calcular () {

        Conexion con = new Conexion(getApplicationContext(),"historial3.sqlite",null,1);
        SQLiteDatabase db = con.getWritableDatabase();
        String sql = "insert into operaciones (tipo,operacion,resultado) values ";

        if (isSuma == true){resultado = op1 + op2; sql += "('Suma: ','"+ op1 + "+" + op2 + "','"+ resultado +"')";}
        if (isResta == true){resultado = op1 - op2; sql += "('Resta: ','"+ op1 + "-" + op2 + "','"+ resultado +"')";}
        if (isMultiplicacion == true){resultado = op1 * op2; sql += "('Multiplicar: ','"+ op1 + "*" + op2 + "','"+ resultado +"')";}
        if (isDivision == true){resultado = op1 / op2; sql += "('Dividir: ','"+ op1 + "/" + op2 + "','"+ resultado +"')";}
        if (isPotencia == true){
            if (op2 == 0){
                op2 = 1;
                resultado = Math.pow(op1,op2);
            }else{
                resultado = Math.pow(op1,op2);
            }
            sql += "('Potencia: ','"+ op1 + "^" + op2 + "','"+ resultado +"')";
        }
        if (isRaiz == true){
            if (op2 == 0){
                resultado = Math.sqrt(op1);
                sql += "('Raíz: ','"+ op1 + "√" + op2 + "','"+ resultado +"')";
            }else{
                resultado = op1 * Math.sqrt(op2);
                sql += "('Raíz: ','"+ op1 + "√" + op2 + "','"+ resultado +"')";
            }
        }
        if (isPorcentaje == true){
            if (op2 == 0){
                resultado = op1 / 100;
                sql += "('Porcentaje: ','"+ op1 + "%','"+ resultado +"')";
            }else{
                resultado = (op1 * 100) / op2;
                sql += "('Porcentaje: ','"+ op1 + "%" + op2 + "','"+ resultado +"')";
            }
        }
        db.execSQL(sql);
        db.close();
        pasosMostrar = historial;
        btn = String.valueOf(resultado);
        op1 = resultado;
        historial = btn;
    }

    public boolean esOperador(){
        return isSuma==true||isResta==true||isDivision==true||isMultiplicacion==true||isRaiz==true||isPorcentaje==true||isPotencia==true;
    }

    public void desactivarOperadores(){
        isSuma = false;
        isResta = false;
        isMultiplicacion = false;
        isDivision = false;
        isPotencia = false;
        isRaiz = false;
        isPorcentaje = false;
    }


}


