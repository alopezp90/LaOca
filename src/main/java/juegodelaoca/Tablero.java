package juegodelaoca;

/**
 * Esta clase define el array de casillas que forma el tablero de La Oca.
 * Construye un array de 64 casillas con la disposicion de La Oca.
 *
 * @author Alberto López Puertas
 * <https://github.com/alopezp90>
 */
import java.awt.Point;

public class Tablero {

    //Instancia variables
    private Casilla[] tablero;

    /**
     * Constructor por defecto de Tablero. Recorre el array y crea un objeto
     * Casilla adecuado en cada posicion.
     */
    public Tablero() {

        this.tablero = new Casilla[64];
        generaCasillas();
        generaPosiciones();
        calculaOrdenesMovimiento();
    }

    private void generaPosiciones() {
        //Recorre el array dando valor a posicion y point de cada tablero
        for (int i = 1; i < 64; i++) {
            //Calcula x e y temporales
            int x;
            if (Math.ceil(i / 9.0) % 2 != 0) {  //En las filas pares
                x = (int) (20 + (100 * ((i - Math.floor((i - 1) / 9.0) * 9) - 1)));
            } else {                    //En las filas impares
                x = (int) (820 - (100 * ((i - Math.floor((i - 1) / 9.0) * 9) - 1)));
            }
            int y = (int) (715 - (100 * Math.ceil(i / 9.0)));  //Hay que corregir 5px hacia arriba (?)

            //Da los valores buscados a tablero
            tablero[i].setNumero(i);
            tablero[i].setPosicionRelativa(new Point(x, y));
        }
    }

    private void generaCasillas() {
        tablero[0] = new Casilla("salida");
        //Recorre el array creando la tablero adecuada en cada posicion
        for (int i = 0; i < 64; i++) {
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
                    tablero[i] = new Casilla("oca");
                    break;
                case 6:
                case 12:
                    tablero[i] = new Casilla("puente");
                    break;
                case 19:
                    tablero[i] = new Casilla("posada");
                    break;
                case 26:
                case 53:
                    tablero[i] = new Casilla("dados");
                    break;
                case 31:
                    tablero[i] = new Casilla("pozo");
                    break;
                case 42:
                    tablero[i] = new Casilla("laberinto");
                    break;
                case 56:
                    tablero[i] = new Casilla("carcel");
                    break;
                case 58:
                    tablero[i] = new Casilla("calavera");
                    break;
                case 63:
                    tablero[i] = new Casilla("final");
                    break;
                default:
                    tablero[i] = new Casilla();
                    break;
            }
        }
    }

    private void calculaOrdenesMovimiento() {
        for (int i = 1; i < 64; i++) {
            //Da movimientoOrden a las casillas oca, puente y dados
            switch (tablero[i].getNombre()) {
                case "oca":
                    tablero[i].setMovimientoOrden(nextOca(i));
                    break;
                case "puente":
                    tablero[i].setMovimientoOrden(nextPosada(i));
                    break;
                case "dados":
                    tablero[i].setMovimientoOrden(nextDados(i));
                    break;
            }
        }
    }

    /**
     * Metodo que cuenta el numero de casillas hasta la siguiente oca.
     *
     * @param i elemento de tablero desde el que empieza a contar.
     * @return n numero de casillas hasta la siguiente oca.
     */
    public int nextOca(int i) {
        int contador = 0;
        do {
            contador++;
        } while (i + contador <= 63 && !tablero[i + contador].getNombre().equals("oca"));

        return contador;
    }

    /**
     * Metodo que cuenta el numero de casillas hasta la siguiente posada.
     *
     * @param i elemento de tablero desde el que empieza a contar.
     * @return n numero de casillas hasta la siguiente posada.
     */
    public int nextPosada(int i) {
        int contador = 0;
        do {
            contador++;
        } while (!tablero[i + contador].getNombre().equals("posada"));

        return contador;
    }

    /**
     * Metodo que cuenta el numero de casillas hasta tablero dados.
     *
     * @param i elemento de tablero desde el que empieza a contar.
     * @return n numero de casillas hasta la tablero dados.
     */
    public int nextDados(int i) {
        int contador = 0;
        boolean found = false;  //true cuando se ha encontrado el siguiente dado

        //Busca siguiente tablero dados
        do {
            contador++;
            if (tablero[i + contador].getNombre().equals("dados")) {
                found = true;
            }
        } while (!found && (i + contador) < 63);

        //Si la encuentra devuelve el contador
        if (found) {
            return contador;

            //Si no la encuentra, busca la primera del tablero
        } else {
            contador = 0;
            do {
                contador++;
                if (tablero[contador].getNombre().equals("dados")) {

                    //Si la encuentra devuelve la distancia a retroceder
                    return contador - i;
                }
            } while (contador < 63);
        }
        return 0;   //nunca deberia ejecutar est linea
    }
    
    
    public Casilla getCasilla(int i) {
        return tablero[i];
    }

}
