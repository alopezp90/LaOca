package juegodelaoca;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
import java.awt.FlowLayout;
import java.awt.Point;
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
        //Define las variables del JPanel
        //No se por que hay que subirlo y ampliar altura 5px (todos los paneles)
        this.setBounds(-99, 596, ANCHO_FICHA, ALTO_FICHA + 5);
        this.setOpaque(false);
        this.setLayout(new FlowLayout());
        
        //Añade la ficha al JPanel
        this.add(ficha);
        
        //Inicializa la ficha no visible
        this.setVisible(false);
    }
}