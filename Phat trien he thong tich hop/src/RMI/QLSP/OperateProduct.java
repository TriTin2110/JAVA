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
		try {
			Connection connection = getConnection();
			String sql = "insert into Product values (?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, modelProduct.getId());
			preparedStatement.setString(2, modelProduct.getProductName());
			preparedStatement.setLong(3, modelProduct.getPrice());
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int deleteProduct(String id) throws RemoteException {
		// TODO Auto-generated method stub
		if (searchingProduct(id) != null) {
			try {
				Connection connection = getConnection();
				String sql = "delete from Product where id = ?";
				PreparedStatement pr = connection.prepareStatement(sql);
				pr.setString(1, id);
				int result = pr.executeUpdate();
				connection.close();
				return result;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int updateProduct(String id, ModelProduct modelProduct) throws RemoteException {
		// TODO Auto-generated method stub
		if (searchingProduct(id) != null) {

			try {
				Connection connection = getConnection();
				String sql = "Update Product set product_name = ?, price = ? where id = ?";
				PreparedStatement pr = connection.prepareStatement(sql);
				pr.setString(1, modelProduct.getProductName());
				pr.setLong(2, modelProduct.getPrice());
				pr.setString(3, id);
				int result = pr.executeUpdate();
				return result;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return 0;
	}

	@Override
	public ModelProduct searchingProduct(String id) throws RemoteException {
		// TODO Auto-generated method stub
		ModelProduct modelProduct = new ModelProduct();
		try {
			Connection connection = getConnection();
			String sql = "select * from Product where id = ?";
			PreparedStatement pr = connection.prepareStatement(sql);
			pr.setString(1, id);
			ResultSet resultSet = pr.executeQuery();
			while (resultSet.next()) {
				modelProduct.setId(resultSet.getString("id"));
				modelProduct.setProductName(resultSet.getString("product_name"));
				modelProduct.setPrice(resultSet.getLong("price"));
				connection.close();
				return modelProduct;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

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

	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
