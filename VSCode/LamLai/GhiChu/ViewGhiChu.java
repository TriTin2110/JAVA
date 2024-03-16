package GhiChu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.text.View;

public class ViewGhiChu extends JFrame {
        ModelGhiChu modelGhiChu = new ModelGhiChu();
        File file = new File("D:\\Code\\JAVA\\VSCode\\LamLai\\GhiChu\\NoiDung.data");
        JTextField jTextField = new JTextField("");
        JTextArea jTextArea = new JTextArea("");
        JPanel jPanelHeader;
        JPanel jPanelBody;
        JLabel jLabelHienThiKichCoFontChu;
        ControllerGhiChu controllerGhiChu = new ControllerGhiChu(this);
        JPopupMenu jPopupMenu;
        JPanel jPanelTextField;
        JPanel jPanelButton;
        private JMenu jMenuMauNen;
        private JMenuItem jMenuItemSang;
        private JMenuItem jMenuItemToi;

        public ViewGhiChu() {
                this.init();
                this.controllerGhiChu.docThietLap();
                this.setIcon();
                this.setVisible(true);
        }

        /**
         * init()
         */
        public void init() {

                this.setTitle("Chương trình ghi chú!");
                this.setSize(800, 600);
                this.setLocationRelativeTo(null);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                DocFileTieuDe();
                // DocFileNoiDung();
                createJpaneHeader();
                createJpanelBody();
                createMenu();
                menuChuotPhai();
                this.add(jPanelHeader, BorderLayout.NORTH);
                this.add(jPanelBody, BorderLayout.CENTER);
        }

        /**
         * createJpaneHeader()
         */
        public void createJpaneHeader() {
                jPanelHeader = new JPanel();
                jPanelHeader.setPreferredSize(new Dimension(800, 100));
                jPanelHeader.setLayout(new BorderLayout());
                jTextField.setFont(new Font("Times new roman", Font.BOLD, 28));
                // Thêm jpanel cho button và thiết lập khoảng cách giữa chúng là 30
                jPanelButton = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0));

                JButton jButtonTangCoChu = new JButton("+");
                JButton jButtonGiamCoChu = new JButton("-");
                jLabelHienThiKichCoFontChu = new JLabel("Kích cỡ font chữ");
                jLabelHienThiKichCoFontChu
                                .setFont(new Font("Times new roman", Font.BOLD, 20));
                jButtonTangCoChu.addActionListener(controllerGhiChu);
                jButtonGiamCoChu.addActionListener(controllerGhiChu);

                jPanelHeader.setBackground(Color.black);
                jPanelHeader.setOpaque(true);

                // Đặt nội dung input vào giữa
                jTextField.setHorizontalAlignment(JTextField.CENTER);
                jPanelTextField = new JPanel();
                // Thêm jTextField vào jPanel mới
                jPanelTextField.add(jTextField);
                // Thiết lập độ rộng cho Tiêu đề, lưu ý là jpanel không set chứa
                jTextField.setPreferredSize(new Dimension(400, 60));

                jPanelHeader.add(jPanelTextField, BorderLayout.NORTH);
                jPanelButton.add(jButtonGiamCoChu);
                jPanelButton.add(jLabelHienThiKichCoFontChu);
                jPanelButton.add(jButtonTangCoChu);
                jPanelHeader.add(jPanelButton);

                // Cài đặt màu nền
                jPanelTextField.setBackground(new Color(252, 223, 141));
                jPanelTextField.setOpaque(true);
                jPanelButton.setBackground(new Color(252, 223, 141));
                jPanelButton.setOpaque(true);
                jTextArea.setBackground(new Color(252, 223, 141));
                jTextArea.setOpaque(true);

        }

        /**
         * createJpanelBody()
         */
        public void createJpanelBody() {
                // Thêm jScrollPane
                JScrollPane jScrollPane = new JScrollPane(jTextArea);
                jPanelBody = new JPanel(new BorderLayout());
                jPanelBody.add(jScrollPane);

        }

        /**
         * createMenu()
         */
        public void createMenu() {
                JMenuBar jMenuBar = new JMenuBar();
                // Tạo jMenu Tập tin
                JMenu jMenuItemFile = new JMenu("Tệp tin");
                JMenuItem jMenuItemOpen = new JMenuItem("Mở tệp tin");
                jMenuItemOpen.addActionListener(controllerGhiChu);
                JMenuItem jMenuItemExit = new JMenuItem("Thoát", KeyEvent.VK_S);
                jMenuItemExit.setIcon(new ImageIcon(ViewGhiChu.class.getResource("Icon\\exit.png")));
                jMenuItemFile.add(jMenuItemOpen);
                jMenuItemFile.addSeparator();
                jMenuItemFile.add(jMenuItemExit);

                // Tạo menu thiết lập
                JMenu jMenuThietLap = new JMenu("Thiết lập");
                jMenuMauNen = new JMenu("Màu nền");
                jMenuItemSang = new JMenuItem("Sáng");
                jMenuItemSang.addActionListener(controllerGhiChu);
                jMenuItemToi = new JMenuItem("Tối");
                jMenuItemToi.addActionListener(controllerGhiChu);
                jMenuMauNen.add(jMenuItemSang);
                jMenuMauNen.add(jMenuItemToi);
                jMenuThietLap.add(jMenuMauNen);

                jMenuItemExit.addActionListener(controllerGhiChu);
                jMenuItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
                jMenuBar.add(jMenuItemFile);
                jMenuBar.add(jMenuThietLap);
                this.setJMenuBar(jMenuBar);
        }

        /**
         * DocFileTieuDe()
         */
        public void DocFileTieuDe() {
                File file = new File("D:\\Code\\JAVA\\VSCode\\LamLai\\GhiChu\\TieuDe.data");
                String tieuDe = "";
                try {
                        Scanner docFile = new Scanner(file);
                        while (docFile.hasNextLine()) {
                                tieuDe = docFile.nextLine();
                        }
                        docFile.close();
                } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                jTextField.setText(tieuDe);

        }

        /**
         * menuChuotPhai()
         */
        public void menuChuotPhai() {
                jPopupMenu = new JPopupMenu();
                jTextArea.add(jPopupMenu);
                jTextArea.setComponentPopupMenu(jPopupMenu);// Đặt popup menu nằm trong jTextArea
                JMenu jMenuFontChu = new JMenu("Phông chữ");
                JMenuItem jMenuItemArial = new JMenuItem("Arial");
                JMenuItem jMenuItemTimesNewRoman = new JMenuItem("Times new roman");
                JMenuItem jMenuItemCalibri = new JMenuItem("Calibri");
                jMenuFontChu.add(jMenuItemArial);
                jMenuFontChu.add(jMenuItemCalibri);
                jMenuFontChu.add(jMenuItemTimesNewRoman);
                jPopupMenu.add(jMenuFontChu);

                jMenuItemArial.addActionListener(controllerGhiChu);
                jMenuItemCalibri.addActionListener(controllerGhiChu);
                jMenuItemTimesNewRoman.addActionListener(controllerGhiChu);

        }

        /**
         * setIcon()
         */
        public void setIcon() {
                this.setIconImage(new ImageIcon("Icon\\Note.png").getImage());
                this.jMenuItemSang.setIcon(new ImageIcon(ViewGhiChu.class.getResource("Icon\\YellowColor.png")));
                this.jMenuMauNen.setIcon(new ImageIcon(ViewGhiChu.class.getResource("Icon\\Color.png")));
                this.jMenuItemToi.setIcon(new ImageIcon(ViewGhiChu.class.getResource("Icon\\GrayColor.png")));
        }
}
