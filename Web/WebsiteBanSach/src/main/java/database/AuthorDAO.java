package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.modelAuthor;

public class AuthorDAO implements interfaceDAO<modelAuthor> {
	private List<modelAuthor> list;

	public AuthorDAO() {
		this.list = new ArrayList<modelAuthor>();
	}

	@Override
	public int insert(modelAuthor t) {
		// TODO Auto-generated method stub
		if (selectByID(t) == null) {
			try {
				Connection connection = JDBCUtil.getConnction();
				String sql = "insert into model_author value (?, ?, ?, ?)";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, t.getAuthorId());
				preparedStatement.setString(2, t.getAuthorName());
				preparedStatement.setString(3, t.getAuthorDescription());
				preparedStatement.setDate(4, t.getBirthday());

				int result = preparedStatement.executeUpdate();
				JDBCUtil.closeConnection(connection);
				return result;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int delete(modelAuthor t) {
		// TODO Auto-generated method stub
		modelAuthor authorDeleted = selectByID(t);
		if (authorDeleted != null) {
			try {
				Connection connection = JDBCUtil.getConnction();
				String sql = "delete from model_author where author_ID = ?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, t.getAuthorId());

				int result = preparedStatement.executeUpdate();
				JDBCUtil.closeConnection(connection);
				return result;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		System.out.println("Tác giả không tồn tại trong danh sách");
		return 0;
	}

	@Override
	public int update(modelAuthor t) {
		// TODO Auto-generated method stub
		modelAuthor authorUpdate = selectByID(t);
		if (authorUpdate != null) {
			delete(t);
			return insert(t);
		}
		return 0;
	}

	@Override
	public ArrayList<modelAuthor> selectAll() {
		// TODO Auto-generated method stub
		List<modelAuthor> listResult = new ArrayList<modelAuthor>();
		try {
			Connection connection = JDBCUtil.getConnction();
			String sql = "select * from model_author";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				String authorId = result.getString("author_ID");
				String authorName = result.getString("author_name");
				Date birthday = result.getDate("author_birthday");
				String authorDescription = result.getString("author_description");
				listResult.add(new modelAuthor(authorId, authorName, authorDescription, birthday));
			}
			JDBCUtil.closeConnection(connection);
			return (ArrayList<modelAuthor>) listResult;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public modelAuthor selectByID(modelAuthor t) {
		// TODO Auto-generated method stub
		try {
			modelAuthor modelAuthor = null;
			Connection connection = JDBCUtil.getConnction();
			String sql = "select * from model_author where author_ID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getAuthorId());
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				String authorId = result.getString("author_ID");
				String authorName = result.getString("author_name");
				Date birthday = result.getDate("author_birthday");
				String authorDescription = result.getString("author_description");
				modelAuthor = new modelAuthor(authorId, authorName, authorDescription, birthday);
				break;
			}
			JDBCUtil.closeConnection(connection);
			return modelAuthor;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;

	}
}
