package LapTrinhMang.SapXepMangSo;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Client extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblArrayAfter;
	private JLabel lblArrayBefore;

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
		setBounds(100, 100, 479, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCreateArray = new JButton("Random");
		btnCreateArray.setMnemonic(KeyEvent.VK_ENTER);
		btnCreateArray.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnCreateArray.setBounds(153, 33, 155, 54);
		contentPane.add(btnCreateArray);
		btnCreateArray.addActionListener(e -> {

			// Khởi tạo mảng có các phần tử là các số nguyên ngẫu nhiên
			int[] array = new int[10];
			Random random = new Random();
			String arrayBF = "";

			for (int i = 0; i < array.length; i++) {
				array[i] = random.nextInt(100) + 1;
				arrayBF += array[i] + ", ";
			}
			this.lblArrayBefore.setText(arrayBF);

			// Chuyển mảng qua cho server xử lý
			try {
				Socket socket = new Socket("localhost", 1026);
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

				oos.writeObject(array);
				oos.flush();

				array = (int[]) ois.readObject();
				arrayBF = "";
				for (int i = 0; i < array.length; i++) {
					arrayBF += array[i] + ", ";
				}

				this.lblArrayAfter.setText(arrayBF);
			} catch (Exception e2) {
				// TODO: handle exception
			}

		});

		lblArrayAfter = new JLabel("New label", SwingConstants.CENTER);
		lblArrayAfter.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblArrayAfter.setBounds(0, 182, 465, 28);
		contentPane.add(lblArrayAfter);

		lblArrayBefore = new JLabel("New label", SwingConstants.CENTER);
		lblArrayBefore.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblArrayBefore.setBounds(0, 128, 465, 28);
		contentPane.add(lblArrayBefore);
	}

}
