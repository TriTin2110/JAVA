import JDBC_SSMS.DatabaseUtil;

public class mainJDBC {
	public static void main(String[] args) {
		DatabaseUtil connection = new DatabaseUtil();
		connection.getConnection();
		connection.inThongTinDataBase();
		connection.closeConnection(connection.getConnection());
	}
}
