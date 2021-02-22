package juegodelaoca;

import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Alberto López Puertas 
 * <https://github.com/alopezp90>
 */

public class PanelSalir extends JPanel{

    private final int POSICION_X = 8, POSICION_Y = 8;
    private final int ANCHO_BOTON = 27, ALTO_BOTON = 27;
    private final ImageIcon ICONO = new ImageIcon("src/main/resources/BotonSalir.png");
    
    private JButton botonSalir;
    
    public PanelSalir() {
        this.botonSalir = new JButton();
        this.botonSalir.setIcon(ICONO);
        this.botonSalir.setBorder(BorderFactory.createEmptyBorder());
        this.botonSalir.setContentAreaFilled(false);
        this.botonSalir.setFocusable(false);
        
        this.add(botonSalir);

        //No se por que hay que subirlo y ampliar altura 5px (todos los paneles)
        this.setBounds(POSICION_X, POSICION_Y - 5, ANCHO_BOTON, ALTO_BOTON + 5);
        this.setOpaque(false);
        this.setLayout(new FlowLayout());
    }
    
    public JButton getBotonSalir() {
        return botonSalir;
    }
    
}
