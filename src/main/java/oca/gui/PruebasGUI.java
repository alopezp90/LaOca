package oca.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
public class PruebasGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JPanel panel = new PanelDado();

        frame.setSize(1360, 740);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(panel);
        
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
