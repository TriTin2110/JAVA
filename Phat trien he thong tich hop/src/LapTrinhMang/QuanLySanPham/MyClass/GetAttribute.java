package LapTrinhMang.QuanLySanPham.MyClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import LapTrinhMang.QuanLySanPham.Connect.MyConnection;

public class GetAttribute {
	public static int countCompany() {
		try {
			Connection connection = MyConnection.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select count(*) from company");
			resultSet.next();
			return resultSet.getInt(1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
}
