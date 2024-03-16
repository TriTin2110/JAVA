package LapTrinhMang.SoFibonnaci;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Client extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUserInput;
	private JLabel lblResult;

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
		setBounds(100, 100, 555, 216);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldUserInput = new JTextField();
		textFieldUserInput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldUserInput.setBounds(83, 29, 223, 32);
		contentPane.add(textFieldUserInput);
		textFieldUserInput.setColumns(10);

		JButton btnConfirm = new JButton("Xác nhận");
		btnConfirm.setMnemonic(KeyEvent.VK_ENTER);
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConfirm.setBounds(329, 29, 106, 32);
		contentPane.add(btnConfirm);
		btnConfirm.addActionListener(e -> {
			try {
				Socket socket = new Socket("localhost", 1026);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());

				pw.println(this.textFieldUserInput.getText());
				pw.flush();

				lblResult.setText("Số Fibonacci thứ " + textFieldUserInput.getText() + " là: " + br.readLine());
			} catch (Exception e2) {
				// TODO: handle exception
			}
		});

		lblResult = new JLabel("Kết quả!", SwingConstants.CENTER);
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblResult.setBounds(0, 94, 541, 32);
		contentPane.add(lblResult);
	}
}
