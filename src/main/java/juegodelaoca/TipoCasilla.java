package juegodelaoca;

/**
 * Este enum define los tipos de casilla posibles en el juego de La Oca.
 *
 * @author Alberto López Puertas
 * <https://github.com/alopezp90>
 */
public enum TipoCasilla {

    NORMAL("normal", false, false, 0, null),
    OCA("oca", true, false, 0, "<em>¡De oca en oca y tiras porque te toca!<em>"),
    PUENTE("puente", true, false, 0, "<em>¡De puente a puente y tiras porque te lleva la corriente!(O NO)<em>"),
    POSADA("posada", false, false, 1, "<em>Te quedas a dormir en la posado un turno.<em>"),
    POZO("pozo", false, false, -1, "<em>¡Oh no! Estás atrapado en el pozo hasta que te rescaten.</em>"),
    LABERINTO("laberinto", true, false, 0, "<em>Salir del laberinto te hace retroceder 12 casillas.</em>"),
    CARCEL("cárcel", false, false, 2, "<em>Vas a la cárcel y pierdes dos turnos.</em>"),
    DADOS("dados", true, false, 0, "<em>¡De dado en dado y tiras porque te ha tocado!(O NO)<em>"),
    CALAVERA("calavera", true, false, 0, "<em>¡Oh no! MUERTE. Vuelves al principio.</em>"),
    JARDIN("jardin", false, false, 0, null);

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
        this.texto = texto;
    }

    /**
     * Devuelve el nombre asociado a ese TipoCasilla
     *
     * @return String - nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Informa de si el TipoCasilla asigna orden de movimiento posterior
     *
     * @return true - si ordena moverse al jugador
     */
    public boolean isOrdenaMovimiento() {
        return ordenaMovimiento;
    }

    /**
     * Informa de si el TipoCasilla da tirada extra posteriormente
     *
     * @return true - si permite tirar otra vez.
     */
    public boolean isTiradaExtra() {
        return tiradaExtra;
    }

    /**
     * Devuelve los turnos de penalizacion asociado al TipoCasilla.
     *
     * @return int - turnos de penalizacion despues de este. -1 indica
     * penalizacion permanente hasta que se cumplan otras condiciones
     */
    public int getPenalizacion() {
        return penalizacion;
    }

    /**
     * Devuelve la cadena con el texto asociado al TipoCasilla.
     * 
     * @return String - texto 
     */
    public String getTexto() {
        return texto;
    }
}
