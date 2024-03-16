import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * VeHinh
 */
public class VeHinh extends JPanel {

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillOval(50, 50, 150, 50);
    }
}