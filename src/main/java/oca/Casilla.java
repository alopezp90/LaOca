package oca;

/**
 * Esta clase define los tipos de casilla posibles en La Oca. 
 * Cada tipo de casilla queda definido únicamente mediante su nombre.
 *
 * @author Alberto López Puertas
 * <https://github.com/alopezp90>
 */

import java.awt.Point;

public class Casilla {

    //Instancia variables de Casilla
    private String nombre;          //Nombre del tipo de casilla
    private int movimientoOrden;    //Movimiento al que fuerza al jugador la casilla
    private int turnosPenalizacion; //Numero de turnos sin lanzar dados por el jugador que cae en la casilla
    private boolean tiradaExtra;    //True si la casilla permite volver a tirar tras caer en ella
    private int posicion;           //Numero de la casilla
    private Point point;            //Punto de la esquina superior izquierda de la casilla en la GUI.

    /**
     * Constructor por defecto de Casilla. No necesita parametros, genera una
     * casilla con:
     * <ul>
     * <li>nombre en blanco.</li>
     * <li>movimientoOrden cero.</li>
     * <li>turnosPenalizacion cero.</li>
     * <li>tiradaExtra false.</li>
     * <li>posicion cero.</li>
     * <li>point null.</li>
     * </ul>
     */
    public Casilla() {
        this.nombre = "";
    }

    /**
     * Constructor parametrizado de Casilla.
     *
     * @param nombre Tipo de casilla, puede ser:
     * <ul>
     * <li>"oca1" son casillas de tipo oca que tienen a la siguiente del mismo
     * tipo a 4 de distancia, da tirada extra.</li>
     * <li>"oca2" son casillas de tipo oca que tienen a la siguiente del mismo
     * tipo a 5 de distancia, da tirada extra.</li>
     * <li>"puente1" es la primera casilla de tipo puente que avanza hasta la
     * posada, pierde 1 turno.</li>
     * <li>"puente2" es la segunda casilla de tipo puente que avanza hasta la
     * posada, pierde 1 turno.</li>
     * <li>"posada" pierde 1 turno.</li>
     * <li>"pozo" asigna -1 turnos de penalizacion, solo se resuelve si otro
     * jugador cruza la casilla.</li>
     * <li>"laberinto" hace retroceder 12 casillas</li>
     * <li>"carcel" pierde 2 turnos.</li>
     * <li>"dados1" avanza el numero de casillas en el que se encuentra el
     * dado.</li>
     * <li>"dados2" avanza el numero de casillas en el que se encuentra el
     * dado.</li>
     * <li>"calavera" retrocede hasta la casilla 1.</li>
     * </ul>
     */
    public Casilla(String nombre) {
        this.nombre = nombre;

        switch (nombre) {
            case "oca1":
                this.movimientoOrden = 4;
                this.turnosPenalizacion = 0;
                this.tiradaExtra = true;
                break;

            case "oca2":
                this.movimientoOrden = 5;
                this.turnosPenalizacion = 0;
                this.tiradaExtra = true;
                break;

            case "puente1":
                this.movimientoOrden = 13;
                this.turnosPenalizacion = 1;
                this.tiradaExtra = false;
                break;

            case "puente2":
                this.movimientoOrden = 7;
                this.turnosPenalizacion = 1;
                this.tiradaExtra = false;
                break;

            case "posada":
                this.movimientoOrden = 0;
                this.turnosPenalizacion = 1;
                this.tiradaExtra = false;
                break;

            case "pozo":
                this.movimientoOrden = 0;
                this.turnosPenalizacion = -1;
                this.tiradaExtra = false;
                break;

            case "laberinto":
                this.movimientoOrden = -12;
                this.turnosPenalizacion = 0;
                this.tiradaExtra = false;
                break;

            case "carcel":
                this.movimientoOrden = 0;
                this.turnosPenalizacion = 2;
                this.tiradaExtra = false;
                break;

            case "dados1":
                this.movimientoOrden = 26;
                this.turnosPenalizacion = 0;
                this.tiradaExtra = true;
                break;

            case "dados2":
                this.movimientoOrden = 56;
                this.turnosPenalizacion = 0;
                this.tiradaExtra = true;
                break;

            case "calavera":
                this.movimientoOrden = -57;
                this.turnosPenalizacion = 0;
                this.tiradaExtra = false;
                break;
        }
    }

    //Metodos setter
    public void setMovimientoOrden(int movimientoOrden) {
        this.movimientoOrden = movimientoOrden;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
    
    //Metodos getter
    public String getNombre() {
        return nombre;
    }

    public int getMovimientoOrden() {
        return movimientoOrden;
    }

    public int getTurnosPenalizacion() {
        return turnosPenalizacion;
    }

    public boolean isTiradaExtra() {
        return tiradaExtra;
    }

    public int getPosicion() {
        return posicion;
    }

    public Point getPoint() {
        return point;
    }
}
