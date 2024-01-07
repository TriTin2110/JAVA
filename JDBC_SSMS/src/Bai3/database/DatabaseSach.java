package Bai3.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.modelSach;

public class DatabaseSach implements databaseAccess<modelSach> {
	public static DatabaseSach getInstance() {
		return new DatabaseSach();
	}

	@Override
	public int insert(modelSach sach) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			String command = "insert into Sach(tenSach, namXuatBan, giaSach) values (" + "N'" + sach.getTenSach() + "',"
					+ sach.getNamXuatBan() + "," + sach.getGiaSach() + ")";
			int noti = statement.executeUpdate(command);
			System.out.println("Đã cập nhật " + noti + " dòng!");
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(modelSach sach) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			String command = "delete from Sach where maSach = " + sach.getMaSach();
			int noti = statement.executeUpdate(command);
			System.out.println("Đã cập nhật " + noti + " dòng!");
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(modelSach sach) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			String command = "update Sach set tenSach = N'" + sach.getTenSach() + "'," + "namXuatBan = "
					+ sach.getNamXuatBan() + ", giaSach = " + sach.getGiaSach() + " where maSach = " + sach.getMaSach();
			int noti = statement.executeUpdate(command);
			System.out.println("Đã cập nhật " + noti + " dòng!");
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			String url = "jdbc:sqlserver://DESKTOP-9VT84F0\\SQLEXPRESS01:1433;databasename = QLS;trustServerCertificate = true";
			String user = "sa";
			String password = "nguyentritin123";
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public ArrayList<modelSach> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<modelSach> result = new ArrayList<modelSach>();
		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			String command = "select * from sach";
			ResultSet resultSet = statement.executeQuery(command);
			while (resultSet.next()) {
				int maSach = resultSet.getInt("maSach");
				String tenSach = resultSet.getString("tenSach");
				int namXuatBan = resultSet.getInt("namXuatBan");
				float giaBan = resultSet.getFloat("giaSach");
				modelSach sach2 = new modelSach(maSach, namXuatBan, tenSach, giaBan);
				result.add(sach2);
			}
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public modelSach selectByID(modelSach sachInput) {
		// TODO Auto-generated method stub
		modelSach modelSach = null;
		try {
			Connection connection = getConnection();
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			Statement statement = connection.createStatement();
			String command = "select * from sach where maSach = " + sachInput.getMaSach();
			ResultSet resultSet = statement.executeQuery(command);
			resultSet.next();
			int maSach = resultSet.getInt("maSach");
			String tenSach = resultSet.getString("tenSach");
			int namXuatBan = resultSet.getInt("namXuatBan");
			float giaSach = resultSet.getFloat("giaSach");
			modelSach = new modelSach(maSach, namXuatBan, tenSach, giaSach);
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Không tồn tại sách có mã là: " + sachInput.getMaSach());
		}
		return modelSach;
	}
}
