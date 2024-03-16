package MyClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Implements.ConnectionMuonTraSach;
import Model.ModelAuthor;
import Model.ModelBook;
import Model.ModelStudent;

public class CheckingConstraint {
	public static int CheckingStudentConstraint(ModelStudent modelStudent) {
		int result = 0;
		try {
			Connection connection = ConnectionMuonTraSach.getConnection();
			String sql = "select count(*) from BorrowDetail where id_student = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, modelStudent.getId());
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			result = resultSet.getInt(1);
			ConnectionMuonTraSach.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	public static int CheckingAuthorConstraint(ModelAuthor modelAuthor) {
		int result = 0;
		try {
			Connection connection = ConnectionMuonTraSach.getConnection();
			String sql = "select count(*) from book where id_author = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, modelAuthor.getId());
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

	public static int CheckingBookConstraint(ModelBook modelBook) {
		int result = 0;
		try {
			Connection connection = ConnectionMuonTraSach.getConnection();
			String sql = "select count(*) from BorrowDetail where id_book = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, modelBook.getIdBook());
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
}
