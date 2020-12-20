package oca;

/**
 * @author Alberto López Puertas 
 * <alopezp90@gmail.com>
 */
import java.awt.*;
import javax.swing.*;

public class BotonTurno extends JButton{

    private final int ANCHO_BOTON = 100;
    private final int ALTO_BOTON = 100;
    
    private String texto;
    private JButton boton;
    
    public BotonTurno(String texto) {
        this.texto = texto;
        
        this.boton = new JButton(texto);
        this.boton.setBounds(133, 34, ANCHO_BOTON, ALTO_BOTON);
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }
    
    
}
