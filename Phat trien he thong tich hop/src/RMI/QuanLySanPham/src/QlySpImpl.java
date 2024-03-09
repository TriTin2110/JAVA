package RMI.QuanLySanPham.src;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QlySpImpl extends UnicastRemoteObject implements QlySP {
	final String url = "jdbc:mysql://localhost:3306/mysql";
	final String user = "root";
	final String password = "";
	private Connection connection;

	public QlySpImpl() throws RemoteException {
		try {
			// Để kết nối với mysql

			// B1: khai báo Driver
			// new com.mysql.cj.jdbc.Driver() là thư viện download từ
			// https://jar-download.com/artifacts/mysql/mysql-connector-java
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

			// Kết nối đến cơ sở dữ liệu MySQL
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addP(Product product) throws RemoteException {
		try {
			PreparedStatement statement = this.connection
					.prepareStatement("INSERT INTO products (name, price) VALUES (?, ?)");
			statement.setString(1, product.getName());
			statement.setDouble(2, product.getPrice());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updP(Product product) throws RemoteException {
		try {
			PreparedStatement statement = this.connection
					.prepareStatement("UPDATE products SET name=?, price=? WHERE id=?");
			statement.setString(1, product.getName());
			statement.setDouble(2, product.getPrice());
			statement.setInt(3, product.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delP(int productId) throws RemoteException {
		try {
			PreparedStatement statement = this.connection.prepareStatement("DELETE FROM products WHERE id=?");
			statement.setInt(1, productId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Product findPbyID(int productId) throws RemoteException {
		try {
			PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM products WHERE id=?");
			statement.setInt(1, productId);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return new Product(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getDouble("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getAllProducts() throws RemoteException {
		List<Product> productList = new ArrayList<>();
		try {
			Statement statement = this.connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM products");
			while (resultSet.next()) {
				productList.add(
						new Product(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getDouble("price")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}
}
