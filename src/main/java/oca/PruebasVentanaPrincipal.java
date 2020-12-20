package oca;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
import java.awt.*;

// private variables
// Constructor to setup the GUI components
public class PruebasVentanaPrincipal {

    public PruebasVentanaPrincipal() {
        Frame f = new Frame("Panel Example");
        Panel panel = new Panel();
        panel.setBounds(40, 80, 200, 200);
        panel.setBackground(Color.gray);
        Button b1 = new Button("Button 1");
        b1.setBounds(50, 100, 80, 30);
        b1.setBackground(Color.yellow);
        Button b2 = new Button("Button 2");
        b2.setBounds(100, 100, 80, 30);
        b2.setBackground(Color.green);
        panel.add(b1);
        panel.add(b2);
        f.add(panel);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
    }

    // The entry main() method
    public static void main(String[] args) {
        // Invoke the constructor (to setup the GUI) by allocating an instance
        new PruebasVentanaPrincipal();
    }
}
