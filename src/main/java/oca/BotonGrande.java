package oca;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
import java.awt.Color;
import javax.swing.*;

public class BotonGrande {

//    JFrame frame;
//    JPanel panel;
//    JButton button;
    public static void main(String[] args) {

//        BotonGrande jbd = new BotonGrande();
//        jbd.frame = new JFrame("FirstFrame");
//        jbd.frame.setVisible(true);
//        jbd.frame.setSize(300, 300);
//        jbd.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jbd.frame.setResizable(false);
//
//        jbd.button = new JButton("Click Me !!");
//        jbd.button.setBackground(Color.red);
//
//        jbd.frame.add(jbd.button);
        JFrame frame = new JFrame("Titulo");
        frame.setSize(240, 240);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JButton boton = new JButton("TIRAR");
        boton.setBackground(Color.pink);

        frame.add(boton);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
