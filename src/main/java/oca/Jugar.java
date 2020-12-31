package oca;

/**
 * Esta clase inicializa a los jugadores, el tablero y la GUI.
 *
 * @author Alberto López Puertas
 * <https://github.com/alopezp90>
 */
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import oca.gui.VentanaPrincipal;

public class Jugar {

    //Declaracion de constantes
    private static ImageIcon ICONO = new ImageIcon("src/main/resources/Oca96.png");

    //Inicializa variables
    private static Tablero tablero = new Tablero();

    //Instacia variables
    private static int numJugador;
    private static Jugador[] jugador;
    private static VentanaPrincipal ventanaPrincipal;

    public static void main(String[] args) {

        solicitaJugadores();
        jugador = new Jugador[numJugador];

        for (int i = 0; i < jugador.length; i++) {
            jugador[i] = new Jugador(solicitaNombre(i));
            System.out.println(jugador[i].getNombre());
        }
        
        ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.pack();
        ventanaPrincipal.setVisible(true);
    }

    /**
     * Metodo que solicita numero de jugadores mediante botones y lo guarda en
     * numJugadores.
     */
    public static void solicitaJugadores() {
        do {
            int opcion = JOptionPane.showOptionDialog(
                    null,
                    "¿Cuántos jugadores sois?",
                    "Número de jugadores",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    ICONO,
                    new Object[]{"2", "3", "4"}, null);
            switch (opcion) {
                case 0:
                    numJugador = 2;
                    break;
                case 1:
                    numJugador = 3;
                    break;
                case 2:
                    numJugador = 4;
                    break;
            }
        } while (numJugador != 2 && numJugador != 3 && numJugador != 4);
    }
    
    /**
     * Metodo que solicita el nombre de los jugadores.
     * 
     * @return String con nombre del jugador.
     */
    public static String solicitaNombre(int i) {
        String texto = null;
        do {
            Object objeto = JOptionPane.showInputDialog(null,
                    "Introduce el nombre del jugador " + (i + 1),
                    "Jugador " + (i + 1),
                    JOptionPane.OK_OPTION,
                    ICONO,
                    null,
                    null);
            if (objeto != null) {
                texto = objeto.toString();
            }
        } while (texto == null);
        return texto;
    }
}
