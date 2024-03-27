package Implement;

import java.sql.DriverManager;

public class Connection {
	public static java.sql.Connection getConnection() {
		try {
			java.sql.Connection connection = null;
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://localhost:3306/hash_login";
			String user = "sa";
			String password = "nguyentritin123";
			connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public static void closeConnection(java.sql.Connection connection) {
		try {
			if (connection != null)
				connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
