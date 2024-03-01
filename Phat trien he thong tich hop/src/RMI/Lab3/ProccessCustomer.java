package RMI.Lab3;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProccessCustomer extends UnicastRemoteObject implements Customer {
	protected ProccessCustomer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addCustomer(modelCustomer modelCustomer) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			Connection connection = getConnection();
			String sql = "insert into Customer (customer_name, phone, customer_type) values (?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, modelCustomer.getName());
			preparedStatement.setInt(2, modelCustomer.getPhone());
			preparedStatement.setString(3, modelCustomer.getCustomerType());
			result = preparedStatement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteCustomer(int id) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			Connection connection = getConnection();
			String sql = "delete from Customer where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int updateCustomer(int id, modelCustomer modelCustomer) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			if (searchCustomerByID(id) != null) {
				Connection connection = getConnection();
				String sql = "update Customer set customer_name = ?, phone = ?, customer_type = ? where id = ?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, modelCustomer.getName());
				preparedStatement.setInt(2, modelCustomer.getPhone());
				preparedStatement.setString(3, modelCustomer.getCustomerType());
				preparedStatement.setInt(4, id);
				result = preparedStatement.executeUpdate();
				connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public modelCustomer searchCustomerByID(int id) {
		// TODO Auto-generated method stub
		try {
			modelCustomer modelCustomer = new modelCustomer();
			Connection connection = getConnection();
			String sql = "select * from Customer where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				modelCustomer.setName(resultSet.getString("customer_name"));
				modelCustomer.setPhone(resultSet.getInt("phone"));
				modelCustomer.setCustomerType(resultSet.getString("customer_type"));
				return modelCustomer;
			}
			closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://localhost:3306/Lab4Company";
			String userName = "sa";
			String userPassword = "nguyentritin123";
			connection = DriverManager.getConnection(url, userName, userPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
