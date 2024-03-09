package RMI.QLSP;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class OperateProduct extends UnicastRemoteObject implements ManagerProduct {

	protected OperateProduct() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addProduct(ModelProduct modelProduct) throws RemoteException {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			Connection connection = getConnection();
			String sql = "insert into Product values (?, ?, ?)";
			PreparedStatement pr = connection.prepareStatement(sql);
			pr.setString(1, modelProduct.getId());
			pr.setString(2, modelProduct.getProductName());
			pr.setLong(3, modelProduct.getPrice());
			result = pr.executeUpdate();
			closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int deleteProduct(String id) throws RemoteException {
		// TODO Auto-generated method stub
		int result = 0;
		if (searchingProduct(id) != null) {
			try {
				Connection connection = getConnection();
				String sql = "delete from Product where id = ?";
				PreparedStatement pr = connection.prepareStatement(sql);
				pr.setString(1, id);
				result = pr.executeUpdate();
				connection.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int updateProduct(String id, ModelProduct modelProduct) throws RemoteException {
		// TODO Auto-generated method stub
		int result = 0;
		if (searchingProduct(id) != null) {
			try {
				Connection connection = getConnection();
				String sql = "Update Product set product_name = ?, price = ? where id = ?";
				PreparedStatement pr = connection.prepareStatement(sql);
				pr.setString(1, modelProduct.getProductName());
				pr.setLong(2, modelProduct.getPrice());
				pr.setString(3, id);
				result = pr.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return result;
	}

	@Override
	public ModelProduct searchingProduct(String id) throws RemoteException {
		// TODO Auto-generated method stub
		ModelProduct modelProduct = null;
		try {
			Connection connection = getConnection();
			String sql = "select * from Product where id = ?";
			PreparedStatement pr = connection.prepareStatement(sql);
			pr.setString(1, id);
			ResultSet resultSet = pr.executeQuery();
			while (resultSet.next()) {
				modelProduct = new ModelProduct(resultSet.getString("id"), resultSet.getString("product_name"),
						resultSet.getLong("price"));
				connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return modelProduct;
	}

	@Override
	public Connection getConnection() {
		Connection connection = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://localhost:3306/QLSP";
			String userName = "sa";
			String userPassword = "nguyentritin123";
			connection = DriverManager.getConnection(url, userName, userPassword);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
