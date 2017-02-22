package com.cc.josaded.proyectosicopma;

import java.io.Serializable;

/**
 * Created by Josaded on 17/02/2017.
 */

public class BeanOperacion implements Serializable {

    private String historial, btn, pasosMostrar;
    private double op1, op2, resultado;
    private boolean igualUsado, puntoUsado;
    private boolean suma, resta, division, multiplicacion, potencia, raiz, porcentaje;

    public BeanOperacion() {
        this.pasosMostrar = "";
        this.historial = "";
        this.btn = "";
        this.igualUsado = false;
        this.puntoUsado = false;
        this.op1 = 0;
        this.op2 = 0;
        this.resultado = 0;
        this.suma = false;
        this.resta = false;
        this.division = false;
        this.multiplicacion = false;
        this.potencia = false;
        this.raiz = false;
        this.porcentaje = false;
    }

    //MÉTODOS:
    public void calcular () {
        if (isSuma() == true){setResultado(getOp1() + getOp2());}
        if (isResta() == true){setResultado(getOp1() - getOp2());}
        if (isMultiplicacion() == true){setResultado(getOp1() * getOp2());}
        if (isDivision() == true){setResultado(getOp1() / getOp2());}
        if (isPotencia() == true){setResultado(Math.pow(getOp1(),getOp2()));}
        if (isRaiz() == true){
            if (op2 == 0){
                setResultado(Math.sqrt(getOp1()));
            }else{
                setResultado(getOp1() * Math.sqrt(getOp2()));
            }
        }
        if (isPorcentaje() == true){
            if (op2 == 0){
                setResultado(getOp1() / 100);
            }else{
                setResultado((getOp1() * 100) / getOp2());
            }
        }
        setPasosMostrar(getHistorial());
        setBtn(String.valueOf(getResultado()));
        setOp1(getResultado());
        setHistorial(getBtn());
    }

    public boolean esOperador(){
        return suma==true||resta==true||division==true||multiplicacion==true||raiz==true||porcentaje==true||potencia==true;
    }

    public boolean esDecimal(char c){
        return (c >= '0' && c <= '9') || c =='.';
    }

    public void desactivarOperadores(){
        setSuma(false);
        setResta(false);
        setMultiplicacion(false);
        setDivision(false);
        setPotencia(false);
        setRaiz(false);
        setPorcentaje(false);
    }

    //GETTERS Y SETTERS:
    public String getHistorial() {
        return historial;
    }

    public void setHistorial(String historial) {
        this.historial = historial;
    }

    public String getBtn() {
        return btn;
    }

    public void setBtn(String btn) {
        this.btn = btn;
    }

    public double getOp1() {
        return op1;
    }

    public void setOp1(double op1) {
        this.op1 = op1;
    }

    public double getOp2() {
        return op2;
    }

    public void setOp2(double op2) {
        this.op2 = op2;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public boolean isIgualUsado() {
        return igualUsado;
    }

    public void setIgualUsado(boolean igualUsado) {
        this.igualUsado = igualUsado;
    }

    public boolean isPuntoUsado() {
        return puntoUsado;
    }

    public void setPuntoUsado(boolean puntoUsado) {
        this.puntoUsado = puntoUsado;
    }

    public boolean isSuma() {
        return suma;
    }

    public void setSuma(boolean suma) {
        this.suma = suma;
    }

    public boolean isResta() {
        return resta;
    }

    public void setResta(boolean resta) {
        this.resta = resta;
    }

    public boolean isDivision() {
        return division;
    }

    public void setDivision(boolean division) {
        this.division = division;
    }

    public boolean isMultiplicacion() {
        return multiplicacion;
    }

    public void setMultiplicacion(boolean multiplicacion) {
        this.multiplicacion = multiplicacion;
    }

    public boolean isPotencia() {
        return potencia;
    }

    public void setPotencia(boolean potencia) {
        this.potencia = potencia;
    }

    public boolean isRaiz() {
        return raiz;
    }

    public void setRaiz(boolean raiz) {
        this.raiz = raiz;
    }

    public boolean isPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(boolean porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getPasosMostrar() {
        return pasosMostrar;
    }

    public void setPasosMostrar(String pasosMostrar) {
        this.pasosMostrar = pasosMostrar;
    }
}
