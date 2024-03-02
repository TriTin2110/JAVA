package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.modelCustomer;
import model.modelOrder;

public class CustomerDAO implements interfaceDAO<modelCustomer> {
	private List<modelCustomer> list;

	public CustomerDAO() {
		this.list = new ArrayList<modelCustomer>();
	}

	@Override
	public int insert(modelCustomer t) {
		// TODO Auto-generated method stub
		if (selectByID(t) == null) {
			try {
				Connection connection = JDBCUtil.getConnction();
				String sql = "insert into model_customer value (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, t.getCustomerId());
				preparedStatement.setString(2, t.getUserName());
				preparedStatement.setString(3, t.getUserPassword());
				preparedStatement.setString(4, t.getCustomerName());
				preparedStatement.setString(5, t.getGender());
				preparedStatement.setString(6, t.getAddress());
				preparedStatement.setString(7, t.getAddressReceive());
				preparedStatement.setString(8, t.getAddressSell());
				preparedStatement.setString(9, t.getEmail());
				preparedStatement.setString(10, t.getPhoneNumber());
				preparedStatement.setDate(11, t.getDateOfBirth());
				preparedStatement.setBoolean(12, t.isSignEmail());

				int result = preparedStatement.executeUpdate();
				JDBCUtil.closeConnection(connection);
				return result;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int delete(modelCustomer t) {
		// TODO Auto-generated method stub
		modelCustomer modelCustomerDeleted = selectByID(t);
		if (modelCustomerDeleted != null) {
			try {
				Connection connection = JDBCUtil.getConnction();
				deleteOrder(modelCustomerDeleted);
				String sql = "delete from model_customer where customer_ID = ?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, t.getCustomerId());

				int result = preparedStatement.executeUpdate();
				JDBCUtil.closeConnection(connection);
				return result;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		System.out.println("Khách hàng không tồn tại trong danh sách");
		return 0;
	}

	public int deleteOrder(modelCustomer t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnction();
			String sql = "select * from model_order";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				if (resultSet.getString("customer_ID").equals(t.getCustomerId())) {
					new OrderDAO().delete(new modelOrder(resultSet.getString("order_id")));
					result++;
				}
			}

			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(modelCustomer t) {
		// TODO Auto-generated method stub
		modelCustomer authorUpdate = selectByID(t);
		if (authorUpdate != null) {
			delete(t);
			return insert(t);
		}
		return 0;
	}

	@Override
	public ArrayList<modelCustomer> selectAll() {
		// TODO Auto-generated method stub
		List<modelCustomer> listResult = new ArrayList<modelCustomer>();
		try {
			Connection connection = JDBCUtil.getConnction();
			String sql = "select * from model_customer";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				String customerId = result.getString("customer_ID");
				String userName = result.getString("user_name");
				String userPassword = result.getString("user_password");
				String customerName = result.getString("customer_name");
				String gender = result.getString("gender");
				String address = result.getString("address");
				String addressReceive = result.getString("address_receiver");
				String addressSell = result.getString("address_sell");
				String email = result.getString("email");
				String phoneNumber = result.getString("phone_nuber");
				Date dateOfBirth = result.getDate("date_of_birth");
				Boolean signEmail = result.getBoolean("sign_email");

				modelCustomer modelCustomer = new modelCustomer(customerId, userName, userPassword, customerName,
						gender, address, addressReceive, addressSell, email, phoneNumber, dateOfBirth, signEmail);
				listResult.add(modelCustomer);
			}
			JDBCUtil.closeConnection(connection);
			return (ArrayList<modelCustomer>) listResult;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public modelCustomer selectByID(modelCustomer t) {
		// TODO Auto-generated method stub
		try {
			modelCustomer modelCustomer = null;
			Connection connection = JDBCUtil.getConnction();
			String sql = "select * from model_customer where customer_ID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getCustomerId());
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				String customerId = result.getString("customer_ID");
				String userName = result.getString("user_name");
				String userPassword = result.getString("user_password");
				String customerName = result.getString("customer_name");
				String gender = result.getString("gender");
				String address = result.getString("address");
				String addressReceive = result.getString("address_receiver");
				String addressSell = result.getString("address_sell");
				String email = result.getString("email");
				String phoneNumber = result.getString("phone_nuber");
				Date dateOfBirth = result.getDate("date_of_birth");
				Boolean signEmail = result.getBoolean("sign_email");

				modelCustomer = new modelCustomer(customerId, userName, userPassword, customerName, gender, address,
						addressReceive, addressSell, email, phoneNumber, dateOfBirth, signEmail);
				break;
			}
			JDBCUtil.closeConnection(connection);
			return modelCustomer;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		CustomerDAO customerDAO = new CustomerDAO();
////		"C1", "ntt", "nguyentritin", "Nguyễn Trí Tín", "Nam", "113 Bình Thạnh", "113 Bình Thạnh", "125 Nguyễn Du", "tinnguyen5071@gmail.com", "092354034", new Date(2003-1900, 10 - 1, 21), false
//		modelCustomer modelCustomer = new modelCustomer("C1", "ntt", "nguyentritin", "Nguyễn Trí Tín", "Nam",
//				"113 Bình Thạnh", "113 Bình Thạnh", "125 Nguyễn Du", "tinnguyen5071@gmail.com", "092354034",
//				new Date(2003 - 1900, 10 - 1, 21), false);
//		customerDAO.insert(modelCustomer);
		customerDAO.delete(new modelCustomer("C1"));
	}
}
