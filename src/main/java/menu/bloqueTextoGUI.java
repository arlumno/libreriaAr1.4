/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Ar
 */
public class bloqueTextoGUI extends JFrame {

    private String texto;
    private String titulo = "--";

    public bloqueTextoGUI(String titulo, String texto) {
        this.texto = texto;
        this.titulo = titulo;
        createPanel();
    }

    public bloqueTextoGUI(String texto) {
        this.texto = texto;
        createPanel();
    }

    public void createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 4, 10, 10));
        JLabel label = new JLabel("<html>" + texto.replace("\n", "<br>") + "</html>");
        label.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(label);

        setTitle(titulo);
        setLayout(new BorderLayout());

        add(BorderLayout.CENTER, new JScrollPane(panel));
        setSize(500, 375);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
