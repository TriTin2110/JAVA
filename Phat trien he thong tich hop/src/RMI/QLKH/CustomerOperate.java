package RMI.QLKH;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class CustomerOperate extends UnicastRemoteObject implements CustomerInterface {

	protected CustomerOperate() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addCustomer(ModelCustomer modelCustomer) throws RemoteException {
		// TODO Auto-generated method stub
		int result = 0;
		if (findCustomer(modelCustomer) == null) {
			Connection connection = getConnection();
			try {
				String sql = "insert into Customer values (?, ?, ?, ?)";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, modelCustomer.getId());
				preparedStatement.setString(2, modelCustomer.getName());
				preparedStatement.setString(3, modelCustomer.getAddress());
				preparedStatement.setString(4, modelCustomer.getType());
				result = preparedStatement.executeUpdate();
				connection.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else {
			result = -1;
		}

		return result;
	}

	@Override
	public int removeCustomer(ModelCustomer modelCustomer) throws RemoteException {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			Connection connection = getConnection();
			String sql = "delete from Customer where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, modelCustomer.getId());
			result = preparedStatement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int alterCustomer(ModelCustomer modelCustomer) throws RemoteException {
		// TODO Auto-generated method stub
		ModelCustomer modelCustomerID = new ModelCustomer(modelCustomer.getId());
		if (findCustomer(modelCustomerID) != null) {
			removeCustomer(modelCustomerID);
			addCustomer(modelCustomer);
			return 1;
		}
		return 0;
	}

	@Override
	public ModelCustomer findCustomer(ModelCustomer modelCustomer) throws RemoteException {
		// TODO Auto-generated method stub
		ModelCustomer modelCustomerResult = null;
		try {
			Connection connection = getConnection();
			String sql = "select * from Customer where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, modelCustomer.getId());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				modelCustomerResult = new ModelCustomer(resultSet.getString("id"), resultSet.getString("customer_name"),
						resultSet.getString("address"), resultSet.getString("customer_type"));
				break;
			}
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return modelCustomerResult;
	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLKH", "sa", "nguyentritin123");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}
}
