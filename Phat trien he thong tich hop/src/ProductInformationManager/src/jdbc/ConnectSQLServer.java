package ProductInformationManager.src.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectSQLServer {
	private static String DB_URL = "jdbc:mysql://localhost:3306/manager";
	private static String USER_NAME = "root";
	private static String PASSWORD = "Khoinguyen123";

	/**
	 * main
	 * 
	 * @author viettuts.vn
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			// connnect to database 'manager'
			Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			// crate statement
			Statement stmt = conn.createStatement();
			// get data from table 'student'
			ResultSet rs = stmt.executeQuery("select * from product");
			// show data
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			}
			// close connection
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * create connection
	 * 
	 * @author viettuts.vn
	 * @param dbURL:    database's url
	 * @param userName: username is used to login
	 * @param password: password is used to login
	 * @return connection
	 */
	public static Connection getConnection(String dbURL, String userName, String password) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, userName, password);
			System.out.println("connect successfully!");
		} catch (Exception ex) {
			System.out.println("connect failure!");
			ex.printStackTrace();
		}
		return conn;
	}
}