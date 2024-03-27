package GiaoDien.VeHinh;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MainVeHinh {
	public static void main(String[] args) {
		new ViewJFrame();
	}
}

class ViewVeHinh extends JPanel {
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		// Vẽ hình chữ nhật
		g.setColor(Color.red);
		g.fill3DRect(15, 15, 30, 40, getFocusTraversalKeysEnabled());

		// Vẽ hình tròn
		g.setColor(Color.blue);
		g.fillArc(67, 67, 100, 150, 0, 360);

		// Vẽ đường thẳng
		g.setColor(Color.orange);
		g.drawLine(160, 19, 170, 500);

		// Vẽ hình bất kì phụ thuộc vào 2 biến x[] và y[]
		int[] x = { 4, 8, 6 };
		int[] y = { 89, 88, 95 };
		g.drawPolygon(x, y, 3);

		// Vẽ hình chữ nhật được bo góc
		g.setColor(Color.GREEN);
		g.drawRoundRect(90, 100, 100, 100, 50, 50);

		// Vẽ chữ
		g.setColor(Color.pink);
		g.drawString("Nguyễn Trí Tín", 100, 100);
	}

}

class ViewJFrame extends JFrame {
	ViewVeHinh viewVeHinh;

	public ViewJFrame() {
		this.setLayout(new BorderLayout());
		this.viewVeHinh = new ViewVeHinh();
		this.init();
		this.setVisible(true);
	}

	void init() {
		this.setTitle("Chương trình vẽ hình!");
		this.setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.add(viewVeHinh, BorderLayout.CENTER);
	}
}
