package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.modelTypeOfBook;

public class TypeOfBookDAO implements interfaceDAO<modelTypeOfBook> {
	private List<modelTypeOfBook> list;

	public TypeOfBookDAO() {
		this.list = new ArrayList<modelTypeOfBook>();
	}

	@Override
	public int insert(modelTypeOfBook t) {
		// TODO Auto-generated method stub
		if (selectByID(t) == null) {
			try {
				Connection connection = JDBCUtil.getConnction();
				String sql = "insert into model_type_of_book value (?, ?)";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, t.getTypeID());
				preparedStatement.setString(2, t.getTypeName());

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
	public int delete(modelTypeOfBook t) {
		// TODO Auto-generated method stub
		modelTypeOfBook modelTypeOfBookDeleted = selectByID(t);
		if (modelTypeOfBookDeleted != null) {
			try {
				Connection connection = JDBCUtil.getConnction();
				String sql = "delete from model_type_of_book where type_ID = ?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, t.getTypeID());

				int result = preparedStatement.executeUpdate();
				JDBCUtil.closeConnection(connection);
				return result;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		System.out.println("Thể loại không tồn tại trong danh sách");
		return 0;
	}

	@Override
	public int update(modelTypeOfBook t) {
		// TODO Auto-generated method stub
		modelTypeOfBook authorUpdate = selectByID(t);
		if (authorUpdate != null) {
			delete(t);
			return insert(t);
		}
		return 0;
	}

	@Override
	public ArrayList<modelTypeOfBook> selectAll() {
		// TODO Auto-generated method stub
		List<modelTypeOfBook> listResult = new ArrayList<modelTypeOfBook>();
		try {
			Connection connection = JDBCUtil.getConnction();
			String sql = "select * from model_type_of_book";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				String typeID = result.getString("type_ID");
				String typeName = result.getString("type_name");
				listResult.add(new modelTypeOfBook(typeID, typeName));
			}
			JDBCUtil.closeConnection(connection);
			return (ArrayList<modelTypeOfBook>) listResult;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public modelTypeOfBook selectByID(modelTypeOfBook t) {
		// TODO Auto-generated method stub
		try {
			modelTypeOfBook modelTypeOfBook = null;
			Connection connection = JDBCUtil.getConnction();
			String sql = "select * from model_type_of_book where type_ID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getTypeID());
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				String typeID = result.getString("type_ID");
				String typeName = result.getString("type_name");
				modelTypeOfBook = new modelTypeOfBook(typeID, typeName);
				break;
			}
			JDBCUtil.closeConnection(connection);
			return modelTypeOfBook;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
