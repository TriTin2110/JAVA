package GiaoDien.ChonMau;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ViewChonMau extends JFrame {
	JButton jButtonTextRed = new JButton("Red Text");
	JButton jButtonTextYellow = new JButton("Yellow Text");
	JButton jButtonTextGreen = new JButton("Green Text");
	JButton jButtonBackgroundRed = new JButton("Red Background");
	JButton jButtonBackgroundYellow = new JButton("Yellow Background");
	JButton jButtonBackgroundGreen = new JButton("Green Background");
	JLabel jLabel = new JLabel("Nguyễn Trí Tín", JLabel.CENTER);

	public ViewChonMau() {
		// TODO Auto-generated constructor stub
		setFont();
		setColor();
		this.setLayout(new BorderLayout());
		this.init();
		setVisible(true);
	}

	void setFont() {
		Font font = new Font("Times new roman", Font.BOLD, 20);
		Font font1 = new Font("Times new roman", Font.BOLD, 40);
		jButtonTextRed.setFont(font);
		jButtonTextYellow.setFont(font);
		jButtonTextGreen.setFont(font);
		jButtonBackgroundRed.setFont(font);
		jButtonBackgroundYellow.setFont(font);
		jButtonBackgroundGreen.setFont(font);
		jLabel.setFont(font1);
	}

	void setColor() {
		jButtonTextRed.setForeground(Color.red);
		jButtonTextYellow.setForeground(Color.yellow);
		jButtonTextGreen.setForeground(Color.green);
		jButtonBackgroundRed.setBackground(Color.red);
		jButtonBackgroundYellow.setBackground(Color.yellow);
		jButtonBackgroundGreen.setBackground(Color.green);
	}

	void addButton() {
		JPanel jPanelText = new JPanel(new GridLayout(2, 3));
		ControllerChonMau controllerChonMau = new ControllerChonMau(this);
		jPanelText.add(jButtonTextRed);
		jButtonTextRed.addActionListener(controllerChonMau);
		jPanelText.add(jButtonTextYellow);
		jButtonTextYellow.addActionListener(controllerChonMau);
		jPanelText.add(jButtonTextGreen);
		jButtonTextGreen.addActionListener(controllerChonMau);

		jPanelText.add(jButtonBackgroundRed);
		jButtonBackgroundRed.addActionListener(controllerChonMau);
		jPanelText.add(jButtonBackgroundYellow);
		jButtonBackgroundYellow.addActionListener(controllerChonMau);
		jPanelText.add(jButtonBackgroundGreen);
		jButtonBackgroundGreen.addActionListener(controllerChonMau);
		this.add(jPanelText, BorderLayout.CENTER);
	}

	void addLabel() {
		this.add(jLabel, BorderLayout.NORTH);
	}

	private void init() {
		// TODO Auto-generated method stub
		setTitle("Chuyển đổi màu!");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addButton();
		addLabel();

	}

	void changeTextColor(Color color) {
		if (jLabel.getBackground() != color) {
			jLabel.setForeground(color);
		}

	}

	void changeBackgroundColor(Color color) {
		// TODO Auto-generated method stub
		if (jLabel.getForeground() != color) {
			jLabel.setBackground(color);
			jLabel.setOpaque(true);
		}

	}
}
