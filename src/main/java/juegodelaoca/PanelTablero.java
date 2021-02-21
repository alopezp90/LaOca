package juegodelaoca;

import java.awt.FlowLayout;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 * @author Alberto López Puertas 
 * <https://github.com/alopezp90>
 */

//TODO: Javadoc
//-------------------

public class PanelTablero extends JPanel{
    
    //Declara constantes
    private final int ANCHO = 902, ALTO = 702;
    private final Point POSICION = new Point(20,20);
    private final ImageIcon TABLERO_IMAGEN = new ImageIcon("src/main/resources/TableroSinBordes.png");
    
    //Instancia variables
    private JLabel fondo;
    
    public PanelTablero() {
        //configura bounds del panel
        this.setBounds(POSICION.x, POSICION.y - 5, ANCHO, ALTO + 5);
        
        //configura la imagen
        fondo.setLayout(new FlowLayout());
        fondo.setIcon(TABLERO_IMAGEN);
        fondo.setLayout(null);
    }
    
    public void addPanel(JPanel panel) {
        this.fondo.add(panel);
    }
}
