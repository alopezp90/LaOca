package oca.gui;

/**
 * @author Alberto López Puertas 
 * <alopezp90@gmail.com>
 */
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BotonFicha extends JButton {

    private int posicionX, posicionY;
    
    private final int ANCHO_FICHA = 30, ALTO_FICHA = 31;
    private final ImageIcon F_AZUL = new ImageIcon("src/main/resources/FichaAzul.png");
    private final ImageIcon F_NARANJA = new ImageIcon("src/main/resources/FichaNaranja.png");
    private final ImageIcon F_ROJA = new ImageIcon("src/main/resources/FichaRoja.png");
    private final ImageIcon F_VERDE = new ImageIcon("src/main/resources/FichaVerde.png");
   
    public BotonFicha(int jugador, int x, int y) {
        this.posicionX = x;
        this.posicionY = y;
        
        //Selecciona icono en funcion del numero de jugador (0-3)
        switch (jugador) {
            case 0:
                this.setIcon(F_AZUL);
                break;
            case 1:
                this.setIcon(F_NARANJA);
                break;
            case 2:
                this.setIcon(F_ROJA);
                break;
            case 3:
                this.setIcon(F_VERDE);
                break;
        }        
        //Define posicion y estilo de boton (a partir de un icono)
        this.setBounds(posicionX, posicionY, ANCHO_FICHA, ALTO_FICHA);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);
        this.setFocusable(false);
    }
}
