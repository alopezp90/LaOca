package juegodelaoca;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * @author Alberto López Puertas
 * <https://github.com/alopezp90>
 */
public class VentanaJuego extends JFrame implements ActionListener {

    private final int ANCHO = 1360, ALTO = 740;

    private ControladorJugadores controladorJugadores;
    private PanelDado panelDado;
    private PanelSalir panelSalir;
    private PanelLog panelLog;
    private Timer timer;
    private int contador;
    private Point vectorMovimiento;

    public VentanaJuego() {
        controladorJugadores = new ControladorJugadores(1);
        panelDado = new PanelDado(0);
        panelSalir = new PanelSalir();
        panelLog = new PanelLog();

        this.setUndecorated(true);
        this.setSize(ANCHO, ALTO);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        this.add(this.controladorJugadores.getTablero().getPanelTablero());
        this.controladorJugadores.getTablero().getPanelTablero().addPanel(
                this.controladorJugadores.getCurrent().getFicha());
        this.add(panelLog);
        this.add(panelDado);
        this.add(panelSalir);

        ActionListener exit = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        this.panelSalir.getBotonSalir().addActionListener(exit);

        timer = new Timer(100, this);
        contador = 0;
        this.panelDado.getBotonDado().addActionListener(this);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        timer.start();
        mueveFicha(controladorJugadores.getCurrent().getPosicion() + 4);
    }

    public void mueveFicha(int numeroCasilla) {
        int countEnd = 20;
        if (contador == 0) {

            //calcula vectorMovimiento
            vectorMovimiento = new Point(
                    (controladorJugadores.getTablero().getCasilla(numeroCasilla).getPosicionRelativa().x
                    - controladorJugadores.getCurrent().getFicha().getLocation().x) / countEnd,
                    (controladorJugadores.getTablero().getCasilla(numeroCasilla).getPosicionRelativa().y
                    - controladorJugadores.getCurrent().getFicha().getLocation().y) / countEnd
            );
            //realiza el primer movimiento
            controladorJugadores.getCurrent().getFicha().setLocation(
                    controladorJugadores.getCurrent().getFicha().getLocation().x
                    + vectorMovimiento.x,
                    controladorJugadores.getCurrent().getFicha().getLocation().y
                    + vectorMovimiento.y
            );
            //actualiza la ventana
            repaint();

            //actualiza el contador
            contador++;
        } else if (contador > 0 && contador < countEnd) {
            //realiza el movimiento
            controladorJugadores.getCurrent().getFicha().setLocation(
                    controladorJugadores.getCurrent().getFicha().getLocation().x
                    + vectorMovimiento.x,
                    controladorJugadores.getCurrent().getFicha().getLocation().y
                    + vectorMovimiento.y
            );
            //actualiza la ventana
            repaint();

            //actualiza el contador
            contador++;
        } else {
            //ultimo movimiento
            controladorJugadores.getCurrent().getFicha().setLocation(
                    controladorJugadores.getTablero().getCasilla(numeroCasilla).getPosicionRelativa()
            );
            //actualiza la ventana
            repaint();
            controladorJugadores.getCurrent().setPosicion(numeroCasilla);
            //cierra el timer
            timer.stop();
            contador = 0;
            System.out.println("Se ha terminado el movimiento");
            System.out.println("El jugador esta en la casilla: " + controladorJugadores.getCurrent().getPosicion());
        }
    }

    public static void main(String[] args) {
        VentanaJuego juego = new VentanaJuego();
        juego.controladorJugadores.getCurrent().setPosicion(1);
        juego.controladorJugadores.getCurrent().getFicha().setLocation(
                juego.controladorJugadores.getTablero().getCasilla(1).getPosicionRelativa()
        );
    }
}
