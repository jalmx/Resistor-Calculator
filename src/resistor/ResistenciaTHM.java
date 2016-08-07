/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resistor;

import java.math.BigDecimal;

/**
 *
 * @author JOSEF
 */
public class ResistenciaTHM {

    private String valorResistivo;
    private String toleranciaMax;
    private String toleranciaMin;
    private int prefijo;
    public boolean RANGO;
    private double r;
    private boolean edo;

    /**
     * return el valor de la resistencia en String sin importar sea tipo <b> Int
     * </b> o <b> Double </b>
     *
     * @return
     */
    public String getValoreResitivo() {
        return valorResistivo;
    }

    /**
     * retorna el valor de la tolerancia maxima
     *
     * @return
     */
    public String getToleranciaMax() {
        return toleranciaMax;
    }

    /**
     * rerorna el valor de la tolerancia minima
     *
     * @return
     */
    public String getToleranciaMin() {
        return toleranciaMin;
    }

    /**
     * funcion para calcular el valor de la resistencia, recibe la banda 1,
     * banda2, banda 3 y la tolerancia de los index de la lista respectivamente
     *
     * @param dig1
     * @param dig2
     * @param mult
     * @param tolerancia
     */
    public void valorResistivo(int dig1, int dig2, int mult, int tolerancia) { // recibe los index de la lista
        //multiplo oro y plata son index 8 y 9 por lo tanto si es => 1 sera dobule
        int union = acoplar(this.digito(dig1), this.digito(dig2));//junto los digitos para despues multiplicarlo por el multiplo y lo regresa junto
        double multi = this.multiplo(mult);//paso el valor del color para ver su valor
        double resultadoD = union * multi;  //obtengo el valor de la resistencia

        if (resultadoD <= 10000000) {//sobrepasa 1M
            RANGO = true;   //es dentro del rango
            double resultadoD1 = this.division(this.prefijo(resultadoD), resultadoD);//le paso lo que entre que valor lo va a dividir y 
            //me regresa el resultado dividido
            double x = resultadoD1;  //verifico el tipo de resultado
            int y = (int) resultadoD1;// sí sera con punto flotante o entero
            double w = x - y;
            if (w > 0) { //el resultado es flotante
                tolerancia(tolerancia, resultadoD1); //procesa el resulado de la tolerancia de la resistencia
                valorResistivo = String.valueOf(resultadoD1);   //paso el flotante en String
            }
            if (w == 0) {//si el resultado es entero
                tolerancia(tolerancia, resultadoD1); //procesa el resulado de la tolerancia de la resistencia
                valorResistivo = String.valueOf((int) resultadoD1);//paso el Int a String
            }
        } else {
            RANGO = false; //fuera de rango
        }
    }

    /**
     *
     * recibe las cuatro bandas de la resistencia con todo y la tolerancia
     *
     * @param dig1
     * @param dig2
     * @param dig3
     * @param mult
     * @param tolerancia
     */
    public void valorResistivo(int dig1, int dig2, int dig3, int mult, int tolerancia) {

       int union = acoplar(this.digito(dig1), this.digito(dig2), this.digito(dig3));//junto los digitos para despues multiplicarlo por el multiplo y lo regresa junto
        double multi = this.multiplo(mult);//paso el valor del color para ver su valor
        double resultadoD = union * multi;  //obtengo el valor de la resistencia

        if (resultadoD <= 10000000) {//sobrepasa 1M
            RANGO = true;   //es dentro del rango
            double resultadoD1 = this.division(this.prefijo(resultadoD), resultadoD);//le paso lo que entre que valor lo va a dividir y 
            //me regresa el resultado dividido
            double x = resultadoD1;  //verifico el tipo de resultado
            int y = (int) resultadoD1;// sí sera con punto flotante o entero
            double w = x - y;
            if (w > 0) { //el resultado es flotante
                tolerancia(tolerancia, resultadoD1); //procesa el resulado de la tolerancia de la resistencia
                valorResistivo = String.valueOf(resultadoD1);   //paso el flotante en String
            }
            if (w == 0) {//si el resultado es entero
                tolerancia(tolerancia, resultadoD1); //procesa el resulado de la tolerancia de la resistencia
                valorResistivo = String.valueOf((int) resultadoD1);//paso el Int a String
            }
        } else {
            RANGO = false; //fuera de rango
        }
    }

