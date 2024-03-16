package MyClass;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.jdatepicker.impl.JDatePickerImpl;

import Implements.ConnectionMuonTraSach;

public class GetAttribute {
	public static Date getDate(JDatePickerImpl jDatePickerImpl) {
		int day = jDatePickerImpl.getModel().getDay();
		int month = jDatePickerImpl.getModel().getMonth();
		int year = jDatePickerImpl.getModel().getYear();
		@SuppressWarnings("deprecation")
		Date date = new Date(year - 1900, month, day);
		return date;
	}

	// Lấy số lượng sách hiện có
	public static int getBookCount() {
		int result = 0;
		try {
			Connection connection = ConnectionMuonTraSach.getConnection();
			String sql = "select count(*) from book";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
				result = resultSet.getInt(1);
			ConnectionMuonTraSach.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return result;
	}

	public static int getStudentCount() {
		int result = 0;
		try {
			Connection connection = ConnectionMuonTraSach.getConnection();
			String sql = "select count(*) from student";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
				result = resultSet.getInt(1);
			ConnectionMuonTraSach.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return result;
	}

	public static String[] getId(String currentTable) {
		String[] income = new String[2];
		String[] result = null;
		switch (currentTable) {
		case "Author":
			income[0] = "author";
			income[1] = "id_author";
			break;

		case "Student":
			income[0] = "student";
			income[1] = "id_student";
			break;

		case "Book":
			income[0] = "book";
			income[1] = "id_book";
			break;

		case "Borrow":
			income[0] = "BorrowDetail";
			income[1] = "id_borrow";
			break;
		}

		try {
			Connection connection = ConnectionMuonTraSach.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select count(*) from " + income[0]);
			resultSet.next();
			int line = Integer.parseInt(resultSet.getString(1));
			result = new String[line];

			resultSet = statement.executeQuery("select " + income[1] + " from " + income[0]);
			line = 0;
			while (resultSet.next()) {
				result[line] = resultSet.getString(1);
				line++;
			}
			ConnectionMuonTraSach.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// Trả về tất cả id của các record nằm trong bảng currentTable
		return StringController.StringArraySort(result);
	}

	public static Date getBorrowDate(String id) {
		Date date = null;
		try {
			Connection connection = ConnectionMuonTraSach.getConnection();
			String sql = "select borrow_day from BorrowDetail where id_borrow = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			date = resultSet.getDate(1);
			ConnectionMuonTraSach.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return date;
	}

}
