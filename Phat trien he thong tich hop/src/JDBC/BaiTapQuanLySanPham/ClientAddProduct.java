package JDBC.BaiTapQuanLySanPham;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import JDBC.JDBCUtil;
import MyAPI.StringController;

public class ClientAddProduct extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldProductId;
	private JTextField textFieldProductName;
	private JTextField textFieldProductPrice;
	private int id;
	private String name;
	private long price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	/**
	 * Create the frame.
	 */
	public ClientAddProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblProductID = new JLabel("Mã sản phẩm:");
		lblProductID.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblProductID.setBounds(94, 47, 165, 25);
		contentPane.add(lblProductID);

		textFieldProductId = new JTextField();
		textFieldProductId.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textFieldProductId.setBounds(269, 45, 230, 28);
		contentPane.add(textFieldProductId);
		textFieldProductId.setColumns(10);

		JLabel lblProductName = new JLabel("Tên sản phẩm:");
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblProductName.setBounds(89, 118, 151, 25);
		contentPane.add(lblProductName);

		textFieldProductName = new JTextField();
		textFieldProductName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textFieldProductName.setColumns(10);
		textFieldProductName.setBounds(269, 116, 230, 28);
		contentPane.add(textFieldProductName);

		JLabel lblProductPrice = new JLabel("Giá:");
		lblProductPrice.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblProductPrice.setBounds(200, 198, 40, 25);
		contentPane.add(lblProductPrice);

		textFieldProductPrice = new JTextField();
		textFieldProductPrice.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textFieldProductPrice.setColumns(10);
		textFieldProductPrice.setBounds(269, 196, 230, 28);
		contentPane.add(textFieldProductPrice);

		JButton btnAdd = new JButton("Thêm");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnAdd.setBounds(322, 286, 114, 34);
		contentPane.add(btnAdd);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		btnAdd.addActionListener(e -> {
			if (!StringController.checkNumbericString(textFieldProductId.getText()))
				this.setId(getLastProductId());
			else {
				this.setId(Integer.parseInt(textFieldProductId.getText()));
			}
			if (!StringController.checkNumbericString(textFieldProductPrice.getText())) {
				this.setPrice(0);
			} else {
				this.setPrice(Long.parseLong(textFieldProductPrice.getText()));
			}
			this.setName(textFieldProductName.getText());

			// Tạo đối tượng controller mới để gọi phương thức thêm sản phẩm
			Controller.getInstance().addProduct(this);
			this.dispose();
		});

		JButton btnCancel = new JButton("Hủy");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnCancel.setBounds(143, 286, 114, 34);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(e -> {
			this.dispose();
			new Client();
		});
	}

	public int getLastProductId() {
		int id = 0;
		try {
			Connection connection = JDBCUtil.getConnect();
			String sql = "select id from product";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				if (resultSet.isLast())
					id = resultSet.getInt("id") + 1;
			}
			JDBCUtil.closeConnect(connection);
		} catch (

		Exception e) {
			// TODO: handle exception
		}
		return id;
	}
}
