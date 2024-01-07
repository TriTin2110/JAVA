package GiaoDien.LayOut;

import java.awt.Button;
import java.awt.GridLayout;

import javax.swing.JFrame;

class ViDu_GridLayout extends JFrame {

	public ViDu_GridLayout() {
		// TODO Auto-generated constructor stub
		this.setTitle("Ví dụ GridLayout");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		GridLayout gridLayout = new GridLayout();

		// GridLayout gridLayout2 = new GridLayout(row, column);
		GridLayout gridLayout2 = new GridLayout(3, 2);

		// GridLayout gridLayout3 = new GridLayout(row, column, margin-x, margin-y);
		GridLayout gridLayout3 = new GridLayout(3, 3, 50, 5);
		this.setLayout(gridLayout3);
		for (int i = 0; i < 6; i++) {
			this.add(new Button(i + ""));
		}

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ViDu_GridLayout();
	}

}
