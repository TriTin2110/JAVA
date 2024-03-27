package LuaChonSo;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ViewLuaChon extends JFrame {
	ModelLuaChonSo modelLuaChonSo = new ModelLuaChonSo();
	JButton jButton1 = new JButton("1");
	JButton jButton2 = new JButton("2");
	JButton jButton3 = new JButton("3");
	JButton jButton4 = new JButton("4");
	JLabel jLabel = new JLabel("------------", JLabel.CENTER);
	Font font = new Font("Times New Roman", Font.BOLD, 40);

	public ViewLuaChon() {
		// TODO Auto-generated constructor stub
		this.setLayout(new BorderLayout());
		this.init();
		setVisible(true);
	}

	void setFont() {
		jButton1.setFont(font);
		jButton2.setFont(font);
		jButton3.setFont(font);
		jButton4.setFont(font);
		jLabel.setFont(font);
	}

	void addButton() {
		JPanel jPanel1 = new JPanel(new GridLayout(2, 2));
		jPanel1.add(jButton1);
		jPanel1.add(jButton2);
		jPanel1.add(jButton3);
		jPanel1.add(jButton4);
		this.add(jPanel1, BorderLayout.CENTER);
	}

	void addLabel() {
		JPanel jPanel2 = new JPanel(new BorderLayout());
		jPanel2.add(jLabel);
		this.add(jPanel2, BorderLayout.SOUTH);
	}

	void addListener() {
		ControllerLuaChonSo controllerLuaChonSo = new ControllerLuaChonSo(this);
		jButton1.addActionListener(controllerLuaChonSo);
		jButton2.addActionListener(controllerLuaChonSo);
		jButton3.addActionListener(controllerLuaChonSo);
		jButton4.addActionListener(controllerLuaChonSo);
	}

	private void init() {
		// TODO Auto-generated method stub
		setTitle("Chương trình lựa chọn số");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setFont();
		addButton();
		addLabel();
		addListener();
	}

	void inLuaChon(String luaChon) {
		jLabel.setText("Lựa chọn của bạn là: " + luaChon(luaChon));
	}

	String luaChon(String luaChon) {
		String choose = "";
		switch (luaChon) {
		case "1":
			this.modelLuaChonSo.giaTri1();
			choose = this.modelLuaChonSo.getGiaTri() + "";
			break;
		case "2":
			this.modelLuaChonSo.giaTri2();
			choose = this.modelLuaChonSo.getGiaTri() + "";
			break;
		case "3":
			this.modelLuaChonSo.giaTri3();
			choose = this.modelLuaChonSo.getGiaTri() + "";
			break;
		case "4":
			this.modelLuaChonSo.giaTri4();
			choose = this.modelLuaChonSo.getGiaTri() + "";
			break;
		}
		return choose;
	}
}
