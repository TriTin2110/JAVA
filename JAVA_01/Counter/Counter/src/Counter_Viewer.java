import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Counter_Viewer extends JFrame {
    public Counter ct;
    private JButton jButtonTang;
    private JButton jButtonGiam;
    private JButton jButtonReset;
    private JLabel jLabel;

    public Counter_Viewer() {
        this.ct = new Counter();
        this.init();
    }

    public void init() {
        this.setTitle("Đếm Số");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);

        Counter_Listener cListener = new Counter_Listener(this);
        // Tạo nút
        jButtonTang = new JButton("Tăng");
        jButtonTang.addActionListener(cListener);
        jButtonGiam = new JButton("Giảm");
        jButtonGiam.addActionListener(cListener);
        jLabel = new JLabel(this.ct.getN() + "", jLabel.CENTER);
        jButtonReset = new JButton("Reset");
        jButtonReset.addActionListener(cListener);

        // Tạo Panel
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.add(jButtonTang, BorderLayout.WEST);
        jPanel.add(jButtonGiam, BorderLayout.EAST);
        jPanel.add(jLabel, BorderLayout.CENTER);
        jPanel.add(jButtonReset, BorderLayout.SOUTH);
        this.setLayout(new BorderLayout());
        this.add(jPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void Tang() {
        this.ct.Tang();
        jLabel.setText(this.ct.getN() + " ");
    }

    public void Giam() {
        this.ct.Giam();
        jLabel.setText(this.ct.getN() + " ");
    }

    public void Reset() {
        this.ct.Reset();
        jLabel.setText(this.ct.getN() + " ");
    }
}
