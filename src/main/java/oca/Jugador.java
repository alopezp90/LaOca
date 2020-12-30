package oca;

/**
 * Esta clase almacena la informacion sobre los jugadores y metodos para 
 * modificarla
 *
 * @author Alberto López Puertas
 * <https://github.com/alopezp90>
 */
import java.util.Random;

public class Jugador {

    private String nombre;      //Nombre del jugador
    private int numero;         //Numero del jugador, se corresponde con su color
    private int posicion;       //Posicion del tablero que ocupa el jugador (comienza a 0)
    private int penalizacion;   //Turnos de penalizacion que tiene el jugador
    private int turno;          //Cuantas tiradas le quedan al jugador
    private int tirada;         //Ultimo lanzamiento de dado del jugador

    /**
     * Constructor por defecto de Jugador. Inicializa los parametros como:
     * <ul>
     * <li>nombre en blanco.</li>
     * <li>posicion a 0.</li>
     * <li>penalizacion a 0.</li>
     * </ul>
     */
    public Jugador() {
        this.nombre = "";
    }

    /**
     * Constructor parametrizado de Jugador. Inicializa el nombre del jugador,
     * todo lo demas por defecto.
     *
     * @param nombre nombre del jugador
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    //Metodos setter y getter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getTirada() {
        return tirada;
    }

    public void setTirada(int tirada) {
        this.tirada = tirada;
    }

    /**
     * Metodo que reduce en un turno la penalizacion del jugador.
     */
    public void reducePenalizacion() {
        this.penalizacion--;
    }

    /**
     * Metodo que reduce en uno los turnos del jugador y anota en tirada un
     * aleatorio entre 1 y 6.
     *
     * @return this.tirada
     */
    public int tiraDado() {
        this.turno--;
        Random rd = new Random();
        this.tirada = rd.nextInt(6) + 1;
        
        return this.tirada;
    }

    /**
     * Metodo que comprueba si al jugador no le quedan tiradas y se encuentra en
     * la casilla final.
     *
     * @return true si ha ganado la partida
     */
    public boolean esGanador() {
        return this.tirada == 0 && this.posicion == 63;
    }
    
    /**
     * Metodo que devuelve el encabezado para el Log y da turno.
     * Contiene el nombre del jugador con la fuente en su color (html)
     * 
     * @return String html
     */
    public String comienza() {
        String texto = "<strong><font color='";
        switch(this.numero) {
            case 0:
                texto = texto + "blue";
                break;
            case 1:
                texto = texto + "orange";
                break;
            case 2:
                texto = texto + "red";
                break;
            case 3:
                texto = texto + "green";
                break;
        }
        texto = texto + "'>" + this.nombre + ":</font></strong>";
        if (this.penalizacion == 0) {
            this.turno++;
        }
        return texto;
    }

    /**
     * Metodo que comprueba el estado del Jugador al comienzo de su turno.
     * 
     * @param tablero array con la informacion de las casillas
     * @return String con posicion y penalizacion.
     */
    public String estado(Tablero tablero) {
        
        String texto = "Se encuentra en la casilla " + tablero.getCasilla(this.posicion).getNombre()
                + " número " + this.posicion;
        
        switch (this.penalizacion){
            case -1:
                texto = texto + " y no podrá salir hasta que le rescaten.";
                break;
            case 1:
                reducePenalizacion();
                texto = texto + " y terminará su penalización este turno.";
                break;
            case 2:
                reducePenalizacion();
                texto = texto + ", está penalizado y le queda aún un turno más.";
                break;
            default:
                texto = texto + ". Puede tirar el dado.";
        }
        return texto;
    }
    
