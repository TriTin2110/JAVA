package Menu.Icon;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class IconView extends JFrame {
        JLabel jLabel = new JLabel();

        public IconView() {
                this.init();
                this.setVisible(true);
        }

        /**
         * init()
         */
        public void init() {
                this.setTitle("Icon");
                this.setSize(800, 600);
                this.setLocationRelativeTo(null);
                this.setDefaultCloseOperation(EXIT_ON_CLOSE);
                this.setLayout(new BorderLayout());

                // Tạo thanh menu
                JMenuBar jMenuBar = new JMenuBar();
                this.setIconImage(new ImageIcon(IconView.class.getResource("VietNam.png")).getImage());
                JMenu jMenuFile = new JMenu("Tệp tin");
                JMenu jMenuEdit = new JMenu("Chỉnh sửa");
                JMenu jMenunGuide = new JMenu("Hướng dẫn");

                JMenuItem jMenuItemOpen = new JMenuItem("Mở");
                jMenuItemOpen.setIcon(new ImageIcon(IconView.class.getResource("new.png")));
                JMenuItem jMenuItemSave = new JMenuItem("Lưu");
                jMenuItemSave.setIcon(new ImageIcon(IconView.class.getResource("save.png")));

                jMenuFile.add(jMenuItemOpen);
                jMenuFile.add(jMenuItemSave);
                jMenuBar.add(jMenuFile);
                jMenuBar.add(jMenuEdit);
                jMenuBar.add(jMenunGuide);

                this.setJMenuBar(jMenuBar);

                // Tạo Jlabel
                this.add(jLabel, BorderLayout.CENTER);

                // Tạo nút
                JButton jButtonTest = new JButton("Test");
                jButtonTest.setPreferredSize(new Dimension(800, 100));
                jButtonTest.setFont(new Font("Times new roman", Font.BOLD, 20));
                this.add(jButtonTest, BorderLayout.SOUTH);
        }

}