    /**
     * esta funcion une los digitos que recibe, y los devuelve juntos o
     * acoplados
     *
     * @param x
     * @param y
     * @return
     */
    protected int acoplar(int x, int y) {// recibe el digito uno y dos y regresa el digito completo

        String primero = String.valueOf(x);
        String segundo = String.valueOf(y);

        return Integer.parseInt(primero + segundo);
    }

    /**
     * acopla las tres primeras bandas como si fuera una sola cifra, cuando la
     * resistencia tiene 4 bandas en su cuerpo
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    protected int acoplar(int x, int y, int z) {// recibe el digito uno y dos y regresa el digito completo

        String primero = String.valueOf(x);
        String segundo = String.valueOf(y);
        String tercero = String.valueOf(z);

        return Integer.parseInt(primero + segundo + tercero);
    }

    /**
     * retorna el valor a cual equivale el color de negro a blanco
     *
     * @param digito
     * @return
     */
    private int digito(int digito) {//entrega el valor que le corresponde a cada color

        int variable = 0;

        switch (digito) {
            case 0:
                variable = 0;    //negro
                break;
            case 1:
                variable = 1;    //cafe
                break;
            case 2:
                variable = 2;    //rojo
                break;
            case 3:
                variable = 3;    //naranja
                break;
            case 4:
                variable = 4;    //amarillo
                break;
            case 5:
                variable = 5;    //verde
                break;
            case 6:
                variable = 6;    //azul
                break;
            case 7:
                variable = 7;    //violeta
                break;
            case 8:
                variable = 8;    //gris
                break;
            case 9:
                variable = 9;    //blanco
                break;
        }
        return variable;
    }

    /**
     * retorna el valor del multiplo de cada color
     *
     * @param multiplo
     * @return
     */
    private double multiplo(int multiplo) {//entraga el valor que le corresponde a cada multiplo

        double variable = 0;

        switch (multiplo) {
            case 0:
                variable = 1;    //negro
                break;
            case 1:
                variable = 10;    //cafe
                break;
            case 2:
                variable = 100;    //rojo
                break;
            case 3:
                variable = 1000;    //naranja
                break;
            case 4:
                variable = 10000;    //amarillo
                break;
            case 5:
                variable = 100000;    //verde
                break;
            case 6:
                variable = 1000000;    //azul
                break;
            case 7:
                variable = 10000000;    //violeta
                break;
            case 8:
                variable = 0.1;    //oro
                break;
            case 9:
                variable = 0.01;    //plata
                break;
        }
        return variable;
    }

    /**
     * retorna el valor equivalente a la tolerancia de cada color dorado = 10%
     * plata = 5% cafe = 1% rojo = 2% verde = 0.5% azul = 0.25% violeta = 0.1%
     *
     * @param tolerancia
     * @return
     */
    private double valorToleranciaAsignacion(int tolerancia) {

        double variable = 0;

        switch (tolerancia) {
            case 0:
                variable = 0.10;    //dorado 10%
                break;
            case 1:
                variable = 0.05;    //plata 5%
                break;
            case 2:
                variable = 0.01;    //cafe 1%
                break;
            case 3:
                variable = 0.02;    //rojo 2%
                break;
            case 4:
                variable = 0.005;    //verde .5%
                break;
            case 5:
                variable = 0.0025;    //azul .25%
                break;
            case 6:
                variable = 0.001;    //violeta .1%
                break;
        }

        return variable;
    }

