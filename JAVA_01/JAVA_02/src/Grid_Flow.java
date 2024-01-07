import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;

/**
 * Grid_Flow
 */
public class Grid_Flow extends JFrame {
    public Grid_Flow() {
        this.setTitle("Ví Dụ Grid Flow");
        this.setVisible(true);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        GridLayout gridLayout = new GridLayout();
        this.setLayout(gridLayout);
        JButton jButtonOk = new JButton("Ok");
        JButton jButtonCancel = new JButton("Cancel");
        this.add(jButtonOk);
        this.add(jButtonCancel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Grid_Flow();
    }
}