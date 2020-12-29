package oca.gui;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class PanelLog extends JScrollPane {

    //Declara constantes
    private final int POSICION_X = 940, POSICION_Y = 20;
    private final int ANCHO = 400, ALTO = 580;
//    private final String FINAL = "</html>";

    //Instancia variables
    //private String textoLog = "";
    private JTextPane logPane;

    //Constructor por defecto de la clase
    public PanelLog() {
        //Define las variables del JScrollPane
        this.setBounds(POSICION_X, POSICION_Y, ANCHO, ALTO);
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //Inicializa el JTextPane y lo usa como viewport del JScrollPane
        logPane = new JTextPane();
        logPane.setEditable(false);
        logPane.setContentType("text/html");
        logPane.setText("");
        
        this.setViewportView(logPane);
    }

    public JTextPane getLogPane() {
        return logPane;
    }

    public void setLogPane(JTextPane logPane) {
        this.logPane = logPane;
    }
    

    //Metodo para añadir nueva linea en el Log
    public void sumaTexto(String linea) {
        this.logPane.setText(this.logPane.getText() + "<br/>" + linea);
    }
    
    public void siguienteJugador(int numero) {
        
    }
    
}
