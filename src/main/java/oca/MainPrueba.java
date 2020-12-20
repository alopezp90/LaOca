package oca;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
import javax.swing.*;
import java.awt.*;

public class MainPrueba {

    public static void main(String[] args) {

        int alto = 100;
        int ancho = 366;

        JFrame ventana = new JFrame();
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane();
        ventana.setSize(366, alto + 36);

        JButton boton = new JButton("Tirar");
        boton.setBounds(133, 0, 100, 100);

        JPanel panel = new JPanel();
        panel.setSize(366, alto);
        panel.setLayout(null);
        panel.add(boton);

        ventana.setLayout(null);
        ventana.add(panel);

        ventana.setVisible(true);
    }
}
