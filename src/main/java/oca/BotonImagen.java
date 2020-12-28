package oca;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
public class BotonImagen {

    public static void main(String[] args) {
        
        JButton btnNewButton = new JButton("");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        
        JFrame frame = new JFrame();
        frame.setSize(1360, 740);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);

        btnNewButton.setIcon(new ImageIcon("src/main/resources/DadoRojo100.png"));
        btnNewButton.setBounds(1095, 620, 90, 100);
        btnNewButton.setBorder(BorderFactory.createEmptyBorder());
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setFocusable(false);
        //frame.add(btnNewButton);
        
        
        JLabel fondo = new JLabel();
        fondo.setLayout(new FlowLayout());
        fondo.setIcon(new ImageIcon("src/main/resources/TableroOca.png"));
        fondo.setLayout(null);
        
        fondo.add(btnNewButton);

        frame.add(fondo);
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        
        frame.setVisible(true);
        
    }
}
