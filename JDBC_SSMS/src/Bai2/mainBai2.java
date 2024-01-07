package Bai2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mainBai2 {
	public static void main(String[] args) {
		Connection connection = JDBCUltil.getConnection();
		try {
			java.sql.Statement statement = connection.createStatement();
			xoaDuLieu(statement);
			themDuLieu(statement);
			truyVan(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JDBCUltil.closeConnection(connection);
	}

	public static void xoaDuLieu(Statement statement) {
		String command = "delete from hocSinh where maHocSinh = 5";
		try {
			statement.executeUpdate(command);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void themDuLieu(Statement statement) {
		String command = "insert into hocSinh values (N'Nguyễn Văn A', 'M', 7)";
		try {
			int update = statement.executeUpdate(command);
			if (update > 0)
				System.out.println("Đã thêm " + update + " dữ liệu");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void truyVan(Statement statement) {
		String command = "select * from hocSinh";
		ResultSet resultSet;
		try {
			resultSet = statement.executeQuery(command);
			while (resultSet.next()) {
				System.out.print(resultSet.getInt(1) + ", ");
				System.out.print(resultSet.getString(2) + ", ");
				System.out.print(resultSet.getString(3));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
