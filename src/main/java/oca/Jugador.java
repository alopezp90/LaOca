package oca;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
public class Jugador {

    private String nombre;
    private int posicion, penalizacion;
    private boolean ganador;

    public Jugador() {
        this.nombre = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getPenalizacion() {
        return penalizacion;
    }

    public void setPenalizacion(int penalizacion) {
        this.penalizacion = penalizacion;
    }

    public boolean isGanador() {
        return ganador;
    }

    public void setGanador(boolean ganador) {
        this.ganador = ganador;
    }

    //Métodos
    public void mover(int cantidad) {
        if (this.posicion + cantidad < 1) {   //No deberia pasar nunca
            this.posicion = 0;
        } else if (this.posicion + cantidad > 63) {
            this.posicion = 126 - cantidad - this.posicion; //63 - (cantidad -(63 - this.posicion));
        } else {
            this.posicion += cantidad;
        }
    }

    public void reducePenalizacion() {
        this.penalizacion--;
    }

}
