import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.GridLayout;

/**
 * MayTinh
 */
public class MayTinh extends JFrame {

    public MayTinh() {
        this.setTitle("Máy Tính");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);

        // Tạo Layout
        JTextField jTextField = new JTextField();
        JPanel jPanelhead = new JPanel();
        jPanelhead.setLayout(new BorderLayout());
        jPanelhead.add(jTextField, BorderLayout.CENTER);
        // Tạo nút
        JButton jButton0 = new JButton("0");
        JButton jButton1 = new JButton("1");
        JButton jButton2 = new JButton("2");
        JButton jButton3 = new JButton("3");
        JButton jButton4 = new JButton("4");
        JButton jButton5 = new JButton("5");
        JButton jButton6 = new JButton("6");
        JButton jButton7 = new JButton("7");
        JButton jButton8 = new JButton("8");
        JButton jButton9 = new JButton("9");
        JButton jButtoncong = new JButton("+");
        JButton jButtontru = new JButton("-");
        JButton jButtonnhan = new JButton("*");
        JButton jButtonchia = new JButton("/");

        JPanel jPanelbutton = new JPanel();
        jPanelbutton.setLayout(new GridLayout());
        jPanelbutton.add(jButton0);
        jPanelbutton.add(jButton1);
        jPanelbutton.add(jButton2);
        jPanelbutton.add(jButton3);
        jPanelbutton.add(jButton4);
        jPanelbutton.add(jButton5);
        jPanelbutton.add(jButton6);
        jPanelbutton.add(jButton7);
        jPanelbutton.add(jButton8);
        jPanelbutton.add(jButton9);
        jPanelbutton.add(jButtoncong);
        jPanelbutton.add(jButtontru);
        jPanelbutton.add(jButtonnhan);
        jPanelbutton.add(jButtonchia);

        this.setLayout(new BorderLayout());
        this.add(jPanelhead, BorderLayout.NORTH);
        this.add(jPanelbutton, BorderLayout.CENTER);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MayTinh();
    }
}