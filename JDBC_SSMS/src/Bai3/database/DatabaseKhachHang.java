package Bai3.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.khachHang;

public class DatabaseKhachHang implements databaseAccess<khachHang> {

	public static DatabaseKhachHang getInstance() {
		return new DatabaseKhachHang();
	}

	@Override
	public int insert(khachHang khachHang) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		try {
			java.sql.Statement statement = connection.createStatement();
			String command = "insert into khachHang(tenKhachHang, ngayMuaSach) values (" + "N'"
					+ khachHang.getTenKhachHang() + "'," + "'" + khachHang.getNgayMuaSach() + "'" + ")";
			System.out.println("Đã thay đổi " + statement.executeUpdate(command) + " dòng");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(khachHang khachHang) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		try {
			java.sql.Statement statement = connection.createStatement();
			String command = "delete from KhachHang where maKhachHang = " + khachHang.getMaKhachHang();
			System.out.println("Đã thay đổi " + statement.executeUpdate(command) + " dòng");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(khachHang khachHang) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		try {
			java.sql.Statement statement = connection.createStatement();
			String command = "update khachHang set tenKhachHang = N'" + khachHang.getTenKhachHang()
					+ "', ngayMuaSach = '" + khachHang.getNgayMuaSach() + "' where maKhachHang = "
					+ khachHang.getMaKhachHang();
			System.out.println("Đã thay đổi " + statement.executeUpdate(command) + " dòng");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			String url = "jdbc:sqlserver://DESKTOP-9VT84F0\\SQLEXPRESS01:1433;databasename = QLS; trustServerCertificate = true";
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
	public ArrayList<khachHang> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<khachHang> ketQua = new ArrayList<khachHang>();
		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			String command = "select * from khachHang";
			ResultSet resultSet = statement.executeQuery(command);
			while (resultSet.next()) {
				int maKhachHang = resultSet.getInt("maKhachHang");
				String tenKhachHang = resultSet.getString("tenKhachHang");
				Date date = resultSet.getDate("ngayMuaSach");
				khachHang khachHang = new khachHang(maKhachHang, tenKhachHang, date);
				ketQua.add(khachHang);
			}
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public khachHang selectByID(khachHang khachHangInput) {
		// TODO Auto-generated method stub
		khachHang khachHang = null;
		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			String command = "select * from khachHang where maKhachHang = " + khachHangInput.getMaKhachHang();
			ResultSet resultSet = statement.executeQuery(command);
			resultSet.next();
			int maKhachHang = resultSet.getInt("maKhachHang");
			String tenKhachHang = resultSet.getString("tenKhachHang");
			Date date = resultSet.getDate("ngayMuaSach");
			khachHang = new khachHang(maKhachHang, tenKhachHang, date);
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Không tồn tại khách hàng có mã là: " + khachHangInput.getMaKhachHang());
		}
		return khachHang;
	}

}
