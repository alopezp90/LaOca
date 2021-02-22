package juegodelaoca;

import java.util.Random;
import javax.swing.ImageIcon;

/**
 * Almacena la informacion de cada Jugador.
 *
 * @author Alberto López Puertas
 * <https://github.com/alopezp90>
 */
public class Jugador {

    //declaracion de variables
    private String nombre;
    private int numeroJugador;
    private int posicion;
    private boolean tiradaExtra;
    private int penalizacion;
    private int tirada;
    private PanelFicha ficha;
    private ImageIcon iconoDado;

    //constantes
    private final ImageIcon D_AZUL = new ImageIcon("src/main/resources/DadoAzul1.png");
    private final ImageIcon D_NARANJA = new ImageIcon("src/main/resources/DadoNaranja1.png");
    private final ImageIcon D_ROJO = new ImageIcon("src/main/resources/DadoRojo1.png");
    private final ImageIcon D_VERDE = new ImageIcon("src/main/resources/DadoVerde1.png");

    private static int contador = 0;

    /**
     * Constructor de Jugador. Inicializa a 0 todas las variables, da numero al
     * jugador y crea su ficha.
     */
    public Jugador() {
        this.numeroJugador = contador;
        this.ficha = new PanelFicha(this.numeroJugador);
        this.setIconoDado();
        contador++;
    }

    //**************************************************
    //Getters
    //**************************************************
    /**
     * Devuelve el nombre del Jugador.
     *
     * @return String - nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el numero del Jugador.
     *
     *
     * @return int - numeroJugador
     */
    public int getNumeroJugador() {
        return numeroJugador;
    }

    /**
     * Devuelve el numero de casilla en la que se encuentra el jugador.
     *
     * @return int - posicion
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     * Devuelve true si el jugador tiene otra tirada.
     *
     * @return boolean - tiradaExtra
     */
    public boolean isTiradaExtra() {
        return tiradaExtra;
    }

    /**
     * Devuelve cantidad de turnos de penalizacion del jugador.
     *
     * @return int penalizacion
     */
    public int getPenalizacion() {
        return penalizacion;
    }

    /**
     * Devuelve la ultima tirada de dados del Jugador.
     *
     * @return int tirada
     */
    public int getTirada() {
        return tirada;
    }

    /**
     * Devuelve el PanelFicha asignado al Jugador.
     *
     * @return PanelFicha ficha
     */
    public PanelFicha getFicha() {
        return ficha;
    }

    /**
     * Devuelve el el iconoDado asignado al Jugador.
     *
     * @return ImageIcon iconoDado
     */
    public ImageIcon getIconoDado() {
        return iconoDado;
    }

    //**************************************************
    //Setters
    //**************************************************
    /**
     * Modifica el nombre del Jugador. Corrige nombre vacio.
     *
     * @param nombre String
     */
    private void setNombre(String nombre) {
        if (nombre.equals("")) {
            this.nombre = "Jugador " + (this.getNumeroJugador() + 1);
        }
        this.nombre = nombre;
    }

    /**
     * Modifica la casilla en la que se encuentra el Jugador.
     *
     * @param posicion int
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    /**
     * True para que el jugador tenga una tirada extra.
     *
     * @param tiradaExtra boolean
     */
    public void setTiradaExtra(boolean tiradaExtra) {
        this.tiradaExtra = tiradaExtra;
    }

    /**
     * Modifica la cantidad de turnos de penalizacion del jugador.
     *
     * @param penalizacion int
     */
    public void setPenalizacion(int penalizacion) {
        this.penalizacion = penalizacion;
    }

    /**
     * Asigna al jugador el icono del dado correspondiente a su color.
     *
     */
    private void setIconoDado() {
        switch (this.numeroJugador) {
            case 0:
                this.iconoDado = D_AZUL;
                break;
            case 1:
                this.iconoDado = D_NARANJA;
                break;
            case 2:
                this.iconoDado = D_ROJO;
                break;
            default:
                this.iconoDado = D_VERDE;
        }
    }

    //**************************************************
    //Metodos
    //**************************************************
    /**
     * Tira el dado y almacena el valor en la variable tirada.
     */
    public void tiraDado() {
        Random rd = new Random();
        this.tirada = rd.nextInt(6) + 1;
    }

    /**
     * Quita un turno de penalizacion al Jugador.
     */
    public void reducePenalizacion() {
        this.penalizacion--;
    }
}
