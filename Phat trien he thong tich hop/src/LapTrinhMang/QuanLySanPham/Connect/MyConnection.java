package LapTrinhMang.QuanLySanPham.Connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
	public static Connection getConnection() {
		Connection connection = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://localhost:3306/QLSP";
			String userName = "sa";
			String password = "nguyentritin123";
			connection = DriverManager.getConnection(url, userName, password);
			return connection;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
