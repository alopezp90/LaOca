package juegodelaoca;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Alberto López Puertas
 * <https://github.com/alopezp90>
 */
public class ControladorJugadores {

    private static Random rd = new Random();

    private ArrayList<Jugador> participantes;
    private Tablero tablero;

    /**
     * Constructor de Partida, inicializa un ArrayList con los participantes.
     *
     * @param numeroParticipantes - int
     */
    public ControladorJugadores(int numeroParticipantes) {
        tablero = new Tablero();
        participantes = new ArrayList<>();
        for (int i = 0; i < numeroParticipantes; i++) {
            this.participantes.add(new Jugador());
        }
    }

    /**
     * Devuelve el Tablero de juego.
     *
     * @return Tablero
     */
    public Tablero getTablero() {
        return tablero;
    }

    /**
     * Devuelve el Jugador con turno en curso
     *
     * @return Jugador
     */
    public Jugador getCurrent() {
        return participantes.get(0);
    }

    /**
     * Rota el turno del Jugador.
     */
    public void siguienteTurno() {
        participantes.add(participantes.remove(0));
    }

    /**
     * Mezcha n veces los participantes para hacer aleatorio el orden de juego.
     *
     * @param n - int. Numero de posiciones que se barajan
     */
    public void shuffle(int n) {
        for (int i = n; i < 0; i--) {
            participantes.add(participantes.remove(rd.nextInt(participantes.size() - 1)));
        }
    }

    /**
     * Secuencia de turno del Jugador en curso. La secuencia comineza en la
     * tirada de dados del Jugador en curso: Se realiza la tirada de dados, el
     * Jugador mueve a la casilla que le corresponda, si la casilla final del
     * movimiento tiene caracteristicas, estas son aplicadas al Jugador. Termina
     * la secuencia con la comprobacion de estado del Jugador siguiente.
     */
    /**
     * Mueve al Jugador por el Tablero la cantidad de casillas indicada.
     * Devuelve true si el jugador ha pasado por el pozo.
     *
     * @param cantidad - int
     * @return true is el Jugador pasa la casilla Pozo
     */
    public boolean mover(int cantidad) {
        int inicioMovimiento = this.getCurrent().getPosicion();
        if (inicioMovimiento + cantidad > 63) {
            this.getCurrent().setPosicion(63 - (inicioMovimiento + cantidad - 63));
        } else {
            this.getCurrent().setPosicion(inicioMovimiento + cantidad);
        }
        this.getCurrent().getFicha().mover(this.getTablero().getCasilla(this.getCurrent().getPosicion()).getPosicionRelativa());
        return pasaPozo(inicioMovimiento, this.getCurrent().getPosicion());
    }

    /**
     * Metodo auxiliar de mover(). Devuelve true si el Jugador pasa o cae en la
     * Casilla 31 (Pozo)
     *
     * @param inicioMovimiento - int
     * @param finalMovimiento - int
     * @return true si el Jugador pasa la casilla Pozo
     */
    private static boolean pasaPozo(int inicioMovimiento, int finalMovimiento) {
        return (inicioMovimiento < Tablero.POS_POZO && finalMovimiento >= Tablero.POS_POZO);
    }
}
