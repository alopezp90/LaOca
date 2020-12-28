package oca.gui;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Use_PF_Interface extends JFrame {
    // instance variables - replace the example below with your own

    private JPanel panel2, panel1;
    private JLabel fondo = new JLabel();
    private JButton boton = new BotonDado(1);
    private JLabel ficha = new JLabel();

    /**
     * Constructor for objects of class Use_PF_Interface
     */
    public Use_PF_Interface() {
        setTitle("LaOca Alberto López");
        setSize(1360, 740);

        //initializes panels and panel layout
        panel2 = new JPanel();
        panel2.setBounds(1095, 615, 90, 105);   //No sé por qué hay que subirlo 5px
        panel2.setOpaque(false);
        panel2.setLayout(new FlowLayout());

        panel1 = new JPanel();
        panel1.setBounds(520, 515, 30, 36);   //No sé por qué hay que subirlo 5px
        panel1.setOpaque(false);
        panel1.setLayout(new FlowLayout());

        fondo.setLayout(new FlowLayout());

        //sets background image of panel
        fondo.setIcon(new ImageIcon("src/main/resources/TableroOcaGrande.png"));
        fondo.setLayout(null);

        //adds button to panels
        panel2.add(boton);

        fondo.add(panel2);

        ficha.setIcon(new ImageIcon("src/main/resources/FichaAzul.png"));
        ficha.setLocation(500, 500);
        panel1.add(ficha);

        fondo.add(panel1);

        add(fondo);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        pack();

    }

    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
////                try {
////                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
////                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
////                    ex.printStackTrace();
////                }
//
////                JFrame frame = new Use_PF_Interface();
////                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////                frame.pack();
////                frame.setLocationRelativeTo(null);
////                frame.setVisible(true);                
//            }
//        });

        JFrame frame = new Use_PF_Interface();
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.pack();
//                frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
