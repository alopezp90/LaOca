package oca;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
public class Tablero {

    private Casilla[] casilla;

    public Tablero() {

        this.casilla = new Casilla[64];
        
        casilla[0] = new Casilla("salida");

        for (int i = 0; i < 64; i++) {
            switch (i) {
                case 5:
                case 14:
                case 23:
                case 32:
                case 41:
                case 50:
                case 59:
                    casilla[i] = new Casilla("oca1");
                    break;
                case 9:
                case 18:
                case 27:
                case 36:
                case 45:
                case 54:
                    casilla[i] = new Casilla("oca2");
                    break;
                case 6:
                    casilla[i] = new Casilla("puente1");
                    break;
                case 12:
                    casilla[i] = new Casilla("puente2");
                    break;
                case 26:
                    casilla[i] = new Casilla("dados1");
                    break;
                case 31:
                    casilla[i] = new Casilla("pozo");
                    break;
                case 42:
                    casilla[i] = new Casilla("laberinto");
                    break;
                case 53:
                    casilla[i] = new Casilla("dados2");
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
            if (i != 0){
                casilla[i].setPosicionY(50 + (int) (i/9) * 100);

                if (i/9 % 2 == 0){
                    casilla[i].setPosicionX(50 + 100 * (i - (9 * (int) (i/9))));
                } else {
                    casilla[i].setPosicionX(850 - 100 * (i - (9 * (int) (i/9))));
                }
            }
        }
    }

    public Casilla[] getCasilla() {
        return casilla;
    }
}
