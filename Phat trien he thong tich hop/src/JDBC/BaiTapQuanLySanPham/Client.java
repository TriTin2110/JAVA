package JDBC.BaiTapQuanLySanPham;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Client extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		setBounds(100, 100, 756, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 722, 316);
		contentPane.add(scrollPane);

		JTextArea textAreaResult = new JTextArea();
		textAreaResult.setFont(new Font("Monospaced", Font.PLAIN, 24));
		scrollPane.setViewportView(textAreaResult);

		JButton btnAdd = new JButton("Thêm SP");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdd.setBounds(20, 336, 127, 40);
		contentPane.add(btnAdd);
		btnAdd.addActionListener(e -> {
			try {
				Socket socket = new Socket("localhost", 1026);
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw.println("Thêm");
				pw.flush();
				String result = br.readLine();
				socket.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		});

		JButton btnDelete = new JButton("Xóa");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDelete.setBounds(218, 336, 127, 40);
		contentPane.add(btnDelete);
		btnDelete.addActionListener(e -> {
			try {
				Socket socket = new Socket("localhost", 1026);
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw.println("Xóa");
				pw.flush();

				String messageFromServer = br.readLine();
				if (!messageFromServer.equals("") && !messageFromServer.equals("null")) {
					JOptionPane.showMessageDialog(this, messageFromServer, "Thông báo", JOptionPane.PLAIN_MESSAGE);
				} else if (!messageFromServer.equals("")) {
					JOptionPane.showMessageDialog(this, "Sản phẩm không tồn tại trong danh sách!", "Thông báo",
							JOptionPane.PLAIN_MESSAGE);
				}
				socket.close();
			} catch (Exception e3) {
				// TODO: handle exception
			}

		});

		JButton btnModify = new JButton("Sửa");
		btnModify.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnModify.setBounds(413, 336, 127, 40);
		contentPane.add(btnModify);
		btnModify.addActionListener(e -> {
			try {
				Socket socket = new Socket("localhost", 1026);
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw.println("Sửa");
				pw.flush();

				String serverMessage = br.readLine();
				if (!serverMessage.equals("") && !serverMessage.equals("null")) {
					JOptionPane.showMessageDialog(this, serverMessage, "Thông báo", JOptionPane.PLAIN_MESSAGE);
				} else if (!serverMessage.equals("")) {
					JOptionPane.showMessageDialog(this, "Sản phẩm không tồn tại trong danh sách!", "Thông báo",
							JOptionPane.PLAIN_MESSAGE);
				}

				socket.close();
			} catch (Exception e3) {
				// TODO: handle exception
			}

		});

		JButton btnPrintList = new JButton("In DS");
		btnPrintList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPrintList.setBounds(605, 336, 127, 40);
		contentPane.add(btnPrintList);
		btnPrintList.addActionListener(e -> {
			try {
				Socket socket = new Socket("localhost", 1026);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				pw.println("In");
				pw.flush();
				String result = br.readLine();
				socket.close();

				String[] row = result.split(";");
				result = "";
				for (String string : row) {
					result += string + "\n";
				}
				textAreaResult.setText(result);

			} catch (Exception e3) {
				// TODO: handle exception
			}
		});
	}
}
