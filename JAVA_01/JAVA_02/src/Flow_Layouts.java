import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Flow_Layouts extends JFrame {
	public Flow_Layouts() {
		this.setVisible(true);
		this.setTitle("Ví Dụ Flow Layout");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);

		// Tạo Flow Layout
		FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 100, 100);
		this.setLayout(flowLayout);
		JButton jButtonOk = new JButton("Ok");
		JButton jButtonCancel = new JButton("Cancel");
		this.add(jButtonOk);
		this.add(jButtonCancel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Flow_Layouts();
	}
}
