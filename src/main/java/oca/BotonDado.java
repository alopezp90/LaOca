package oca;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BotonDado extends JButton {

    private final int POSICION_X = 1095, POSICION_Y = 620;
    private final int ANCHO_BOTON = 90, ALTO_BOTON = 100;
    private final ImageIcon D_BLANCO = new ImageIcon("src/main/resources/DadoBlanco100.png");
    private final ImageIcon D_AZUL = new ImageIcon("src/main/resources/DadoAzul100.png");
    private final ImageIcon D_NARANJA = new ImageIcon("src/main/resources/DadoNaranja100.png");
    private final ImageIcon D_ROJO = new ImageIcon("src/main/resources/DadoRojo100.png");
    private final ImageIcon D_VERDE = new ImageIcon("src/main/resources/DadoVerde100.png");
   
    public BotonDado(int jugador) {
        //Selecciona icono en funcion del numero de jugador (0-3), dado blanco por defecto
        switch (jugador) {
            case 0:
                this.setIcon(D_AZUL);
                break;
            case 1:
                this.setIcon(D_NARANJA);
                break;
            case 2:
                this.setIcon(D_ROJO);
                break;
            case 3:
                this.setIcon(D_VERDE);
                break;
            default:
                this.setIcon(D_BLANCO);
        }        
        //Define posicion y estilo de boton (a partir de un icono)
        this.setBounds(POSICION_X, POSICION_Y, ANCHO_BOTON, ALTO_BOTON);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);
        this.setFocusable(false);
    }
}
