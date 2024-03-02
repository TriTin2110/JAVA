package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.modelAuthor;
import model.modelBook;
import model.modelTypeOfBook;

public class BookDAO implements interfaceDAO<modelBook> {
	private List<modelBook> list;

	public BookDAO() {
		this.list = new ArrayList<modelBook>();
	}

	@Override
	public int insert(modelBook t) {
		// TODO Auto-generated method stub
		if (selectByID(t) == null) {
			try {
				Connection connection = JDBCUtil.getConnction();
				String sql = "insert into model_book value (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, t.getBookId());
				preparedStatement.setString(2, t.getBookName());
				preparedStatement.setString(3, t.getLanguage());
				preparedStatement.setString(4, t.getDesciption());
				preparedStatement.setInt(5, t.getPublicYear());
				preparedStatement.setInt(6, t.getQuantity());
				preparedStatement.setLong(7, t.getImportPrice());
				preparedStatement.setLong(8, t.getPrice());
				preparedStatement.setLong(9, t.getOutportPrice());
				preparedStatement.setString(10, t.getTypeOfBook().getTypeID());
				preparedStatement.setString(11, t.getAuthor().getAuthorId());

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
	public int delete(modelBook t) {
		// TODO Auto-generated method stub
		modelBook modelBookDeleted = selectByID(t);
		if (modelBookDeleted != null) {
			try {
				Connection connection = JDBCUtil.getConnction();
				String sql = "delete from model_book where book_ID = ?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, t.getBookId());

				int result = preparedStatement.executeUpdate();
				JDBCUtil.closeConnection(connection);
				return result;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		System.out.println("Sách không tồn tại trong danh sách");
		return 0;
	}

	@Override
	public int update(modelBook t) {
		// TODO Auto-generated method stub
		modelBook authorUpdate = selectByID(t);
		if (authorUpdate != null) {
			delete(t);
			return insert(t);
		}
		return 0;
	}

	@Override
	public ArrayList<modelBook> selectAll() {
		// TODO Auto-generated method stub
		List<modelBook> listResult = new ArrayList<modelBook>();
		try {
			Connection connection = JDBCUtil.getConnction();
			String sql = "select * from model_book";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				String bookId = result.getString("book_ID");
				String bookName = result.getString("book_name");
				String language = result.getString("book_language");
				String desciption = result.getString("book_description");
				int publicYear = result.getInt("public_year");
				int quantity = result.getInt("quantity");
				long importPrice = result.getLong("import_price");
				long price = result.getLong("price");
				long outportPrice = result.getLong("outport_price");
				String typeOfBook = result.getString("type_of_book_ID");
				String author = result.getString("author_ID");

				// Tạo đối tượng book mới và lưu vào danh sách
				modelBook modelBook = new modelBook(bookId, bookName, language, desciption,
						new TypeOfBookDAO().selectByID(new modelTypeOfBook(typeOfBook)),
						new AuthorDAO().selectByID(new modelAuthor(author)), publicYear, quantity, importPrice, price,
						outportPrice);
				listResult.add(modelBook);
			}
			JDBCUtil.closeConnection(connection);
			return (ArrayList<modelBook>) listResult;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public modelBook selectByID(modelBook t) {
		// TODO Auto-generated method stub
		try {
			modelBook modelBook = null;
			Connection connection = JDBCUtil.getConnction();
			String sql = "select * from model_book where book_ID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getBookId());
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				String bookId = result.getString("book_ID");
				String bookName = result.getString("book_name");
				String language = result.getString("book_language");
				String desciption = result.getString("book_description");
				int publicYear = result.getInt("public_year");
				int quantity = result.getInt("quantity");
				long importPrice = result.getLong("import_price");
				long price = result.getLong("price");
				long outportPrice = result.getLong("outport_price");
				String typeOfBook = result.getString("type_of_book_ID");
				String author = result.getString("author_ID");

				// Tạo đối tượng book mới và trả về đối tượng
				modelBook = new modelBook(bookId, bookName, language, desciption,
						new TypeOfBookDAO().selectByID(new modelTypeOfBook(typeOfBook)),
						new AuthorDAO().selectByID(new modelAuthor(author)), publicYear, quantity, importPrice, price,
						outportPrice);
				break;
			}
			JDBCUtil.closeConnection(connection);
			return modelBook;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
