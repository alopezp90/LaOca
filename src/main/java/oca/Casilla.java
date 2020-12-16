package oca;

/**
 * @author Alberto López Puertas 
 * <alopezp90@gmail.com>
 */

public class Casilla {
    
    private String nombre;
    private int movimientoOrden, turnosPenalizacion;
    private boolean tiradaExtra;
    
    public Casilla(){
        this.nombre = "";
    }
    
    public Casilla (String nombre){
        this.nombre = nombre;
        
        switch (nombre){
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
                this.movimientoOrden = 26;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMovimientoOrden() {
        return movimientoOrden;
    }

    public void setMovimientoOrden(int movimientoOrden) {
        this.movimientoOrden = movimientoOrden;
    }

    public int getTurnosPenalizacion() {
        return turnosPenalizacion;
    }

    public void setTurnosPenalizacion(int turnosPenalizacion) {
        this.turnosPenalizacion = turnosPenalizacion;
    }

    public boolean isTiradaExtra() {
        return tiradaExtra;
    }

    public void setTiradaExtra(boolean tiradaExtra) {
        this.tiradaExtra = tiradaExtra;
    }

}
