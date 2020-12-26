package oca;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class Historial extends JScrollPane {

    //Variable que almacena el String con el historial de la partida en HTML
    private JLabel historial;

    //Constantes para el Scroll
    private final int ANCHO = 400;
    private final int ALTO = 600;
    private final Font font = new Font(Font.MONOSPACED, Font.PLAIN, 12);


    public Historial(JLabel label) {
        
        this.historial = label;
        
        //Inicializa un JScrollPane con los parametros
        historial.setFont(font);
        this.setPreferredSize(new Dimension(ANCHO, ALTO));
        this.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        this.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
        this.setBackground(Color.white);
        this.setName("Historial");
        this.setToolTipText("Historial");
        this.setWheelScrollingEnabled(true);
    }
}
