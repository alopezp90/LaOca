package oca.gui;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PanelFicha extends JPanel {

    //Decara constantes
    private final int ANCHO_FICHA = 30, ALTO_FICHA = 31;
    private final ImageIcon F_AZUL = new ImageIcon("src/main/resources/FichaAzul.png");
    private final ImageIcon F_NARANJA = new ImageIcon("src/main/resources/FichaNaranja.png");
    private final ImageIcon F_ROJA = new ImageIcon("src/main/resources/FichaRoja.png");
    private final ImageIcon F_VERDE = new ImageIcon("src/main/resources/FichaVerde.png");

    //Instancia variables
    private JLabel ficha = new JLabel();
    private int posicionX, posicionY;

    //Constructor de la clase. Parámetro 0-3 para colores de jugador
    public PanelFicha(int icono) {
        //Define las variables de ficha
        switch (icono) {
            case 0:
                this.ficha.setIcon(F_AZUL);
                break;
            case 1:
                this.ficha.setIcon(F_NARANJA);
                break;
            case 2:
                this.ficha.setIcon(F_ROJA);
                break;
            case 3:
                this.ficha.setIcon(F_VERDE);
                break;
        }
        this.setBounds(0, -5, ANCHO_FICHA, ALTO_FICHA - 5);
    }

    //Coloca PanelFicha en la posicion indicada
    public void mover(int x, int y) {
        this.setLocation(x, y - 5);
    }
}
