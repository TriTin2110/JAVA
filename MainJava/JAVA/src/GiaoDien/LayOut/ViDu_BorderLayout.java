package GiaoDien.LayOut;

import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.JFrame;

class ViDu_BorderLayout extends JFrame {

	public ViDu_BorderLayout() {
		// TODO Auto-generated constructor stub
		setTitle("Ví dụ BorderLayout");
		setSize(600, 400);
		setLocationRelativeTo(null);
		BorderLayout borderLayout = new BorderLayout();
		BorderLayout borderLayout2 = new BorderLayout(50, 50);
		setLayout(borderLayout2);
		add(new Button("North"), BorderLayout.NORTH);
		add(new Button("South"), BorderLayout.SOUTH);
		add(new Button("West"), BorderLayout.WEST);
		add(new Button("East"), BorderLayout.EAST);
		add(new Button("Center"), BorderLayout.CENTER);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ViDu_BorderLayout();
	}

}
