package juegodelaoca;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PanelDado extends JPanel {

    //Declara constantes
    private final int POSICION_X = 1095, POSICION_Y = 620;
    private final int ANCHO_BOTON = 90, ALTO_BOTON = 100;
    private final ImageIcon D_AZUL = new ImageIcon("src/main/resources/DadoAzul1.png");
    private final ImageIcon D_NARANJA = new ImageIcon("src/main/resources/DadoNaranja1.png");
    private final ImageIcon D_ROJO = new ImageIcon("src/main/resources/DadoRojo1.png");
    private final ImageIcon D_VERDE = new ImageIcon("src/main/resources/DadoVerde1.png");

    //Instancia variables
    private JButton botonDado;

    //Constructor por defecto de la clase
    public PanelDado(int color) {
        //Define las variables de botonDado
        botonDado = new JButton();
        cambiaColor(color);
        this.botonDado.setBorder(BorderFactory.createEmptyBorder());
        this.botonDado.setContentAreaFilled(false);
        this.botonDado.setFocusable(false);

        //Define las variables de panelDado
        //No se por que hay que subirlo y ampliar altura 5px (todos los paneles)
        this.setBounds(POSICION_X, POSICION_Y - 5, ANCHO_BOTON, ALTO_BOTON + 5);
        this.setOpaque(false);
        this.setLayout(new FlowLayout());
        
        //Añade el boton al JPanel
        this.add(botonDado);
    }
    
    //Metodo getter
    public JButton getBotonDado() {
        return botonDado;
    }
    
    public void cambiaColor(int color) {
        switch (color) {
            case 0:
                this.botonDado.setIcon(D_AZUL);
                break;
            case 1:
                this.botonDado.setIcon(D_NARANJA);
                break;
            case 2:
                this.botonDado.setIcon(D_ROJO);
                break;
            case 3:
                this.botonDado.setIcon(D_VERDE);
                break;
        }
    }
}