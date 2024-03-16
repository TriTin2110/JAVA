package Lab4.ClientServer;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
		setBounds(100, 100, 780, 291);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Sản phẩm");
		menuBar.add(mnNewMenu);

		JMenuItem mntmInsertProduct = new JMenuItem("Thêm sản phẩm");
		mnNewMenu.add(mntmInsertProduct);
		mntmInsertProduct.addActionListener(e -> {
			try {
				String productID = JOptionPane.showInputDialog(this, "Hãy nhập ID sản phẩm");
				String productName = JOptionPane.showInputDialog(this, "Hãy nhập tên sản phẩm");
				String productPrice = JOptionPane.showInputDialog(this, "Hãy nhập giá sản phẩm");
				String productCompanyID = JOptionPane.showInputDialog(this, "Hãy nhập công ty của sản phẩm");
				Socket socket = new Socket("localhost", 1026);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				String request = "Thêm sản phẩm;" + productID + ";" + productName + ";" + productPrice + ";"
						+ productCompanyID;
				pw.println(request);
				pw.flush();

				JOptionPane.showMessageDialog(this, br.readLine());
				socket.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		});

		JMenuItem mntmFindProduct = new JMenuItem("Tìm kiếm sản phẩm");
		mnNewMenu.add(mntmFindProduct);
		mntmFindProduct.addActionListener(e -> {
			try {
				String productID = JOptionPane.showInputDialog(this, "Hãy nhập mã của sản phẩm mà bạn muốn tìm kiếm");
				String request = "Tìm kiếm sản phẩm;" + productID;
				Socket socket = new Socket("localhost", 1026);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				pw.println(request);
				pw.flush();

				JOptionPane.showMessageDialog(this, br.readLine());
				socket.close();

			} catch (Exception e2) {
				// TODO: handle exception
			}

		});

		JMenuItem mntmDeleteProduct = new JMenuItem("Xóa sản phẩm");
		mnNewMenu.add(mntmDeleteProduct);
		mntmDeleteProduct.addActionListener(e -> {
			try {
				String productID = JOptionPane.showInputDialog(this, "Hãy nhập mã của sản phẩm mà bạn muốn xóa");
				String request = "Xóa sản phẩm;" + productID;
				Socket socket = new Socket("localhost", 1026);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				pw.println(request);
				pw.flush();

				JOptionPane.showMessageDialog(this, br.readLine());
				socket.close();

			} catch (Exception e2) {
				// TODO: handle exception
			}
		});

		JMenuItem mntmUpdateProduct = new JMenuItem("Cập nhật sản phẩm");
		mnNewMenu.add(mntmUpdateProduct);
		mntmUpdateProduct.addActionListener(e -> {
			try {
				String productID = JOptionPane.showInputDialog(this, "Hãy nhập mã của sản phẩm mà bạn muốn cập nhật");
				String productName = JOptionPane.showInputDialog(this, "Hãy nhập tên sản phẩm");
				String productPrice = JOptionPane.showInputDialog(this, "Hãy nhập giá sản phẩm");
				String productCompanyID = JOptionPane.showInputDialog(this, "Hãy nhập công ty của sản phẩm");
				String request = "Cập nhật sản phẩm;" + productID + ";" + productName + ";" + productPrice + ";"
						+ productCompanyID;
				Socket socket = new Socket("localhost", 1026);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				pw.println(request);
				pw.flush();

				JOptionPane.showMessageDialog(this, br.readLine());
				socket.close();

			} catch (Exception e2) {
				// TODO: handle exception
			}
		});

		JMenu mnNewMenu_1 = new JMenu("Công ty");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmInsertCompany = new JMenuItem("Thêm công ty");
		mnNewMenu_1.add(mntmInsertCompany);
		mntmInsertCompany.addActionListener(e -> {
			try {
				Socket socket = new Socket("localhost", 1026);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				String companyID = JOptionPane.showInputDialog(this, "Hãy nhập ID của công ty");
				String companyName = JOptionPane.showInputDialog(this, "Hãy nhập tên của công ty");
				String result = "Thêm công ty;" + companyID + ";" + companyName;
				pw.println(result);
				pw.flush();

				JOptionPane.showMessageDialog(this, br.readLine());
				socket.close();
			} catch (Exception e1) {
				// TODO: handle exception
				e1.printStackTrace();
			}
		});

		JMenuItem mntmFindingCompany = new JMenuItem("Tìm kiếm công ty");
		mnNewMenu_1.add(mntmFindingCompany);
		mntmFindingCompany.addActionListener(e -> {
			try {
				String companyID = JOptionPane.showInputDialog(this,
						"Hãy nhập mã của công ty mà bạn muốn tìm kiếm");
				String request = "Tìm kiếm công ty;" + companyID;
				Socket socket = new Socket("localhost", 1026);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				pw.println(request);
				pw.flush();

				JOptionPane.showMessageDialog(this, br.readLine());
				socket.close();

			} catch (Exception e2) {
				// TODO: handle exception
			}

		});

		JMenuItem mntmDeleteCompany = new JMenuItem("Xóa công ty");
		mnNewMenu_1.add(mntmDeleteCompany);
		mntmDeleteCompany.addActionListener(e -> {
			try {
				String productID = JOptionPane.showInputDialog(this,
						"Hãy nhập mã của công ty mà bạn muốn xóa");
				String request = "Xóa công ty;" + productID;
				Socket socket = new Socket("localhost", 1026);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				pw.println(request);
				pw.flush();

				JOptionPane.showMessageDialog(this, br.readLine());
				socket.close();

			} catch (Exception e2) {
				// TODO: handle exception
			}
		});


		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		this.setLocationRelativeTo(null);
	}
}
