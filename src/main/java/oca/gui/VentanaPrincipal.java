package oca.gui;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.util.Random;

public class VentanaPrincipal extends JFrame implements ActionListener{

    //Declara constantes
    private final ImageIcon TABLERO = new ImageIcon("src/main/resources/TableroOcaGrande.png");
    private final int ANCHO = 1360, ALTO = 740;
    private final String titulo = "La Oca";

    //Inicializa las variables
    private PanelFicha panel0 = new PanelFicha(0);
    private PanelFicha panel1 = new PanelFicha(1);
    private PanelFicha panel2 = new PanelFicha(2);
    private PanelFicha panel3 = new PanelFicha(3);
    private PanelDado panelDado = new PanelDado();
    private PanelLog panelLog = new PanelLog();
    private JLabel fondo = new JLabel();
    
    private Random rd = new Random();

    //Constructor del JFrame
    public VentanaPrincipal() {

        //Parametros del JFrame
        this.setTitle(titulo);
        this.setSize(ANCHO, ALTO);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        //Configura imagen de fondo
        fondo.setLayout(new FlowLayout());
        fondo.setIcon(TABLERO);
        fondo.setLayout(null);
                
        //Añade los JPanel sobre el fondo
        fondo.add(panel0);
        fondo.add(panel1);
        fondo.add(panel2);
        fondo.add(panel3);
        fondo.add(panelDado);
        fondo.add(panelLog);
        
        //Añade ActionListener al boton
        this.getPanelDado().getBotonDado().addActionListener(this);

        //Añade el fondo sobre el JFrame
        this.add(fondo);
    }
    
    //Metodos getter necesarios para modificar los JPanels mediante sus metodos de clase
    public PanelFicha getPanel0() {
        return panel0;
    }

    public PanelFicha getPanel1() {
        return panel1;
    }

    public PanelFicha getPanel2() {
        return panel2;
    }

    public PanelFicha getPanel3() {
        return panel3;
    }

    public PanelDado getPanelDado() {
        return panelDado;
    }

    public PanelLog getPanelLog() {
        return panelLog;
    }
    
    //ActionEvent del boton
    @Override
    public void actionPerformed(ActionEvent e) {
        this.getPanelDado().cambiaColor(rd.nextInt(4));
    }
    
    public static void main(String[] args) {
        VentanaPrincipal frame = new VentanaPrincipal();
        frame.pack();
        frame.setVisible(true);
    }
}
