package LapTrinhMang.ChuyenDoiTienTe;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Client extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldInputMoney;
	private JLabel lblResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		NumberFormat nf = NumberFormat.getInstance(new Locale("vi", "vn"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldInputMoney = new JTextField();
		textFieldInputMoney.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldInputMoney.setBounds(76, 27, 251, 35);
		contentPane.add(textFieldInputMoney);
		textFieldInputMoney.setColumns(10);

		JButton btnChanging = new JButton("Chuyển");
		btnChanging.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnChanging.setBounds(337, 27, 115, 35);
		contentPane.add(btnChanging);
		btnChanging.addActionListener(e -> {
			String command = e.getActionCommand();
			if (command.equals("Chuyển")) {
				// Chuyển giá trị qua phía server
				try {
					Socket socket = new Socket("localhost", 1026);
					String userInput = textFieldInputMoney.getText();
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					PrintWriter pw = new PrintWriter(socket.getOutputStream());

					pw.println(userInput);
					pw.flush();

					this.lblResult.setText(nf.format(Integer.parseInt(br.readLine())) + "đ");
					socket.close();
				} catch (Exception e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
			}
		});

		JLabel lblNotice = new JLabel("Kết quả sau khi chuyển tiền");
		lblNotice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNotice.setBounds(167, 87, 198, 26);
		contentPane.add(lblNotice);

		lblResult = new JLabel("", SwingConstants.CENTER);
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblResult.setBounds(0, 138, 546, 53);
		contentPane.add(lblResult);

		this.setTitle("Công cụ chuyển tiền");
		this.setLocationRelativeTo(null);
	}

}
