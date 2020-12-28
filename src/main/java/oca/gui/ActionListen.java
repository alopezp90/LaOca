package oca.gui;

/**
 * @author Alberto López Puertas 
 * <alopezp90@gmail.com>
 */
import java.awt.*;
import java.awt.event.*;

public class ActionListen extends Frame implements ActionListener {
        TextField text = new TextField(20);
        Button b;
        private int numClicks = 0;

        public static void main(String[] args) {
                ActionListen myWindow = new ActionListen("My first window");
                myWindow.setSize(350,100);
                myWindow.setVisible(true);
        }

        public ActionListen(String title) {

                super(title);
                setLayout(new FlowLayout());
                b = new Button("Click me");
                add(b);
                add(text);
                b.addActionListener(this);
        }

        public void actionPerformed(ActionEvent e) {
                numClicks++;
                text.setText("Button Clicked " + numClicks + " times");
        }


}
