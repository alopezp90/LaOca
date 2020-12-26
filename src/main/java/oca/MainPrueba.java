package oca;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
import javax.swing.*;
import java.awt.*;

public class MainPrueba {

    public static void main(String[] args) {

        JFrame ventana = new JFrame();
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(null);
        ventana.setSize(940, 740);

        JLabel background = new JLabel(new ImageIcon("src/main/resources/TableroOca.png"));
        background.setVisible(true);
        ventana.add(background);

//        JPanel panel = new JPanel();
//        panel.setSize(900, 700);
//        panel.setBounds(20, 20, 940, 740);
//        panel.setLayout(null);
//        JLabel fichaRoja = new JLabel(new ImageIcon("src/main/resources/FichaRoja.png"));
//        panel.add(fichaRoja);
//        fichaRoja.setLocation(100, 100);
//        fichaRoja.setVisible(true);
//        panel.setVisible(true);
//        
//
//        ventana.add(panel);
        ventana.pack();
        ventana.setVisible(true);
    }
}
