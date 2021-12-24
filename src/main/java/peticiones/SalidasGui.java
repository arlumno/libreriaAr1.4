/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peticiones;

import javax.swing.JOptionPane;
import menu.bloqueTextoGUI;

/**
 *
 * @author a20armandocb
 */
public class SalidasGui {
    public static void mensaje(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje);
    }
    public static void bloqueTexto(String texto){
        new bloqueTextoGUI(texto);
    }
    public static void bloqueTexto(String titulo, String texto){
        new bloqueTextoGUI(titulo, texto);
    }
}
