package RMI.KiemTraSoNguyenTo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.rmi.Naming;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Client extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
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
	public Client() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 139);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		textFieldInput = new JTextField();
		panel.add(textFieldInput);
		textFieldInput.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldInput.setColumns(10);

		JButton btnSubmit = new JButton("Xác nhận");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(btnSubmit);
		btnSubmit.setAlignmentX(CENTER_ALIGNMENT);

		JLabel lblResult = new JLabel("");
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblResult);
		lblResult.setAlignmentX(CENTER_ALIGNMENT);
		btnSubmit.addActionListener(e -> {
			try {
				CheckPrime checkPrime = (CheckPrime) Naming.lookup("rmi://localhost:1026/checkPrime");
				int n = Integer.parseInt(textFieldInput.getText());
				lblResult.setText(
						(checkPrime.checkingPrime(n)) ? n + " là số nguyên tố" : n + " không phải là số nguyên tố");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		this.setLocationRelativeTo(null);
	}
}
