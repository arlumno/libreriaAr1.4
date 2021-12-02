/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
            this.ruta = ruta;
        } else {
            throw new Exception("Ruta incorrecta");
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
}