    /**
     * recibe el valor de tolerancia designado y el valor resisitivo, de ahi
     * calcula el valor de tolerancia maximo y minimo
     *
     * @param tolerancia
     * @param r
     */
    private void tolerancia(int tolerancia, double r) {

        String p = this.StringOhm(this.getPrefijo());//me devuelve el prefijo del Ohm
        double t = valorToleranciaAsignacion(tolerancia);// me entrega el valor de tolerancia        
        this.r = r * t; //obtengo el porcentaje que debe tener ya sea de mas o de menos la resistencia

        double maxR = r + this.r;
        double minR = r - this.r;

        double x = maxR;  //verifico el tipo de resultado
        int y = (int) maxR;// sí sera con punto flotante o entero
        double w = x - y;

        if (w > 0) { //el resultado es flotante
            toleranciaMax = String.format("%.2f ", maxR) + p;
            toleranciaMin = String.format("%.2f ", minR) + p;
        }
        if (w == 0) {//si el resultado es entero
            toleranciaMax = String.format("%.0f ", maxR) + p;
            toleranciaMin = String.format("%.0f ", minR) + p;
        }
    }

    private String StringOhm(int o) {

        switch (o) {
            case 0:
                return "mΩ";    //dorado 10%
            case 1:
                return "Ω";    //plata 5%
            case 2:
                return "kΩ";    //cafe 1%
            case 3:
                return "MΩ";    //rojo 2%
        }
        return null;
    }

    /**
     * retorna el valor de equivalente de la tolerancia en String, oro = 10%,
     * plata = 5% cafe = 1%, verde = 0.5%, azul = 0.25%, violeta = 0.1
     *
     * @param tolerancia
     * @return
     */
    public String valorTolerancia(int tolerancia) {// este valor lo regresa para plasmarlo en el JFrame y saber el valor de tolerancia seleccionado

        switch (tolerancia) {
            case 0:
                return String.valueOf(10);    //dorado 10%
            case 1:
                return String.valueOf(5);    //plata 5%
            case 2:
                return String.valueOf(1);    //cafe 1%
            case 3:
                return String.valueOf(2);    //rojo 2%
            case 4:
                return String.valueOf(0.5);    //verde .5%
            case 5:
                return String.valueOf(0.25);    //azul .25%
            case 6:
                return String.valueOf(0.1);    //violeta .1%
        }
        return null;
    }

    /**
     * recibe el valor de la resistencia y retorna que tipo es, miliOhms = 0
     * Ohms = 1 kiloOhms = 2 MegaOhms = 3 fuera de rango = -1
     *
     * @param r
     * @return
     */
    private int prefijo(double r) {//retorno el prefijo mas combeniente

        if (r > 0 && r < 1) {//mOhms
            return prefijo = 0;
        }

        if (r >= 1 && r < 1000) {//Ohms
            return prefijo = 1;
        }

        if (r >= 1000 && r < 1000000) {  //kOhms
            return prefijo = 2;
        }

        if (r >= 1000000 && r <= 10000000) {  //MOhms
            return prefijo = 3;
        }
        return -1;
    }

    /**
     * retorna el resultado del valor resisitivo divido ya sea entre 100, 1, 1k,
     * 1M
     *
     * @param valorOhm
     * @param resistencia
     * @return
     */
    private double division(int valorOhm, double resistencia) {

        switch (valorOhm) {
            case 0:
                return resistencia * 100; //mOhms
            case 1:
                return resistencia;       //ohms
            case 2:
                return resistencia / 1000.0;  //kOhms
            case 3:
                return resistencia / 1.0E6;//Mohms
        }
        return -1;
    }// 

    /**
     * devuelve el valor del prefijo mas combeniente
     * <b> mOhms = 0 Ohms = 1 kiloOhms = 2 MegaOhms = 3 ninguno = -1 </b>
     *
     * @return
     */
    public int getPrefijo() {
        return prefijo;
    }
}
