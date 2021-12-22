/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arsito
 */
public class Log {

    private static Log instance;
    String ruta = "src\\main\\java\\";
    String logFile = "log.txt";

    private Log() {
    }

    public void setDir(String ruta) throws Exception {
        File aux = new File(ruta);
        if (aux.isDirectory()) {
            this.ruta = ruta + "\\";
        } else {
            throw new Exception("Ruta incorrecta: " + aux.getAbsolutePath());
        }
    }

    public void setLogFile(String file) throws Exception {
        File aux = new File(ruta + file);
        if (!aux.isDirectory()) {
            this.logFile = file;
        } else {
            throw new Exception("Ruta incorrecta");
        }
    }

    public void addToLog(String mensaje) {
        File file = new File(ruta + logFile);
        StringBuilder registro = new StringBuilder();
        BufferedWriter bw = null;
        try {
            file.createNewFile();
            bw = new BufferedWriter(new FileWriter(file, Charset.forName("UTF-8"), true));
            registro.append("[");
            registro.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
            registro.append("] ");
            registro.append(mensaje);
            registro.append("\n");

            bw.write(registro.toString());
        } catch (IOException e) {
            System.out.println("Error al guardar en log en ruta: " + file.getAbsolutePath() + " -- " + e.toString());
        } catch (Exception e) {
            System.out.println("Error al guardar en log: " + e.toString());
        } finally {
            try {
                bw.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar el flujo en log: " + e.toString());
            }

        }

    }

    public static Log getInstance() {
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }

    public String getLog() {
        File file = new File(ruta + logFile);
        String text = "";
        text = utilidades.Utils.leerArchivo(file);
        if (text == null || text == "") {
            text = "Log vacio";
        }
        return text.toString();
    }

    public void borrarLog() {
        File file = new File(ruta + logFile);
        PrintWriter writer;
        try {
            writer = new PrintWriter(file);
            writer.print("");
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
