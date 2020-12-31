package oca;

/**
 * Esta clase inicializa a los jugadores, el tablero y la GUI.
 *
 * @author Alberto López Puertas
 * <https://github.com/alopezp90>
 */
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import oca.gui.PanelFicha;
import oca.gui.VentanaGanador;
import oca.gui.VentanaPrincipal;

public class Jugar {

    //Declaracion de constantes
    private static ImageIcon ICONO = new ImageIcon("src/main/resources/Oca96.png");

    //Inicializa variables
    private static Tablero tablero = new Tablero();
    private static int turno = 0;

    //Instacia variables
    private static int numJugador;
    private static Jugador[] jugador;
    private static VentanaPrincipal ventanaPrincipal;
    private static VentanaGanador ventanaGanador;

    public static void main(String[] args) {

        solicitaJugadores();
        jugador = new Jugador[numJugador];

        for (int i = 0; i < jugador.length; i++) {
            jugador[i] = new Jugador(solicitaNombre(i));
            jugador[i].setNumero(i);
        }

        ventanaPrincipal = new VentanaPrincipal();
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
     * @param i numero del jugador
     * @return String con nombre del jugador.
     */
    public static String solicitaNombre(int i) {
        String texto = null;
        do {
            Object objeto = JOptionPane.showInputDialog(null,
                    "Introduce nombre:",
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

    /**
     * Metodo que calcula a que jugador le toca a partir del cardinal de turno.
     *
     * @param turno int que cuenta todos los turnos de la partida
     * @param numJugador numero de jugadores en la partida
     * @return int numero de jugador
     */
    public static int turnoJugador(int turno, int numJugador) {
        return (int) (turno - (Math.floor(turno / 4.0) * 4));
    }

    /**
     * Metodo que llama a los necesarios para actualizar la posicion de la ficha
     *
     * @param numero del jugador dueo de la ficha
     */
    public static void mueveFicha(int numero) {
        PanelFicha fichaPlayer;
        switch (numero) {
            case 0:
                fichaPlayer = ventanaPrincipal.getPanel0();
                break;
            case 1:
                fichaPlayer = ventanaPrincipal.getPanel1();
                break;
            case 2:
                fichaPlayer = ventanaPrincipal.getPanel2();
                break;
            default:
                fichaPlayer = ventanaPrincipal.getPanel3();
                break;
        }
        fichaPlayer.mover(numero, tablero.getCasilla(jugador[numero].getPosicion()).getPoint());
    }

    /**
     * Metodo de clase que organiza el turno de cada jugador.
     *
     * @param numero numero del jugador al que le toca.
     */
    public static void bucleTurno(int numero) {

        while (jugador[numero].getTurno() < 0) {
            //tirada de dado + anotacion en log
            jugador[numero].tiraDado();
            ventanaPrincipal.getPanelLog().getLog().nuevaLinea(jugador[numero].textoTirada());

            //mueve al jugador
            jugador[numero].moverDado(tablero, jugador);

            //mueve la casilla
            mueveFicha(numero);

            //Actualiza el estado del jugador y lo suma al log
            ventanaPrincipal.getPanelLog().getLog().nuevaLinea(jugador[numero].actualizaEstado(tablero, jugador));

            //mueve la casilla si fuera necesario
            mueveFicha(numero);
        }
        //Comprueba si ha ganado
        if (jugador[numero].isGanador()) {
            ventanaPrincipal.setVisible(false);
            ventanaGanador = new VentanaGanador(numero);
        }
        
        //Comienza el turno del siguiente jugador hasta que le toque tirar
        jugador[numero + 1].comienza();
        ventanaPrincipal.getPanelLog().getLog().nuevaLinea(jugador[numero + 1].estado(tablero));

    }
}
