package oca;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
import java.awt.*;
import javax.swing.*;

public class BarraLateral extends JPanel {
    
    private final int ANCHO_BARRA = 440;
    private final int ALTO_BARRA = 740;
    private final int ANCHO_BOTON = 80;
    private final int ALTO_BOTON = 80;
    private final int ANCHO_SCROLL = 400;
    private final int ALTO_SCROLL = 600;
    
    private JScrollPane historialScroll;
    private JButton boton;
    private String texto;

    public BarraLateral(String texto) {
        this.texto = texto;

        this.setSize(ANCHO_BARRA, ALTO_BARRA);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        this.historialScroll = inicializarHistorial();
        
        boton = new JButton("Tirar");
        boton.setSize(ANCHO_BOTON, ALTO_BOTON);
        
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        this.add(this.historialScroll);
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        this.add(boton);
        this.add(Box.createRigidArea(new Dimension(0, 20)));
    }
    
    private JScrollPane inicializarHistorial(){
        JLabel jlabel = new JLabel(this.texto);
        jlabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        
        JScrollPane scroll = new JScrollPane(jlabel);
        scroll.setPreferredSize(new Dimension(ANCHO_SCROLL, ALTO_SCROLL));
        
        return scroll;        
    }
}
