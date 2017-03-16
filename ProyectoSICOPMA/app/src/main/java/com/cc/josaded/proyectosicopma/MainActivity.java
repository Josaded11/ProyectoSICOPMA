package com.cc.josaded.proyectosicopma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by Josaded on 12/02/2017.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private BeanOperacion bo;
    private EditText pantalla;
    private TextView h,op;
    private double op1,op2 = 0;
    private Button cero,uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,punto,borrar,reiniciar,igual,sumar,restar,dividir,multiplicar,raiz,potencia,porcentaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bo = new BeanOperacion();

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
                Intent irPasos = new Intent(MainActivity.this, PasosActivity.class);
                irPasos.putExtra("pasos", bo.getPasosMostrar());

                irPasos.putExtra("suma", bo.isSuma());
                irPasos.putExtra("resta", bo.isResta());
                irPasos.putExtra("multi", bo.isMultiplicacion());
                irPasos.putExtra("div", bo.isDivision());
                irPasos.putExtra("pot", bo.isPotencia());
                irPasos.putExtra("por", bo.isPorcentaje());
                irPasos.putExtra("raiz", bo.isRaiz());

                irPasos.putExtra("resultado", bo.getHistorial());
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
                    if (bo.isIgualUsado()){
                        bo.setBtn("0");
                        bo.setHistorial(bo.getBtn());
                        bo.setPuntoUsado(false);
                        bo.setIgualUsado(false);
                        bo.desactivarOperadores();
                        op.setText("");
                    }else{
                        bo.setBtn(bo.getBtn()+"0");
                        bo.setHistorial(bo.getHistorial() + "0");
                    }
                    break;
                case R.id.btnUno:
                    if (bo.isIgualUsado()){
                        bo.setBtn("1");
                        bo.setHistorial(bo.getBtn());
                        bo.setPuntoUsado(false);
                        bo.setIgualUsado(false);
                        bo.desactivarOperadores();
                        op.setText("");
                    }else{
                        bo.setBtn(bo.getBtn()+"1");
                        bo.setHistorial(bo.getHistorial() + "1");
                    }
                    break;
                case R.id.btnDos:
                    if (bo.isIgualUsado()){
                        bo.setBtn("2");
                        bo.setHistorial(bo.getBtn());
                        bo.setPuntoUsado(false);
                        bo.setIgualUsado(false);
                        bo.desactivarOperadores();
                        op.setText("");
                    }else{
                        bo.setBtn(bo.getBtn()+"2");
                        bo.setHistorial(bo.getHistorial() + "2");
                    }
                    break;
                case R.id.btnTres:
                    if (bo.isIgualUsado()){
                        bo.setBtn("3");
                        bo.setHistorial(bo.getBtn());
                        bo.setPuntoUsado(false);
                        bo.setIgualUsado(false);
                        bo.desactivarOperadores();
                        op.setText("");
                    }else{
                        bo.setBtn(bo.getBtn()+"3");
                        bo.setHistorial(bo.getHistorial() + "3");
                    }
                    break;
                case R.id.btnCuatro:
                    if (bo.isIgualUsado()){
                        bo.setBtn("4");
                        bo.setHistorial(bo.getBtn());
                        bo.setPuntoUsado(false);
                        bo.setIgualUsado(false);
                        bo.desactivarOperadores();
                        op.setText("");
                    }else{
                        bo.setBtn(bo.getBtn()+"4");
                        bo.setHistorial(bo.getHistorial() + "4");
                    }
                    break;
                case R.id.btnCinco:
                    if (bo.isIgualUsado()){
                        bo.setBtn("5");
                        bo.setHistorial(bo.getBtn());
                        bo.setPuntoUsado(false);
                        bo.setIgualUsado(false);
                        bo.desactivarOperadores();
                        op.setText("");
                    }else{
                        bo.setBtn(bo.getBtn()+"5");
                        bo.setHistorial(bo.getHistorial() + "5");
                    }
                    break;
                case R.id.btnSeis:
                    if (bo.isIgualUsado()){
                        bo.setBtn("6");
                        bo.setHistorial(bo.getBtn());
                        bo.setPuntoUsado(false);
                        bo.setIgualUsado(false);
                        bo.desactivarOperadores();
                        op.setText("");
                    }else{
                        bo.setBtn(bo.getBtn()+"6");
                        bo.setHistorial(bo.getHistorial() + "6");
                    }
                    break;
                case R.id.btnSiete:
                    if (bo.isIgualUsado()){
                        bo.setBtn("7");
                        bo.setHistorial(bo.getBtn());
                        bo.setPuntoUsado(false);
                        bo.setIgualUsado(false);
                        bo.desactivarOperadores();
                        op.setText("");
                    }else{
                        bo.setBtn(bo.getBtn()+"7");
                        bo.setHistorial(bo.getHistorial() + "7");
                    }
                    break;
                case R.id.btnOcho:
                    if (bo.isIgualUsado()){
                        bo.setBtn("8");
                        bo.setHistorial(bo.getBtn());
                        bo.setPuntoUsado(false);
                        bo.setIgualUsado(false);
                        bo.desactivarOperadores();
                        op.setText("");
                    }else{
                        bo.setBtn(bo.getBtn()+"8");
                        bo.setHistorial(bo.getHistorial() + "8");
                    }
                    break;
                case R.id.btnNueve:
                    if (bo.isIgualUsado()){
                        bo.setBtn("9");
                        bo.setHistorial(bo.getBtn());
                        bo.setPuntoUsado(false);
                        bo.setIgualUsado(false);
                        bo.desactivarOperadores();
                        op.setText("");
                    }else{
                        bo.setBtn(bo.getBtn()+"9");
                        bo.setHistorial(bo.getHistorial() + "9");
                    }
                    break;
                //CONDICIÓN EXTRAS:
                case R.id.btnPunto:
                    if (bo.getBtn().isEmpty()){
                        if (!bo.isPuntoUsado()){
                            bo.setBtn("0.");
                            bo.setHistorial(bo.getHistorial()+"0.");
                            bo.setPuntoUsado(true);
                        }
                    }else{
                        if (!bo.isPuntoUsado()){
                            bo.setBtn(bo.getBtn()+".");
                            bo.setHistorial(bo.getHistorial()+".");
                            bo.setPuntoUsado(true);
                        }
                    }

                    if (bo.isIgualUsado()){
                        bo.setHistorial(bo.getBtn());
                        bo.setPuntoUsado(true);
                        bo.desactivarOperadores();
                        op.setText("");
                    }
                    break;
                case R.id.btnBorrar:
                    if (!bo.getBtn().isEmpty()){
                        if (bo.getBtn().charAt(bo.getBtn().length()-1)=='.'){
                            bo.setPuntoUsado(false);
                        }
                        bo.setBtn(bo.getBtn().substring(0,bo.getBtn().length()-1));
                        bo.setHistorial(bo.getHistorial().substring(0,bo.getHistorial().length()-1));
                    }
                    break;
                case R.id.btnReiniciar:
                    bo.setBtn("");
                    bo.setHistorial("");
                    bo.setPuntoUsado(false);
                    bo.setIgualUsado(false);
                    bo.desactivarOperadores();
                    op.setText("");
                    h.setText("");
                    break;
                //CONDICIÓN OPERADORES:
                case R.id.btnSuma:
                    if (bo.esOperador() && !bo.isIgualUsado()){
                        bo.setOp2(Double.parseDouble(bo.getBtn()));
                        bo.calcular();
                    }else{
                        bo.setOp1(Double.parseDouble(bo.getBtn()));
                    }
                    bo.setHistorial(bo.getHistorial() + "+");
                    op.setText("+");
                    bo.setBtn("");
                    bo.setIgualUsado(false);
                    bo.setPuntoUsado(false);
                    bo.desactivarOperadores();
                    bo.setSuma(true);
                    break;
                case R.id.btnResta:
                    if (bo.esOperador() && !bo.isIgualUsado()){
                        bo.setOp2(Double.parseDouble(bo.getBtn()));
                        bo.calcular();
                    }else{
                        bo.setOp1(Double.parseDouble(bo.getBtn()));
                    }
                    bo.setHistorial(bo.getHistorial() + "-");
                    op.setText("-");
                    bo.setBtn("");
                    bo.setIgualUsado(false);
                    bo.setPuntoUsado(false);
                    bo.desactivarOperadores();
                    bo.setResta(true);
                    break;
                case R.id.btnMultiplicar:
                    if (bo.esOperador() && !bo.isIgualUsado()){
                        bo.setOp2(Double.parseDouble(bo.getBtn()));
                        bo.calcular();
                    }else{
                        bo.setOp1(Double.parseDouble(bo.getBtn()));
                    }
                    bo.setHistorial(bo.getHistorial() + "*");
                    op.setText("*");
                    bo.setBtn("");
                    bo.setIgualUsado(false);
                    bo.setPuntoUsado(false);
                    bo.desactivarOperadores();
                    bo.setMultiplicacion(true);
                    break;
                case R.id.btnDivision:
                    if (bo.esOperador() && !bo.isIgualUsado()){
                        bo.setOp2(Double.parseDouble(bo.getBtn()));
                        bo.calcular();
                    }else{
                        bo.setOp1(Double.parseDouble(bo.getBtn()));
                    }
                    bo.setHistorial(bo.getHistorial() + "/");
                    op.setText("/");
                    bo.setBtn("");
                    bo.setIgualUsado(false);
                    bo.setPuntoUsado(false);
                    bo.desactivarOperadores();
                    bo.setDivision(true);
                    break;
                case R.id.btnPotencia:
                    if (bo.esOperador()){
                        if (bo.getBtn().equals("")){
                            bo.setOp2(0);
                        }else{
                            bo.setOp2(Double.parseDouble(bo.getBtn()));
                        }
                        bo.calcular();
                    }else{
                        bo.setOp1(Double.parseDouble(bo.getBtn()));
                    }
                    bo.setHistorial(bo.getHistorial() + "^");
                    op.setText("^");
                    bo.setBtn("");
                    bo.setIgualUsado(false);
                    bo.setPuntoUsado(false);
                    bo.desactivarOperadores();
                    bo.setPotencia(true);
                    break;
                case R.id.btnRaiz:
                    if (bo.esOperador()){
                        if (bo.getBtn().equals("")){
                            bo.setOp2(0);
                        }else{
                            bo.setOp2(Double.parseDouble(bo.getBtn()));
                        }
                        bo.calcular();
                    }else{
                        bo.setOp1(Double.parseDouble(bo.getBtn()));
                    }
                    bo.setHistorial(bo.getHistorial() + "√");
                    op.setText("√");
                    bo.setBtn("");
                    bo.setIgualUsado(false);
                    bo.setPuntoUsado(false);
                    bo.desactivarOperadores();
                    bo.setRaiz(true);
                    break;
                case R.id.btnPorcentaje:
                    if (bo.esOperador()){
                        if (bo.getBtn().equals("")){
                            bo.setOp2(0);
                        }else{
                            bo.setOp2(Double.parseDouble(bo.getBtn()));
                        }
                        bo.calcular();
                    }else{
                        bo.setOp1(Double.parseDouble(bo.getBtn()));
                    }
                    bo.setHistorial(bo.getHistorial() + "%");
                    op.setText("%");
                    bo.setBtn("");
                    bo.setIgualUsado(false);
                    bo.setPuntoUsado(false);
                    bo.desactivarOperadores();
                    bo.setPorcentaje(true);
                    break;
                case R.id.btnIgual:
                    if (bo.getBtn().equals("")){
                        bo.setOp2(0);
                    }else{
                        bo.setOp2(Double.parseDouble(bo.getBtn()));
                    }
                    bo.calcular();
                    bo.setResultado(0);
                    bo.setIgualUsado(true);
                    bo.setPuntoUsado(false);
                    break;
            }
            pantalla.setText(bo.getBtn());
            h.setText(bo.getHistorial());
        } catch (Exception e) {
            pantalla.setText("Error");
        }
    }


}


