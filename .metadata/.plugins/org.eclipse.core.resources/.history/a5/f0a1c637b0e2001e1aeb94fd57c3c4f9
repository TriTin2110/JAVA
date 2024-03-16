package Implements;

import java.sql.DriverManager;

public class ConnectionMuonTraSach {
	public static java.sql.Connection getConnection() {
		java.sql.Connection connection = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://localhost:3306/muon_tra_sach";
			String username = "sa";
			String password = "nguyentritin123";
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection(java.sql.Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
