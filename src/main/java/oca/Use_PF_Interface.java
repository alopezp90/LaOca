package oca;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
import javax.swing.*;
import java.awt.*;

public class Use_PF_Interface extends JFrame {
    // instance variables - replace the example below with your own

    private JPanel panel2;
    private BarraLateral barra;
    private JLabel lblBackgroundImage = new JLabel();
    private JButton feedButton = new JButton("Feed Fish");
    private JButton playGamesButton = new JButton("Play Game");

    /**
     * Constructor for objects of class Use_PF_Interface
     */
    public Use_PF_Interface() {
        setTitle("Virtual Pet Fish");
        setSize(1360, 740);

        //initializes panels and panel layout
        panel2 = new JPanel();
        panel2.setOpaque(false);
        panel2.setLayout(new FlowLayout());

        lblBackgroundImage.setLayout(new FlowLayout());

        //sets background image of panel
        lblBackgroundImage.setIcon(new ImageIcon("src/main/resources/TableroOca.png"));
        lblBackgroundImage.setLayout(new BorderLayout());

//        //adds button to panels
//        panel2.add(feedButton);
//        panel2.add(playGamesButton);

        lblBackgroundImage.add(panel2);

        add(lblBackgroundImage);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new Use_PF_Interface();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}