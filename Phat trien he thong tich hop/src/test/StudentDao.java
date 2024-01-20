package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import JDBC.JDBCUtil;

class StudentDao implements StudentDaoInterface<ModelStudent> {
	public List<ModelStudent> list;

	public StudentDao() {
		this.list = new ArrayList<ModelStudent>();
	}

	@Override
	public void insertStudent(ModelStudent t) {
		// TODO Auto-generated method stub
		try {
			Connection connection = JDBCUtil.getConnect();
			String sql = "insert into student value (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, t.getId());
			statement.setString(2, t.getName());
			statement.setDouble(3, t.getGPA());
			int result = statement.executeUpdate();
			System.out.println("Đã cập nhật thành công " + result + " dòng dữ liệu!");

			JDBCUtil.closeConnect(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void deleteStudent(ModelStudent t) {
		// TODO Auto-generated method stub
		try {
			Connection connection = JDBCUtil.getConnect();
			String sql = "delete from student where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, t.getId());
			int result = statement.executeUpdate();
			System.out.println("Đã cập nhật thành công " + result + " dòng dữ liệu!");
			JDBCUtil.closeConnect(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudent(ModelStudent t) {
		// TODO Auto-generated method stub
		try {
			Connection connection = JDBCUtil.getConnect();
			String sql = "update student set name = ?, GPA = ? where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, t.getName());
			statement.setDouble(2, t.getGPA());
			statement.setInt(3, t.getId());
			int result = statement.executeUpdate();
			System.out.println("Đã cập nhật thành công " + result + " dòng dữ liệu!");
			JDBCUtil.closeConnect(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public List<ModelStudent> getStudentList() {
		// TODO Auto-generated method stub

		try {
			Connection connection = JDBCUtil.getConnect();
			String sql = "select * from student";
			Statement statement = connection.createStatement();
			ResultSet resultList = statement.executeQuery(sql);
			while (resultList.next()) {
				this.list.add(new ModelStudent(resultList.getInt("id"), resultList.getString("name"),
						resultList.getDouble("GPA")));
			}
			JDBCUtil.closeConnect(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return this.list;
	}

}
