package oca.gui;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
import javax.swing.JScrollPane;

public class PanelLog extends JScrollPane {

    //Declara constantes
    private final int POSICION_X = 940, POSICION_Y = 20;
    private final int ANCHO = 400, ALTO = 580;

    //Instancia variables
    private LogPane log;

    //Constructor por defecto de la clase
    public PanelLog() {
        //Define las variables del JScrollPane
        this.setBounds(POSICION_X, POSICION_Y, ANCHO, ALTO);
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //Inicializa el JTextPane y lo usa como viewport del JScrollPane
        log = new LogPane();
        this.setViewportView(log);
    }

    //Setter y getter para el JTextPane
    public LogPane getLog() {
        return log;
    }

    public void setLog(LogPane log) {
        this.log = log;
    }   
}
