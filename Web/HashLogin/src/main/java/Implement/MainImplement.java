package Implement;

import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HexFormat;

import Interface.MainInterface;
import Model.ModelAccount;

public class MainImplement implements MainInterface {

	@Override
	public boolean addAccount(ModelAccount modelAccount) {
		// TODO Auto-generated method stub
		try {
			java.sql.Connection connection = Connection.getConnection();
			String sql = "insert into hash_login_table values(?, ?)";
			String[] income = { modelAccount.getIdAccount(), modelAccount.getPassAccount() };
			String[] outcome = convertToHashString(income);
			PreparedStatement pr = connection.prepareStatement(sql);
			pr.setString(1, outcome[0]);
			pr.setString(2, outcome[1]);
			pr.executeUpdate();
			Connection.closeConnection(connection);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean searchingAccount(ModelAccount modelAccount) {
		// TODO Auto-generated method stub
		try {
			java.sql.Connection connection = Connection.getConnection();
			String sql = "select * from hash_login_table where id_account = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			String[] income = { modelAccount.getIdAccount(), modelAccount.getPassAccount() };
			String[] outcome = convertToHashString(income);
			preparedStatement.setString(1, outcome[0]);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				// Kiểm tra tài khoản người dùng nhập vào và tài khoản lấy từ database ra (cả 2
				// đều đã được encode)
				if (outcome[0].equals(resultSet.getString("id_account"))
						&& outcome[1].equals(resultSet.getString("pass_account")))
					return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public String[] convertToHashString(String[] income) {
		String[] result = new String[2];
		try {
			int i = 0;
			for (String string : income) {
				MessageDigest messageDigest = MessageDigest.getInstance("MD5");
				messageDigest.update(string.getBytes());
				HexFormat hex = HexFormat.of();
				result[i] = hex.formatHex(messageDigest.digest());
				i++;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
}
