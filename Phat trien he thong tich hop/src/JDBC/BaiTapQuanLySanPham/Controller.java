package JDBC.BaiTapQuanLySanPham;

import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import JDBC.JDBCUtil;

class Controller implements ControllerInterface<ClientAddProduct> {

	public static String userChosen(String choose) {
		switch (choose) {
		case "Thêm":
			// Nếu ng dùng chọn thêm thì sẽ mở của sỗ nhập thông tin sản phẩm
			new ClientAddProduct();
			break;
		case "In":
			return getInstance().printList();
		}
		return null;
	}

	public static Controller getInstance() {
		return new Controller();
	}

	@Override
	public int addProduct(ClientAddProduct clientAddProduct) {
		int result = 0;
		try {
			Socket socket = new Socket("localhost", 1026);
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			Connection connection = JDBCUtil.getConnect();
			String sql = "insert into product value (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, clientAddProduct.getId());
			statement.setString(2, clientAddProduct.getName());
			statement.setLong(3, clientAddProduct.getPrice());
			result = statement.executeUpdate();
			JOptionPane.showMessageDialog(clientAddProduct, "Đã thêm thành công " + result + " sản phẩm!", "Thông báo!",
					JOptionPane.PLAIN_MESSAGE);
			JDBCUtil.closeConnect(connection);
			pw.println(result);
			pw.flush();
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String printList() {
		String result = "";
		try {
			Connection connection = JDBCUtil.getConnect();
			String sql = "select * from product";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				result += resultSet.getInt("id") + " " + resultSet.getString("product_name") + " "
						+ resultSet.getLong("price") + ";";
			}
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
}
