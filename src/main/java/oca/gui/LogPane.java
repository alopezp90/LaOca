package oca.gui;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
import javax.swing.JTextPane;

public class LogPane extends JTextPane {

    //Constructor por defecto de LogPane
    public LogPane() {
        //Define variables de LogPane
        this.setEditable(false);
        this.setContentType("text/html");
        this.setText("");
    }

    //Metodo para añadir nueva linea al texto
    public void nuevaLinea(String linea) {
        String ending = this.getText().substring(this.getText().length() - 1 - 18);
        this.setText(this.getText().substring(0, this.getText().length() - 1 - 18) + "<br/>" + linea + ending);
    }
}
