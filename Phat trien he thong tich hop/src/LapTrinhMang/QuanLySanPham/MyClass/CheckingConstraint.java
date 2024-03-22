package LapTrinhMang.QuanLySanPham.MyClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import LapTrinhMang.QuanLySanPham.Connect.MyConnection;
import LapTrinhMang.QuanLySanPham.Model.ModelCompany;

public class CheckingConstraint {
	public static boolean checkingConstraintCompany(ModelCompany modelCompany) {
		try {
			Connection connection = MyConnection.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select count(*) from product where id_company = '" + modelCompany.getId() + "'");
			resultSet.next();
			if (resultSet.getInt(1) > 0) {
				connection.close();
				return false;
			}
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return true;
	}
}
