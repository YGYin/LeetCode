package javase.draw;

import javax.swing.*;
import java.awt.*;

// The Window / Frame outside the Panel
public class DrawTest extends JFrame {
    private MyPanel myPanel = null;

    public static void main(String[] args) {
        new DrawTest();

        System.out.println("Exit");
    }

    public DrawTest() {
        // Initialize a panel
        myPanel = new MyPanel();
        // Put the panel into the Window
        this.add(myPanel);
        // Set the size of window
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanel extends JPanel {

    // Graphics likes a pen, it provides a lot of methods for drawing
    @Override
    public void paint(Graphics g) {
        super.paint(g); // initialize
        g.drawOval(10, 10, 100, 100);
    }
    /*
        When setVisible(true) at the first time, paint() would be invoked for drawing item
        3 situations that the paint() would be invoked
        1. Minimize the window, then maximize the window
        2. The size of window is changed
        3. repaint() is invoked
     */
}