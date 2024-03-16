package RMI.Bai1;

import java.awt.EventQueue;
import java.awt.Font;
import java.rmi.Naming;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ClientFibonacci extends JFrame {

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
					ClientFibonacci frame = new ClientFibonacci();
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
	public ClientFibonacci() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInput = new JLabel("Hãy nhập n:");
		lblInput.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInput.setBounds(10, 63, 117, 31);
		contentPane.add(lblInput);

		textFieldInput = new JTextField();
		textFieldInput.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldInput.setBounds(137, 63, 212, 31);
		contentPane.add(textFieldInput);
		textFieldInput.setColumns(10);

		JButton btnSubmit = new JButton("Xác nhận");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSubmit.addActionListener(e -> {
			try {
				int n = Integer.parseInt(textFieldInput.getText());
				Fibonacci fibonacci = (Fibonacci) Naming.lookup("rmi://localhost:1206/ExampleFibonacci");
				JOptionPane.showMessageDialog(this, "Số Fibonacci của " + n + " là: " + fibonacci.getFibonacci(n));
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		});
		btnSubmit.setBounds(108, 125, 135, 31);
		contentPane.add(btnSubmit);
	}
}
