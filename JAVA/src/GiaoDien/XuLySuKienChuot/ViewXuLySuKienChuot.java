package GiaoDien.XuLySuKienChuot;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ViewXuLySuKienChuot extends JFrame {
	ModelXuLySuKienChuot modelXuLySuKienChuot = new ModelXuLySuKienChuot();
	JPanel jPanelVungHienThi = new JPanel();
	JLabel jaJLabelX = new JLabel("x");
	JLabel jaJLabelY = new JLabel("y");
	JLabel jaJLabelSoLanClick = new JLabel(this.modelXuLySuKienChuot.getSoLanNhapChuot() + "");
	JLabel jaJLabelBooleanNamTrong = new JLabel(this.modelXuLySuKienChuot.getDaVao());
	Font font = new Font("Times new roman", Font.BOLD, 30);

	public ViewXuLySuKienChuot() {
		this.init();
		this.setVisible(true);
	}

	void setQuanSat() {
		ControllerXuLySuKienChuot controllerXuLySuKienChuot = new ControllerXuLySuKienChuot(this);
		JPanel jPanelCenter = new JPanel(new BorderLayout());
		JLabel jLabelQuanSat = new JLabel("Phần quan sát");
		jPanelCenter.add(jLabelQuanSat, BorderLayout.NORTH);
		jPanelCenter.add(jPanelVungHienThi, BorderLayout.CENTER);
		jPanelVungHienThi.setBackground(Color.GREEN);
		jPanelVungHienThi.setOpaque(true);
		jPanelVungHienThi.addMouseListener(controllerXuLySuKienChuot);
		jPanelVungHienThi.addMouseMotionListener(controllerXuLySuKienChuot);

		// set Font
		jLabelQuanSat.setFont(font);
		jPanelVungHienThi.setFont(font);
		this.add(jPanelCenter, BorderLayout.CENTER);
	}

	void setThongTin() {
		JPanel jPanelThongTin = new JPanel(new GridLayout(3, 3, 10, 10));
		JLabel jLabelToaDo = new JLabel("Tọa độ: ");
		jPanelThongTin.add(jLabelToaDo);
		jPanelThongTin.add(jaJLabelX);
		jPanelThongTin.add(jaJLabelY);
		JLabel jLabelClick = new JLabel("Số lần click: ");
		jPanelThongTin.add(jLabelClick);
		jPanelThongTin.add(jaJLabelSoLanClick);
		JLabel jLabelTrong1 = new JLabel("");
		jPanelThongTin.add(jLabelTrong1);
		JLabel jLabelTimThay = new JLabel("Tình trạng tìm thấy: ");
		jPanelThongTin.add(jLabelTimThay);
		jPanelThongTin.add(jaJLabelBooleanNamTrong);
		JLabel jLabelTrong2 = new JLabel("");
		jPanelThongTin.add(jLabelTrong2);
		this.add(jPanelThongTin, BorderLayout.SOUTH);

		// set font
		jLabelToaDo.setFont(font);
		jaJLabelX.setFont(font);
		jaJLabelY.setFont(font);
		jLabelClick.setFont(font);
		jaJLabelSoLanClick.setFont(font);
		jLabelTrong1.setFont(font);
		jLabelTimThay.setFont(font);
		jLabelTrong2.setFont(font);

	}

	private void init() {
		// TODO Auto-generated method stub
		this.setTitle("Xử lý sự kiện chuột!");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setQuanSat();
		setThongTin();

	}

	void demSoLanClick() {
		this.modelXuLySuKienChuot.setSoLanNhapChuot();
		this.jaJLabelSoLanClick.setText(this.modelXuLySuKienChuot.getSoLanNhapChuot() + "");
	}

	void xacDinhNamTrong(String check) {
		this.jaJLabelBooleanNamTrong.setText(check);
	}

	void xacDinhToaDo(int x, int y) {
		this.jaJLabelX.setText(x + "");
		this.jaJLabelY.setText(y + "");
	}
}
