package src;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class MainMenu {
        public static void main(String[] args) {
                new MenuView();
        }
}

/**
 * MenuView ex
 */
class MenuView extends JFrame {
        JLabel jLabel = new JLabel("", JLabel.CENTER);
        JPopupMenu jpoPopupMenu;
        private JToolBar jToolBar;

        public MenuView() {
                this.init();
                this.setVisible(true);
        }

        private void init() {
                this.setTitle("Test Menu!");
                this.setSize(800, 600);
                this.setLocationRelativeTo(null);
                this.setDefaultCloseOperation(EXIT_ON_CLOSE);
                this.setLayout(new BorderLayout());

                ControllerMenu controllerMenu = new ControllerMenu(this);

                // Thiết lập phần menu
                JMenuBar jMenuBar = new JMenuBar();

                JMenu jMenuFile = new JMenu("Tệp tin");
                JMenuItem jMenuOpean = new JMenuItem("Mở", KeyEvent.VK_M);
                jMenuOpean.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK));
                jMenuOpean.addActionListener(controllerMenu);
                JMenuItem jMenuExit = new JMenuItem("Thoát", KeyEvent.VK_X);
                jMenuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_DOWN_MASK));
                jMenuExit.addActionListener(controllerMenu);

                JMenu jMenuHelp = new JMenu("Trợ giúp");
                jMenuHelp.setMnemonic(KeyEvent.VK_T);
                JMenuItem jMenuWelCome = new JMenuItem("Giới thiệu", KeyEvent.VK_G);
                jMenuWelCome.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));

                JMenu jmenuView = new JMenu("Hiển thị");
                JCheckBoxMenuItem jCheckBoxHienThiThanhCongCu = new JCheckBoxMenuItem("Hiển thị thanh công cụ");
                jCheckBoxHienThiThanhCongCu.addActionListener(controllerMenu);
                // Cài đặt cho jCheckBoxHienThiThanhCongCu được check ngay khi khởi động chương
                // trình
                jCheckBoxHienThiThanhCongCu.setSelected(true);
                jmenuView.add(jCheckBoxHienThiThanhCongCu);

                jMenuWelCome.addActionListener(controllerMenu);

                // Thêm toolBar cho chương trình
                jToolBar = new JToolBar();
                JButton jButtonCut = new JButton("Cut");
                JButton jButtonCopy = new JButton("Copy");
                JButton jButtonPaste = new JButton("Paste");
                jToolBar.add(jButtonCut);

                // Thiết lập tittle cho button
                jButtonCut.setToolTipText("Cắt đoạn");
                jButtonCut.addActionListener(controllerMenu);

                jToolBar.add(jButtonCopy);
                jButtonCopy.setToolTipText("Sao chép đoạn");
                jButtonCopy.addActionListener(controllerMenu);

                jToolBar.add(jButtonPaste);
                jButtonPaste.setToolTipText("Dán đoạn");
                jButtonPaste.addActionListener(controllerMenu);

                // Phần Menu
                jMenuFile.add(jMenuOpean);
                jMenuFile.addSeparator();
                jMenuFile.add(jMenuExit);
                jMenuHelp.add(jMenuWelCome);
                jMenuBar.add(jMenuFile);
                jMenuBar.add(jmenuView);
                jMenuBar.add(jMenuHelp);

                // Menu chuột phải
                jpoPopupMenu = new JPopupMenu();
                JMenu jMenuCoChu = new JMenu("Cỡ chữ");
                jMenuCoChu.setMnemonic(KeyEvent.VK_C);

                JMenuItem jMenuItemTang = new JMenuItem("Tăng cỡ chữ");
                JMenuItem jMenuItemGiam = new JMenuItem("Giảm cỡ chữ");
                jMenuCoChu.add(jMenuItemTang);
                jMenuItemTang.addActionListener(controllerMenu);
                jMenuCoChu.add(jMenuItemGiam);
                jMenuItemGiam.addActionListener(controllerMenu);
                jpoPopupMenu.add(jMenuCoChu);
                // jMenuBar.add(jMenuCoChu);
                SuKienChuot mouseListen = new SuKienChuot(this);

                // Thêm sự kiện click chuột vào đối tượng MenuView
                this.addMouseListener(mouseListen);
                this.add(jpoPopupMenu);
                this.add(jToolBar, BorderLayout.NORTH);
                this.add(jLabel, BorderLayout.CENTER);
                this.setJMenuBar(jMenuBar);
        }

        /**
         * InnerMainMenu
         */
        public void hienThiLuaChon(String luaChon) {
                this.jLabel.setText(luaChon);
        }

        /**
         * hienThiThanhCongCu()
         */
        public void hienThiThanhCongCu() {
                jToolBar.setVisible(true);
        }

        /**
         * anThanhCongCu()
         */
        public void anThanhCongCu() {
                jToolBar.setVisible(false);
        }
}

/**
 * ControllerMenu
 */
class ControllerMenu implements ActionListener {
        MenuView menuView;
        int coChu = 14;

        public ControllerMenu(MenuView menuView) {
                this.menuView = menuView;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String luaChon = e.getActionCommand();
                if (luaChon.equals("Thoát")) {
                        System.exit(0);
                } else if (luaChon == "Hiển thị thanh công cụ") {
                        AbstractButton button = (AbstractButton) e.getSource();
                        // Nếu model của button Hiển thị thanh công cụ có dấu tích
                        if (button.getModel().isSelected()) {
                                this.menuView.hienThiThanhCongCu();
                        } else {
                                this.menuView.anThanhCongCu();
                        }
                } else if (luaChon.equals("Tăng cỡ chữ")) {
                        coChu += 2;
                        this.menuView.jLabel.setFont(new Font("Times New Roman", Font.BOLD, coChu));
                } else if (luaChon.equals("Giảm cỡ chữ")) {
                        coChu -= 2;
                        this.menuView.jLabel.setFont(new Font("Times New Roman", Font.BOLD, coChu));
                } else {
                        this.menuView.hienThiLuaChon("Bạn đã lựa chọn " + luaChon);
                }
        }

}

/**
 * MouseListener
 */
class SuKienChuot implements MouseListener {
        MenuView menuView;

        public SuKienChuot(MenuView menuView) {
                this.menuView = menuView;
        }

        @Override
        public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
                if (e.isPopupTrigger()) {
                        this.menuView.jpoPopupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
        }

        @Override
        public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                if (e.isPopupTrigger()) {
                        this.menuView.jpoPopupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
        }

        @Override
        public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
        }

}
