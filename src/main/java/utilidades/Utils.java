/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import textos.Salidas;

/**
 * Conjunto de metodos (Utils varias) para para trabajar en clase de DAM.
 *
 * @author Ar
 */
public class Utils {

    /**
     * Imprime saltos de linea para simular el efecto de limpiar la consola"cls"
     *
     * @param saltos tipo int, cantidad de saltos de linea
     */
    public static void limpiarConsola(int saltos) {
        for (int i = 0; i < saltos; i++) {
            Salidas.saltoLinea();
        }
    }

    /**
     * Imprime 50 saltos de linea para simular el efecto de limpiar la
     * consola"cls"
     */
    public static void limpiarConsola() {
        limpiarConsola(50);
    }

    /**
     * Redondea un numero double a la cantidad de decimales especificados.
     * Multiplica por 10^decimales, redondea con Math.pow y despues divide.
     * <b>limitada por valores de long. Si es superior NO redondea </b>
     *
     * @param numero numero a redondear
     * @param decimales cantidad de decimales, por defecto 2
     * @return tipo double redondeado
     */
    public static double redondearDouble(double numero, byte decimales) {
        double resultado;
        if (decimales > 9) {
            decimales = 9;
        } else if (decimales < 1) {
            decimales = 1;
        }
        int multi = (int) Math.pow(10, decimales);
        resultado = (double) Math.round(numero * multi);
        resultado /= multi;
        return resultado;
    }

    /**
     * Redondea un numero double a la dos decimales. Multiplica por 100,
     * redondea con Math.pow y despues divide.
     * <b>limitada por valores de INT </b>
     *
     * @param numero numero a redondear
     * @return tipo double redondeado a dos decimales
     */
    public static double redondearDouble(double numero) {
        return redondearDouble(numero, (byte) 2);
    }

    /**
     * Elimina espacios y guiones, y convierte en mayúsculas. Luego valida si el
     * dni introducido es correcto.
     *
     * @param dni numero de dni a instroducir
     * @return devuelve un String el Dni formateado si es correcto, o null si no
     * es correcto.
     */
    public static String validarYFormatearDni(String dni) {
        String resultado = null;

        dni = dni.trim().replace("-", "").replace(" ", "").toUpperCase();
        if (dni.length() == 9) {
            try {
                int indiceLetra = Integer.parseInt(dni.substring(0, 8)) % 23;
                String letrasDni = "TRWAGMYFPDXBNJZSQVHLCKE";
                if (dni.charAt(8) == letrasDni.charAt(indiceLetra)) {
                    resultado = dni;
                }
                //TODO falta indices
            } catch (Exception e) {

            }
        }

        return resultado;
    }

    public static String leerArchivo(File file) {
        StringBuilder text = new StringBuilder();
        if (file.exists()) {
            String line;
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(file, Charset.forName("UTF-8")));
                while ((line = br.readLine()) != null) {
                    text.append(line);
                    text.append("\n");
                }
            } catch (IOException e) {
                System.out.println("Error al abrir el archivo: " + file.getName() + " -- " + e.toString());
            } catch (Exception e) {
                System.out.println("Error al abrir en log: " + e.toString());
            } finally {
                try {
                    br.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar el flujo en log: " + e.toString());
                }
            }
        }
        return text.toString();
    }
    
    /**
     * Valida si un texto cumple el pattern indicado.
     * @param texto
     * @param pattern
     * @return boolean 
     */
    public static boolean validarString(String texto,String pattern){
         //        Pattern patron = Pattern.compile("***");
        //        Matcher comparador = patron.matcher(texto);
        //        return comparador.matches();
        //version resumida:
        return Pattern.compile(pattern).matcher(texto).matches();
    }    
}
