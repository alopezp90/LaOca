package oca;

import oca.gui.*;

/**
 * @author Alberto López Puertas 
 * <alopezp90@gmail.com>
 */

public class Prueba {
    public static void main(String[] args) {
        VentanaPrincipal frame = new VentanaPrincipal();
        
        frame.getPanelDado().cambiaColor(0);
        frame.getPanel0().mover(620,620);
        
        frame.pack();
        frame.setVisible(true);
    }
}
