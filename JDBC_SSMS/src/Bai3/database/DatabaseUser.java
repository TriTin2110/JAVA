package Bai3.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.modelUser;

public class DatabaseUser implements databaseAccess<modelUser> {

	public static DatabaseUser getInstance() {
		return new DatabaseUser();
	}

	@Override
	public int insert(modelUser modelUser) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		try {
			String command = "insert into taiKhoan values (?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(command);
			preparedStatement.setString(1, modelUser.getTaiKhoan());
			preparedStatement.setString(2, modelUser.getMatKhau());
			int result = preparedStatement.executeUpdate();
			System.out.println("Đã có " + result + " dòng bị thay đổi!");
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(modelUser modelUser) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		try {
			String command = "delete from taiKhoan where taiKhoan = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(command);
			preparedStatement.setString(1, modelUser.getTaiKhoan());
			int result = preparedStatement.executeUpdate();
			System.out.println("Đã có " + result + " bị thay đổi!");
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(modelUser modelUser) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		try {
			String command = "update taiKhoan " + " set matKhau = ? where taiKhoan = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(command);
			preparedStatement.setString(1, modelUser.getMatKhau());
			preparedStatement.setString(2, modelUser.getTaiKhoan());
			int result = preparedStatement.executeUpdate();
			System.out.println("Đã có " + result + " dòng bị thay đổi");
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<modelUser> selectAll() {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		try {
			String command = "select * from taiKhoan";
			PreparedStatement preparedStatement = connection.prepareStatement(command);
			ResultSet resultSet = preparedStatement.executeQuery();
			ArrayList<modelUser> arrayList = new ArrayList<modelUser>();
			while (resultSet.next()) {
				modelUser modelUser = new modelUser(resultSet.getString(1), resultSet.getString(2));
				arrayList.add(modelUser);
			}
			arrayList.forEach(user -> System.out.println(user));
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public modelUser selectByID(modelUser modelUser) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		try {
			String command = "select * from taiKhoan where taiKhoan = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(command);
			preparedStatement.setString(1, modelUser.getTaiKhoan());
			ResultSet resultSet = preparedStatement.executeQuery();
			ArrayList<modelUser> arrayList = new ArrayList<modelUser>();
			while (resultSet.next()) {
				modelUser modelUser2 = new modelUser(resultSet.getString(1), resultSet.getString(2));
				arrayList.add(modelUser2);
			}
			arrayList.forEach(user -> System.out.println(user));
			if (arrayList.isEmpty()) {
				System.out.println("Không tìm thấy người dùng!");
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
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			String url = "jdbc:sqlserver://DESKTOP-9VT84F0\\SQLEXPRESS01:1433;databasename = QLS;trustServerCertificate = true";
			String user = "sa";
			String password = "nguyentritin123";
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}
}
