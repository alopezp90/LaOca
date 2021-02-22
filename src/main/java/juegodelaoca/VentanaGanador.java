package juegodelaoca;

/**
 * Esta clase define la ventana que da la enhorabuena al ganador del juego.
 *
 * @author Alberto López Puertas
 * <https://github.com/alopezp90>
 */
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class VentanaGanador extends JFrame {

    //Declara constantes
    private final ImageIcon FONDO = new ImageIcon("src/main/resources/FondoAragon.png");
    private final String RUTA_ROTULO = "src/main/resources/rotuloX.png";
    private final int ANCHO = 656, ALTO = 370;
    private final int ANCHO_ROTULO = 504, ALTO_ROTULO = 73;
    private final String titulo = "La Oca";

    //Inicializa las variables
    private JLabel fondo = new JLabel();
    private JLabel rotuloLabel = new JLabel();
    private JPanel rotuloPanel = new JPanel();

    //Instancia las variables
    private ImageIcon rotulo;

    /**
     * Constructor parametrizado de la clase.
     *
     * @param i numero del jugador ganador
     */
    public VentanaGanador(int i) {

        //Parametros del JFrame
        this.setTitle(titulo);
        this.setSize(ANCHO, ALTO);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //Configura imagen de fondo
        fondo.setLayout(new FlowLayout());
        fondo.setIcon(FONDO);
        fondo.setLayout(null);

        //Define cual sera el rotulo
        rotulo = new ImageIcon(RUTA_ROTULO.replaceAll("X", "" + i));

        //Configura la imagen del rotulo
        rotuloLabel.setIcon(rotulo);

        //Configura el panel del rotulo
        rotuloPanel.setBounds((ANCHO - ANCHO_ROTULO) / 2, 250, ANCHO_ROTULO, ALTO_ROTULO + 5);
        rotuloPanel.setOpaque(false);
        rotuloPanel.setLayout(new FlowLayout());
        
        //Añade el rotulo en su panel, el panel al fondo y el fondo al frame
        rotuloPanel.add(rotuloLabel);
        fondo.add(rotuloPanel);
        this.add(fondo);
        
        //Empaqueta y hace visibre el frame
        this.pack();
        this.setVisible(true);
    }
}
