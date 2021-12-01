/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textos;

/**
 * Metodos con textos que se utilizan en la libreria.
 * @author Ar
 */
public class Textos {
    /* Menu.java*/    
    public static final String INDICAR_OPCION = "\n<< Indica el nº de la opción >>";    
    public static final String OPCION_SALIR = "\n0.- Salir";    
    public static final String EXC_SIN_OPCIONES = " El menú no contiene opciones y requiere respuesta";    
    public static final String NO_SELECCIONADO = "No se ha realizado ninguna selección";    
    public static final String FORMATO_FECHA = "\n fecha en formato dia/mes/año";    
    
    public static String cabeceraMenu(String tituloMenu){
        return "\n[Menú " + tituloMenu + "]";
    }
    public static String finMenu(String tituloMenu){
        return "\n**** Fin del menú " + tituloMenu + " ****";
    }
    public static String opcionSeleccionada(String seleccion){
        return "\nSeleccionado -> " + seleccion;
    }
     
    // pendiente: 
        /* Salidas.java*/
}
