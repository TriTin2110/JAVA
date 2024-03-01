package RMI.OnTap1;

import java.awt.EventQueue;
import java.awt.Font;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

class Client extends JFrame {

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
		setBounds(100, 100, 550, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldInput = new JTextField();
		textFieldInput.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		textFieldInput.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldInput.setBounds(105, 98, 324, 36);
		contentPane.add(textFieldInput);
		textFieldInput.setColumns(10);

		JLabel lblInput = new JLabel("Hãy nhập 1 chuỗi bất kỳ");
		lblInput.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInput.setBounds(157, 38, 216, 36);
		contentPane.add(lblInput);

		JLabel lblResult = new JLabel("");
		lblResult.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblResult.setBounds(157, 229, 216, 36);
		contentPane.add(lblResult);

		JButton btnConfirm = new JButton("Xác nhận");
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnConfirm.setBounds(183, 172, 154, 27);
		contentPane.add(btnConfirm);
		btnConfirm.addActionListener(e -> {
			try {
				UpperCase upperCase = (UpperCase) Naming.lookup("rmi://localhost:1026/StringController");
				String content = textFieldInput.getText();
				lblResult.setText(upperCase.UpperFirstCase(content));
			} catch (MalformedURLException | RemoteException | NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});
		this.setLocationRelativeTo(null);
	}
}
