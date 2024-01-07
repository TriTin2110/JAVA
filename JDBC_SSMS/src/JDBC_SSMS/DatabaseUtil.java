package JDBC_SSMS;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	public static Connection getConnection() {

		Connection c = null;
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			String url = "jdbc:sqlserver://DESKTOP-9VT84F0\\SQLEXPRESS01:1433;databaseName = NORTHWND; encrypt=true; trustServerCertificate=true";
			String userName = "sa";
			String password = "nguyentritin123";
			c = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	public void closeConnection(Connection c) {
		if (c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void inThongTinDataBase() {
		try {
			DatabaseMetaData data = getConnection().getMetaData();
			System.out.println(data.getDatabaseProductName());
			System.out.println(data.getDatabaseProductVersion());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
