package oca;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
import java.util.Random;

public class Jugar {

    private static int jugadores;
    private static boolean ganador = false;

    public static void main(String[] args) {
        //inicializa el tablero
        Tablero tablero = new Tablero();

        //inicializa numero de jugadores
        jugadores = 4;

        //inicializa posicion[] y puedeTirar[]
        int[] posicion = new int[jugadores];
        boolean[] puedeTirar = new boolean[jugadores];

        //loop de juego
        while (!ganador) {
            for (int i = 0; i < jugadores; i++) {
                puedeTirar[i] = actualizaEstado(puedeTirar[i]);
                juega(i);
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
