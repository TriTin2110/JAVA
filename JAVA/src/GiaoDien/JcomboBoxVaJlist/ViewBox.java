package GiaoDien.JcomboBoxVaJlist;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class ViewBox extends JFrame {
	ModelBox modelBox;
	JLabel jLabelThongTinMonChinh;
	JLabel jLabelThongTinMonPhu;
	JRadioButton jRadioButtonChao;
	JRadioButton jRadioButtonPho;
	JRadioButton jRadioButtonCom;
	ButtonGroup buttonGroupMonChinh;
	ArrayList<JCheckBox> jCheckBoxs;
	JList<String> jListMonPhu;
	JComboBox<String> jComboBox;

	public ViewBox() {
		modelBox = new ModelBox();
		// TODO Auto-generated constructor stub
		this.init();
		this.setVisible(true);
	}

	public void init() {
		this.setLayout(new BorderLayout());
		this.setTitle("Món ăn");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel jPanelMonAn = new JPanel(new GridLayout(2, 1));

		// Tạo tiêu đề
		JPanel jPanelTieuDe = new JPanel();
		JLabel jLabelTieuDe = new JLabel("Menu");
		jLabelTieuDe.setFont(new Font("Times new roman", Font.BOLD, 60));
		jPanelTieuDe.add(jLabelTieuDe);
		this.add(jPanelTieuDe, BorderLayout.NORTH);

		// Tạo món chính radio button
		JPanel jPanelMonChinh = new JPanel(new GridLayout(1, 3));
		Font fontMonChinh = new Font("Times new roman", Font.BOLD | Font.ITALIC, 40);
		String[] monChinh = { "Cơm", "Phở", "Cháo" };
		jComboBox = new JComboBox<String>(monChinh);
		jComboBox.setFont(fontMonChinh);
		jPanelMonChinh.add(jComboBox);
		jPanelMonAn.add(jPanelMonChinh, BorderLayout.NORTH);

		// Tạo món phụ checkbox
		JPanel jPanelMonPhu = new JPanel(new GridLayout(1, 3));
		jCheckBoxs = new ArrayList<JCheckBox>();
		Font fontMonPhu = new Font("Times new roman", Font.BOLD, 30);
		String[] monPhu = { "Coca", "Nước suối", "Canh rong biển" };
		jListMonPhu = new JList<String>(monPhu);
		jListMonPhu.setFont(fontMonPhu);
		jPanelMonPhu.add(jListMonPhu);
		jPanelMonAn.add(jPanelMonPhu, BorderLayout.CENTER);

		// Tạo nút thanh toán
		JPanel jPanelThanhToan = new JPanel(new GridLayout(1, 2));
		JPanel jPanelThongTin = new JPanel(new GridLayout(2, 2));
		jPanelThanhToan.setPreferredSize(new Dimension(800, 100));
		jLabelThongTinMonChinh = new JLabel();
		jLabelThongTinMonPhu = new JLabel();
		JButton jButtonThanhToan = new JButton("Thanh toán");
		ControllerBox controllerBox = new ControllerBox(this);
		jButtonThanhToan.addActionListener(controllerBox);
		jButtonThanhToan.setFont(new Font("Times new roman", Font.BOLD, 35));

		jPanelThongTin.add(jLabelThongTinMonChinh);
		jPanelThongTin.add(jLabelThongTinMonPhu);
		jPanelThanhToan.add(jPanelThongTin);
		jPanelThanhToan.add(jButtonThanhToan);

		this.add(jPanelMonAn, BorderLayout.CENTER);
		this.add(jPanelThanhToan, BorderLayout.SOUTH);
	}

	public void hienThiKetQua() {
		String monChinh = "Món chính " + this.modelBox.getMonChinh() + "Tổng tiền món chính: "
				+ this.modelBox.getTongTienMonChinh();
		String monPhu = "Món phụ " + this.modelBox.getMonPhu() + "Tổng tiền món phụ: "
				+ this.modelBox.getTongTienMonPhu();
		this.jLabelThongTinMonChinh.setText(monChinh);
		this.jLabelThongTinMonPhu.setText(monPhu);
	}
}