    /**
     * Metodo que cambia la posicion del Jugador según su última tirada de dados
     * y actualiza el estado del jugador en función de la casilla en que haya
     * caido.
     *
     * @param tablero array con la informacion de las casillas
     * @param jugadores array con la informacion de los jugadores
     * @return String con nueva posicion y estado
     */
    public String moverDado(Tablero tablero, Jugador[] jugadores) {
        String texto = "";
        
        int inicio = this.posicion; //Posicion antes de empezar el movimiento
        
        this.mover(this.tirada);
        
        if (hayRescate(inicio, jugadores)) {
            texto = texto + "<strong>¡Ha rescatado a los jugadores atrapados en el pozo!</strong><br/>";
        }
        
        texto = texto + "Ha llegado a la casilla " + tablero.getCasilla(this.posicion).getNombre()
                + " número " + this.posicion + ".";
//        if (tablero.getCasilla(this.posicion).getMovimientoOrden() > 0) {
//            texto = texto + " Debe avanzar " + tablero.getCasilla(this.posicion).getMovimientoOrden() + " casillas";
//            if (tablero.getCasilla(this.posicion).isTiradaExtra()) {
//                this.turno++;
//                texto = texto + " y volver a tirar.<br/>";
//            } else if (tablero.getCasilla(this.posicion).getTurnosPenalizacion() > 0) {
//                this.penalizacion += tablero.getCasilla(this.posicion).getTurnosPenalizacion();
//                texto = texto + " y esperar " + this.penalizacion + " turnos.<br/>";
//            } else if (tablero.getCasilla(this.posicion).getTurnosPenalizacion() < 0) {
//                this.penalizacion = tablero.getCasilla(this.posicion).getTurnosPenalizacion();
//                texto = texto + " y esperar un rescate.<br/>";
//            } else {
//                texto = texto + ".<br/>";
//            }
//            texto = texto + mover(tablero, jugadores, tablero.getCasilla(this.posicion).getMovimientoOrden());
//        }
        return texto;
    }
    
    /**
     * Metodo que comprueba si el jugador ha caido en una casilla con orden de 
     * movimiento, de ser asi actualiza su posicion y estado.
     * 
     * @param tablero array con la informacion de las casillas
     * @param jugadores array con la informacion de los jugadores
     * @return String con nueva posicion y estado
     */
    public String actualizaEstado(Tablero tablero, Jugador[] jugadores) {
        String texto = "";
        
        if (tablero.getCasilla(this.posicion).getMovimientoOrden() > 0) {
            switch (tablero.getCasilla(this.posicion).getNombre()){
                case "oca":
                    texto = texto + "<em>¡De oca en oca y tiro por que me toca!</em>";
                    this.turno++;       //Asigna otro turno
                    break;
                case "puente":
                    texto = texto + "Avanza hasta la posada, pero pierde un turno.";
                    this.penalizacion++;//Asigna turno de penalizacion
                    break;
                case "dados":
                    texto = texto + "Avanza " + tablero.getCasilla(this.posicion).getMovimientoOrden() + " y tira otra vez.";
                    this.turno++;       //Asigna otro turno
                    break;
            }
            this.mover(tablero.getCasilla(this.posicion).getMovimientoOrden());
            
        } else if (tablero.getCasilla(this.posicion).getMovimientoOrden() < 0) {
            switch (tablero.getCasilla(this.posicion).getNombre()) {
                case "laberinto":
                    texto = texto + "Retrocede hasta la casilla 30.";
                    break;
                case "calavera":
                    texto = texto + "¡Tiene que retroceder hasta la primera casilla!";
                    break;
            }
            this.mover(tablero.getCasilla(this.posicion).getMovimientoOrden());
            
        } else {
            switch (tablero.getCasilla(this.posicion).getTurnosPenalizacion()) {
                
            }
        }
        
        
        return texto;
    }
    
    /**
     * Metodo que cambia la posicion del jugador, avanzando o retrocediendo 
     * la cantidad indicada.
     * 
     * @param cantidad numero de casillas a mover
     */
    public void mover(int cantidad) {
        if (this.posicion + cantidad > 63) {
            this.posicion = 126 - cantidad - this.posicion; //63 - (cantidad -(63 - this.posicion));
        } else {
            this.posicion += cantidad;
        }
    }
    
    /**
     * Metodo que comprueba si el jugador pasa por el pozo, de hacerlo rescata 
     * a todos los que haya atrapados.
     * 
     * @param inicio casilla desde la que empieza a moverse el jugador en turno
     * @param jugadores array que contiene a todos los jugadores
     * @return 
     */
    public boolean hayRescate(int inicio, Jugador[] jugadores) {
        boolean rescate = false;
        if ((inicio < 31 && this.posicion > 31) || (inicio > 31 && this.posicion < 31)) {
            for (int i = 0; i < jugadores.length; i++) {
                if (jugadores[i].posicion == 31) {
                    jugadores[i].penalizacion = 0;
                    rescate = true;
                }
            }
        } 
        return rescate;
    }
}
