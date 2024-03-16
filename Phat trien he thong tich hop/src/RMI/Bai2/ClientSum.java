package RMI.Bai2;

import java.awt.EventQueue;
import java.rmi.Naming;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ClientSum extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientSum frame = new ClientSum();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientSum() {
		try {
			SumInterface sumInterface = (SumInterface) Naming.lookup("rmi://localhost:1026/sum");
			int a = Integer.parseInt(JOptionPane.showInputDialog(this, "Hãy nhập giá trị a: "));
			int b = Integer.parseInt(JOptionPane.showInputDialog(this, "Hãy nhập giá trị b: "));

			JOptionPane.showMessageDialog(this, a + " +  " + b + " = " + sumInterface.sum(a, b));
			JOptionPane.showMessageDialog(this, a + " -  " + b + " = " + sumInterface.subtract(a, b));

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
