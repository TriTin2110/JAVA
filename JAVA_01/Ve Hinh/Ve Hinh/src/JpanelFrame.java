import java.awt.BorderLayout;

import javax.swing.JFrame;

public class JpanelFrame extends JFrame {
    public JpanelFrame() {
        this.setTitle("Vẽ Hình");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        VeHinh ve = new VeHinh();
        this.setLayout(new BorderLayout());
        this.add(ve, BorderLayout.CENTER);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JpanelFrame();
    }
}
