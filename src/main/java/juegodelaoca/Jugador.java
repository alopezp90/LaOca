package juegodelaoca;

import java.util.Random;

/**
 * Almacena la informacion de cada Jugador.
 *
 * @author Alberto López Puertas
 * <https://github.com/alopezp90>
 */
public class Jugador {

    private String nombre;
    private int posicion;
    private int penalizacion;
    private int ultimaPosicion;
    private int tirada;

    private static int contador = 0;

    /**
     * Constructor de Jugador. Inicializa a 0 todas las variables.
     *
     * @param nombre - nombre del Jugador, si esta en blanco se le asigna uno
     * del tipo: "Jugador X"
     */
    public Jugador(String nombre) {
        contador++;
        this.nombre = compruebaNombre(nombre);
    }

    //Metodo auxiliar del constructor
    /**
     * Comprueba si nombre esta vacio y devuelve el nombre del Jugador.
     *
     * @param nombre - String introducido por el usuario
     * @return String nombre corregido en caso de estar vacio
     */
    private static String compruebaNombre(String nombre) {
        if (!nombre.equals("")) {
            return nombre;
        } else {
            return "Jugador " + contador;
        }
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
     * Devuelve el numero de casilla en la que se encuentra el jugador.
     *
     * @return int - posicion
     */
    public int getPosicion() {
        return posicion;
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
     * Devuelve la anterior posicion del Jugador.
     *
     * @return int - ultimaPosicion
     */
    public int getUltimaPosicion() {
        return ultimaPosicion;
    }

    /**
     * Devuelve la ultima tirada de dados del Jugador.
     *
     * @return int tirada
     */
    public int getTirada() {
        return tirada;
    }

    //**************************************************
    //Setters
    //**************************************************
    /**
     * Modifica el nombre del Jugador. Corrige nombre vacio.
     *
     * @param nombre String
     */
    public void setNombre(String nombre) {
        this.nombre = compruebaNombre(nombre);
    }

    /**
     * Modifica la casilla en la que se encuentra el Jugador y actualiza
     * ultimaPosicion.
     *
     * @param posicion int
     */
    public void setPosicion(int posicion) {
        this.ultimaPosicion = this.posicion;
        this.posicion = posicion;
    }

    /**
     * Modifica la cantidad de turnos de penalizacion del jugador.
     *
     * @param penalizacion int
     */
    public void setPenalizacion(int penalizacion) {
        this.penalizacion = penalizacion;
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

    //**************************************************
    //Metodos de clase
    //**************************************************
    /**
     * Devuelve el valor del contador de instancias.
     *
     * @return int - contador de instancias
     */
    public static int getContador() {
        return contador;
    }

    /**
     * Reinicia el contador de instancias.
     *
     */
    public static void resetContador() {
        Jugador.contador = 0;
    }

}
