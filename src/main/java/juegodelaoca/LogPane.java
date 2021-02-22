package juegodelaoca;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
import javax.swing.JTextPane;

public class LogPane extends JTextPane {
    
    //Instancia variable
    private String texto = "";

    //Constructor por defecto de LogPane
    public LogPane() {
        //Define variables de LogPane
        this.setEditable(false);
        this.setContentType("text/html");
        this.setText(texto);
    }

    //Metodo para añadir nueva linea al texto
    public void nuevaLinea(String linea) {
        this.texto = this.texto + "<br/>" + linea;
        this.setText(this.texto);
    }
}
