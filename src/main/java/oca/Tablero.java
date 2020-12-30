package oca;


/**
 * Una clase para definir el array de casillas que forma el tablero de La Oca.
 * Construye un array de 64 casillas con la disposicion de La Oca.
 * 
 * @author Alberto López Puertas
 * <https://github.com/alopezp90>
 */

import java.awt.Point;

public class Tablero {

    //Instancia variables
    private Casilla[] casilla;

    /**
     * Constructor por defecto de Tablero.
     * Recorre el array y crea un objeto Casilla adecuado en cada posicion.
     */
    public Tablero() {

        this.casilla = new Casilla[64];
        
        //Recorre el array creando la casilla adecuada en cada posicion
        casilla[0] = new Casilla("salida");
        for (int i = 1; i < 64; i++) {
            switch (i) {
                case 5:
                case 9:
                case 14:
                case 18:
                case 23:
                case 27:
                case 32:
                case 36:
                case 41:
                case 45:
                case 50:
                case 54:
                case 59:
                    casilla[i] = new Casilla("oca");
                    break;
                case 6:
                case 12:
                    casilla[i] = new Casilla("puente");
                    break;
                case 19:
                    casilla[i] = new Casilla("posada");
                    break;
                case 26:
                case 53:
                    casilla[i] = new Casilla("dados");
                    break;
                case 31:
                    casilla[i] = new Casilla("pozo");
                    break;
                case 42:
                    casilla[i] = new Casilla("laberinto");
                    break;
                case 56:
                    casilla[i] = new Casilla("carcel");
                    break;
                case 58:
                    casilla[i] = new Casilla("calavera");
                    break;
                default:
                    casilla[i] = new Casilla();
                    break;
            }
        }
        
        //Recorre el array dando valor a posicion y point de cada casilla
        for (int i = 1; i < 64; i++) {
            //Calcula x e y temporales
            int x;
            if (Math.ceil(i/9.0) % 2 != 0){  //En las filas pares
                x = (int) (20 + (100 * ((i - Math.floor((i - 1)/9.0) * 9) - 1)));
            } else {                    //En las filas impares
                x = (int) (820 - (100 * ((i - Math.floor((i - 1)/9.0) * 9) - 1)));
            }
            int y = (int) (715 - (100 * Math.ceil(i/9.0)));  //Hay que corregir 5px hacia arriba (?)
            
            //Da los valores buscados a casilla
            casilla[i].setPosicion(i);
            casilla[i].setPoint(new Point(x, y));   
        }
    }

    public Casilla getCasilla(int i) {
        return casilla[i];
    }
    
    /**
     * Metodo que cuenta el numero de casillas hasta la siguiente oca.
     * @param i elemento de tablero desde el que empieza a contar.
     * @return n numero de casillas hasta la siguiente oca.
     */
    public int nextOca(int i) {
        return 0;
    }
}
