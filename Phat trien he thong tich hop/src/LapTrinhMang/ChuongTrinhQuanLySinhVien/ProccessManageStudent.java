package LapTrinhMang.ChuongTrinhQuanLySinhVien;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class ProccessManageStudent implements ManageStudent {

	@Override
	public int addStudent(ModelStudent modelStudent) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			Connection connection = getConnection();
			String sql = "insert into student values (?, ?, ?, ?)";
			PreparedStatement pr = connection.prepareStatement(sql);
			pr.setString(1, modelStudent.getId());
			pr.setInt(2, modelStudent.getAge());
			pr.setString(3, modelStudent.getName());
			pr.setFloat(4, modelStudent.getGpa());
			result = pr.executeUpdate();
			closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int removeStudent(ModelStudent modelStudent) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			Connection connection = getConnection();
			String sql = "delete from student where id = ?";
			PreparedStatement pr = connection.prepareStatement(sql);
			pr.setString(1, modelStudent.getId());
			result = pr.executeUpdate();
			closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

//	@Override
//	public int alterStudent(ModelStudent modelStudent) {
//		// TODO Auto-generated method stub
//		int result = 0;
//		try {
//			Connection connection = getConnection();
//			String sql = "update student set student_name = ?, age = ?, gpa = ? where id = ?";
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1, modelStudent.getName());
//			preparedStatement.setInt(2, modelStudent.getAge());
//			preparedStatement.setFloat(3, modelStudent.getGpa());
//			preparedStatement.setString(4, modelStudent.getId());
//			result = preparedStatement.executeUpdate();
//			closeConnection(connection);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return result;
//	}

	@Override
	public int alterStudent(ModelStudent modelStudent) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			removeStudent(modelStudent);
			result = addStudent(modelStudent);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ModelStudent findingStudent(ModelStudent modelStudent) {
		// TODO Auto-generated method stub
		ModelStudent model = null;
		try {
			Connection connection = getConnection();
			String sql = "select * from student where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, modelStudent.getId());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				model = new ModelStudent(resultSet.getString("id"), resultSet.getString("student_name"),
						resultSet.getInt("age"), resultSet.getFloat("gpa"));
				break;
			}
			closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return model;
	}

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		try {
			Connection connection = null;
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://localhost:3306/student_manage";
			String userName = "sa";
			String userPassword = "nguyentritin123";
			connection = DriverManager.getConnection(url, userName, userPassword);
			return connection;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void closeConnection(Connection connection) {
		// TODO Auto-generated method stub
		if (connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
