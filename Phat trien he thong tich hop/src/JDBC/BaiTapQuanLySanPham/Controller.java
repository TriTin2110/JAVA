package JDBC.BaiTapQuanLySanPham;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import JDBC.JDBCUtil;

class Controller implements ControllerInterface<ClientAddProduct> {

	public static String userChosen(String choose) {
		String productIdDemo = "";
		switch (choose) {
		case "Thêm":
			// Nếu ng dùng chọn thêm thì sẽ mở của sỗ nhập thông tin sản phẩm
			new ClientAddProduct();
			break;
		case "In":
			return getInstance().printList();

		case "Xóa":
			productIdDemo = JOptionPane.showInputDialog("Hãy nhập mã sản phẩm mà bạn muốn xóa!");
			// Xóa sản phẩm khi productIdDemo có giá trị
			if (productIdDemo != null)
				return getInstance().deleteProduct(Integer.parseInt(productIdDemo));
			else
				return "";

		case "Sửa":
			productIdDemo = JOptionPane.showInputDialog("Hãy nhập mã sản phẩm mà bạn muốn sửa!");
			// Cập nhật sản phẩm khi productIdDemo có giá trị
			if (productIdDemo != null)
				return getInstance().updateProduct(Integer.parseInt(productIdDemo));
			else
				return "";
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
			Connection connection = JDBCUtil.getConnect();
			// Kiểm tra sản phẩm đã tồn tại trong danh sách hay chưa
			String sql = "select * from product where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, clientAddProduct.getId());
			if (!statement.executeQuery().next()) {
				sql = "insert into product value (?, ?, ?)";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, clientAddProduct.getId());
				statement.setString(2, clientAddProduct.getName());
				statement.setLong(3, clientAddProduct.getPrice());
				result = statement.executeUpdate();
				JOptionPane.showMessageDialog(clientAddProduct, "Đã thêm thành công " + result + " sản phẩm!",
						"Thông báo!", JOptionPane.PLAIN_MESSAGE);
				JDBCUtil.closeConnect(connection);
			} else {
				JOptionPane.showMessageDialog(clientAddProduct, "Sản phẩm đã tồn tại trong danh sách!", "Thông báo!",
						JOptionPane.ERROR_MESSAGE);
			}
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

	public String deleteProduct(int productID) {

		try {
			Connection connection = JDBCUtil.getConnect();
			String sql = "delete from product where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, productID);
			int result = preparedStatement.executeUpdate();
			if (result > 0)
				return "Đã cập nhật thành công " + result + " sản phẩm!";
			JDBCUtil.closeConnect(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String updateProduct(int productID) {

		try {
			Connection connection = JDBCUtil.getConnect();
			// Kiểm tra sản phẩm đã tồn tại trong danh sách hay chưa
			String sql = "select * from product where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, productID);
			// statement.executeQuery().first() trả về false nếu không có giá trị
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String product_name = JOptionPane.showInputDialog(this, "Hãy nhập tên của sản phẩm");
				String price = JOptionPane.showInputDialog(this, "Hãy nhập giá của sản phẩm");
				sql = "update product set product_name = ?, price = ?";
				statement = connection.prepareStatement(sql);
				statement.setString(1, product_name);
				statement.setDouble(2, Double.parseDouble(price));
				int result = statement.executeUpdate();
				if (result > 0)
					return "Đã cập nhật thành công 1 sản phẩm";
			}

			JDBCUtil.closeConnect(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
