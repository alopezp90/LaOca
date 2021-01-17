package juegodelaoca;

/**
 * Este enum define los tipos de casilla posibles en el juego de La Oca.
 *
 * @author Alberto López Puertas
 * <https://github.com/alopezp90>
 */
public enum TipoCasilla {

    NORMAL("normal", false, false, 0, null),
    OCA("oca", true, false, 0, "<em>¡De oca en oca y tiro porque me toca!<em>"),
    PUENTE("puente", true, true, 0, "<em>¡De puente a puente y tiro porque me lleva la corriente!<em>"),
    POSADA("posada", false, false, 1, "<em>Te quedas a dormir en la posado un turno.<em>"),
    POZO("pozo", false, false, -1, "<em>¡Oh no! Estás atrapado en el pozo hasta que te rescaten.</em>"),
    LABERINTO("laberinto", true, false, 0, "<em>Salir del laberinto te hace retroceder 12 casillas.</em>"),
    CARCEL("cárcel", false, false, 2, "<em>Vas a la cárcel y pierdes dos turnos.</em>"),
    DADOS("dados", true, true, 0, "<em>¡De dado en dado y tiro porque me ha tocado!<em>"),
    CALAVERA("calavera", true, false, 0, "<em>¡Oh no! MUERTE. Vuelves al principio.</em>");

    private String nombre;
    private boolean ordenaMovimiento;
    private boolean tiradaExtra;
    private int penalizacion;
    private String texto;

    /**
     * Constructor del enum TipoCasilla.
     *
     * @param nombre String - Nombre asignado al tipo de casilla
     * @param ordenaMovimiento boolean - true si fuerza a movimiento posterior
     * al jugador que caiga en ella
     * @param tiradaExtra boolean - true si da otra tirada al jugador que caiga
     * en ella
     * @param penalizacion int - turnos que perdera el jugador que caiga en la
     * casilla, -1 para turnos indefinidos
     * @param texto String - texto asignado al efecto de la casilla
     */
    private TipoCasilla(String nombre, boolean ordenaMovimiento, boolean tiradaExtra, int penalizacion, String texto) {
        this.nombre = nombre;
        this.ordenaMovimiento = ordenaMovimiento;
        this.tiradaExtra = tiradaExtra;
        this.penalizacion = penalizacion;
    }
}
