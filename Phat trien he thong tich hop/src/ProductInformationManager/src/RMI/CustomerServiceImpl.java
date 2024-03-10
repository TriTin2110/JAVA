package ProductInformationManager.src.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Triển khai interface remote
public class CustomerServiceImpl extends UnicastRemoteObject implements CustomerService {
	private Connection connection;

	// Constructor
	public CustomerServiceImpl() throws RemoteException {
		super();
		// Khởi tạo kết nối JDBC
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/manager", "root", "Khoinguyen123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Phương thức tìm kiếm khách hàng
	@Override
	public String findCustomer(int customerID) throws RemoteException {
		String query = "SELECT * FROM Customer WHERE CustomerID = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, customerID);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return "CustomerID: " + resultSet.getInt("CustomerID") + ", CustomerName: "
						+ resultSet.getString("CustomerName") + ", ProductID: " + resultSet.getInt("ProductID");
			} else {
				return "Khách hàng không tồn tại.";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException("Lỗi khi tìm kiếm khách hàng.");
		}
	}

	// Phương thức cập nhật thông tin khách hàng
	@Override
	public boolean updateCustomer(int customerID, String newName) throws RemoteException {
		String query = "UPDATE Customer SET CustomerName = ? WHERE CustomerID = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, newName);
			statement.setInt(2, customerID);
			int rowsAffected = statement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException("Lỗi khi cập nhật thông tin khách hàng.");
		}
	}

	// Phương thức xóa khách hàng
	@Override
	public boolean deleteCustomer(int customerID) throws RemoteException {
		String query = "DELETE FROM Customer WHERE CustomerID = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, customerID);
			int rowsAffected = statement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException("Lỗi khi xóa khách hàng.");
		}
	}

	// Phương thức thêm mới khách hàng
	@Override
	public boolean addCustomer(int customerID, String customerName, int productID) throws RemoteException {
		String query = "INSERT INTO Customer(CustomerID, CustomerName, ProductID) VALUES (?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, customerID);
			statement.setString(2, customerName);
			statement.setInt(3, productID);
			int rowsAffected = statement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException("Lỗi khi thêm mới khách hàng.");
		}
	}

	// Phương thức main để khởi động máy chủ RMI
	public static void main(String[] args) {
		// Khởi động máy chủ RMI
	}
}