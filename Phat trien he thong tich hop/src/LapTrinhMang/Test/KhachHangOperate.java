package LapTrinhMang.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class KhachHangOperate implements KhachHangInterface {

	@Override
	public int themKhachHang(ModelKhachHang modelKhachHang) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			Connection connection = getConnection();
			String sql = "insert into Danhsach values(?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, modelKhachHang.getId());
			preparedStatement.setString(2, modelKhachHang.getName());
			result = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://localhost:3306/QLKH1";
			String userName = "sa";
			String password = "nguyentritin123";
			conn = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}

}
