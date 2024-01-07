package GiaoDien.CheckBoxAndRadioBox;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private JCheckBox jCheckBoxCoca;
	private JCheckBox jCheckBoxNuocSuoi;
	private JCheckBox jCheckBoxCanhRongBien;
	ArrayList<JCheckBox> jCheckBoxs;

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
		jRadioButtonCom = new JRadioButton("Cơm");
		jRadioButtonCom.setFont(fontMonChinh);
		jRadioButtonPho = new JRadioButton("Phở");
		jRadioButtonPho.setFont(fontMonChinh);
		jRadioButtonChao = new JRadioButton("Cháo");
		jRadioButtonChao.setFont(fontMonChinh);
		// Tạo ButtonGroup để có thể phân biệt lựa chọn
		buttonGroupMonChinh = new ButtonGroup();
		buttonGroupMonChinh.add(jRadioButtonCom);
		buttonGroupMonChinh.add(jRadioButtonPho);
		buttonGroupMonChinh.add(jRadioButtonChao);
		// Thêm lựa chọn món chính vào chương trình
		jPanelMonChinh.add(jRadioButtonCom);
		jPanelMonChinh.add(jRadioButtonPho);
		jPanelMonChinh.add(jRadioButtonChao);
		jPanelMonAn.add(jPanelMonChinh);

		// Tạo món phụ checkbox
		JPanel jPanelMonPhu = new JPanel(new GridLayout(1, 3));
		jCheckBoxs = new ArrayList<JCheckBox>();
		Font fontMonPhu = new Font("Times new roman", Font.BOLD, 30);
		jCheckBoxCoca = new JCheckBox("Coca");
		jCheckBoxs.add(jCheckBoxCoca);
		jCheckBoxCoca.setFont(fontMonPhu);

		jCheckBoxNuocSuoi = new JCheckBox("Nước suối");
		jCheckBoxNuocSuoi.setFont(fontMonPhu);
		jCheckBoxs.add(jCheckBoxNuocSuoi);

		jCheckBoxCanhRongBien = new JCheckBox("Canh rong biển");
		jCheckBoxCanhRongBien.setFont(fontMonPhu);
		jCheckBoxs.add(jCheckBoxCanhRongBien);

		jPanelMonPhu.add(jCheckBoxCoca);
		jPanelMonPhu.add(jCheckBoxNuocSuoi);
		jPanelMonPhu.add(jCheckBoxCanhRongBien);
		jPanelMonAn.add(jPanelMonPhu);

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
