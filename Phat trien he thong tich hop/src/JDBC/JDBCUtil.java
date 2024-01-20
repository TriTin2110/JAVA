package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class JDBCUtil {
	public static Connection getConnect() {
		Connection c = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			String url = "jdbc:mysql://127.0.0.1:3306/productjdbc";
			String user = "sa";
			String password = "nguyentritin123";
			c = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return c;
	}

	public static void closeConnect(Connection connection) {
		try {
			if (connection != null)
				connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void getData(Connection connection) {
		try {
			if (connection != null) {
				DatabaseMetaData metaData = (DatabaseMetaData) connection.getMetaData();
				System.out.println(metaData.getDatabaseProductName());
				System.out.println(metaData.getDatabaseProductVersion());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
