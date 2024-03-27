package GiaoDien.LayOut;

import java.awt.Button;
import java.awt.FlowLayout;

import javax.swing.JFrame;

class ViDu_FlowLayout extends JFrame {

	public ViDu_FlowLayout() {
		this.setTitle("Ví dụ FlowLayout");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		// TODO Auto-generated constructor stub
		FlowLayout flowLayout = new FlowLayout();
		FlowLayout flowLayout2 = new FlowLayout(FlowLayout.RIGHT);
		FlowLayout flowLayout3 = new FlowLayout(FlowLayout.CENTER, 50, 50);
		this.setLayout(flowLayout3);
		Button button1 = new Button("1");
		Button button2 = new Button("2");
		this.add(button1);
		this.add(button2);
		this.add(new Button("3"));
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ViDu_FlowLayout();
	}

}
