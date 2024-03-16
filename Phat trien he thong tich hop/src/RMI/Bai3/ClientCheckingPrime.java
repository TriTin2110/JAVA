package RMI.Bai3;

import java.awt.EventQueue;
import java.rmi.Naming;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ClientCheckingPrime extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientCheckingPrime frame = new ClientCheckingPrime();
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
	public ClientCheckingPrime() {
		try {
			CheckPrimeInterface checkPrimeInterface = (CheckPrimeInterface) Naming
					.lookup("rmi://localhost:1026/checkingPrime");

			int n = Integer.parseInt(JOptionPane.showInputDialog(this, "Hãy nhập giá trị n: "));

			JOptionPane.showMessageDialog(this, (checkPrimeInterface.checkingPrime(n)) ? n + " là số nguyên tố"
					: n + " không phải là số nguyên tố");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
