package oca;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
import java.util.Random;

public class Jugar {

    private static int numPlayer;
    private static boolean ganador = false;

    public static void main(String[] args) {
        //inicializa el tablero
        Tablero tablero = new Tablero();

        //inicializa numero de jugadores        
        numPlayer = 4;

        //inicializa jugadores[]
        //Jugador[] player = new Jugador[numPlayer];

        //loop de juego
        while (!ganador) {
            for (int i = 0; i < numPlayer; i++) {
                //Actualiza el estado del jugador[i] antes de turno
                //Redibuja la ventana con los datos de i
                //Dados
                //Comprueba si pasa por POZO (31), si lo hace, comprueba si habia alguien y actualiza su estado
                //Actualiza el estado del jugador tras el turno (con bucle por si debe volver a tirar)
                //Redibuja la ventana tras la tirada
                
                //Si hay ganador, para, sino, pasa a i+1
                if (ganador) {
                    break;
                }
            }
        }

    }

    public static int tiraDado() {
        Random rd = new Random();
        return rd.nextInt(6) + 1;
    }
}
