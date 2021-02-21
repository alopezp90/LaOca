package juegodelaoca;

/**
 * Esta clase define los tipos de casilla posibles en La Oca. Cada tipo de
 * casilla queda definido únicamente mediante su nombre.
 *
 * @author Alberto López Puertas
 * <https://github.com/alopezp90>
 */
import java.awt.Point;
import java.util.ArrayList;

public class Casilla {

    //Instancia variables de Casilla
    private TipoCasilla tipoCasilla;
    private int movimientoOrden;                //Movimiento al que fuerza al jugador la casilla
    private int numero;                         //Numero de la casilla
    private ArrayList<Jugador> listaJugadores;  //Cantidad de jugadores en la casilla
    private Point posicionRelativa;             //Punto de la esquina superior izquierda de la casilla en la GUI.

    /**
     * Constructor parametrizado de Casilla.
     *
     * @param tipoCasilla TipoCasilla
     */
    public Casilla(TipoCasilla tipoCasilla) {
        this.listaJugadores = new ArrayList<>();
        this.tipoCasilla = tipoCasilla;
    }

    //**************************************************
    //Getters
    //**************************************************
    /**
     * Devuelve el tipo de la Casilla.
     * 
     * @return TipoCasilla - tipoCasilla 
     */
    public TipoCasilla getTipoCasilla() {
        return tipoCasilla;
    }

    /**
     * Devuelve el movimiento ordenado por la Casilla.
     *
     * @return int - movimientoOrden
     */
    public int getMovimientoOrden() {
        return movimientoOrden;
    }

    /**
     * Devuelve el numero de la posicion de la Casilla en el tablero.
     *
     * @return int - numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Devuelve la lista de jugadores actualmente en la Casilla.
     *
     * @return ArrayList - listaJugadores
     */
    public ArrayList getListaJugadores() {
        return listaJugadores;
    }

    /**
     * Devuelve las coordenadas de la esquina superior izquierda de la Casilla.
     *
     * @return Point - posicionRelativa
     */
    public Point getPosicionRelativa() {
        return posicionRelativa;
    }

    //**************************************************
    //Setters
    //**************************************************
    /**
     * Modifica el movimiento ordenado por la Casilla.
     *
     * @param movimientoOrden int
     */
    public void setMovimientoOrden(int movimientoOrden) {
        this.movimientoOrden = movimientoOrden;
    }

    /**
     * Modifica el numero de orden de la Casilla en el tablero.
     *
     * @param numero int
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Modificas coordenadas de la esquina superior izquierda de la Casilla.
     *
     * @param posicionRelativa Point
     */
    public void setPosicionRelativa(Point posicionRelativa) {
        this.posicionRelativa = posicionRelativa;
    }

    //**************************************************
    //Metodos
    //**************************************************
    /**
     * Pone al Jugador parametro de la lista de jugadores que se encuentran en
     * la Casilla.
     *
     * @param jugador
     */
    public void llega(Jugador jugador) {
        this.listaJugadores.add(jugador);
    }

    /**
     * Quita al Jugador parametro de la lista de jugadores que se encuentran en
     * la Casilla.
     *
     * @param jugador
     */
    public void sale(Jugador jugador) {
        this.listaJugadores.remove(jugador);
    }

}
