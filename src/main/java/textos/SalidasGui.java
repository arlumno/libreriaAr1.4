/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textos;

import javax.swing.JOptionPane;


/**
 *  Mensajes de la libreria con salida directa por consola.
 * @author Ar
 */
public class SalidasGui {
  
    /**
     *  Mensaje de error para cuando el valor está fuera del rango requerido, aunque coincida el tipo de dato
     */
    public static void errorFueraRango() {
       peticiones.SalidasGui.mensaje("Valor introducido fuera del rango requerido. ");
    }
    
    /**
     *  Mensaje de error para cuando el valor es null.
     */
    public static void errorVacio() {
        peticiones.SalidasGui.mensaje("Valor introducido no puede estár vacio.");
    }
    /**
     *  Mensaje de error para cuando el menu no tiene opciones.
     */
    public static void errorMenuVacio() {
        peticiones.SalidasGui.mensaje("Valor introducido no puede estár vacio.");
    }
    
    /**
     *  Mensaje de error para cuando se ha alcanzado un limite máximo.
     */
    public static void errorLimite() {
        peticiones.SalidasGui.mensaje("Limite máximo alcanzado.");
    }
    
    /**
     * Mensaje de error para cuando el tipo no coincide.
     */
    public static void errorTipo() {
        peticiones.SalidasGui.mensaje("Datos introducidos NO Válidos. El tipo no coincide.");
    }
    
    /**
     * Mensaje para indicar que el proceso se vuelve a repetir debido a un error previo.
     */
    public static void errorReintentarIntroducir() {
        peticiones.SalidasGui.mensaje("Vuelva a introducirlo.");
    }
    
    public static void operacionCancelada() {
        peticiones.SalidasGui.mensaje("Operación Cancelada.");
    }
    
    /**
     * Mensaje con instrucciones para volver al menú anterior.
     */
    public static void repetirMenu(){
        peticiones.SalidasGui.mensaje("\n Pulsa Enter para volver al menú.");
    }    
    public static void saltoLinea(){
        peticiones.SalidasGui.mensaje("\b");
    }
}
