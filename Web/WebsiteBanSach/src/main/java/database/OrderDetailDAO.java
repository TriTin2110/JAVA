package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.modelOrder;
import model.modelOrderDetail;

public class OrderDetailDAO implements interfaceDAO<modelOrderDetail> {
	private List<modelOrderDetail> list;

	public OrderDetailDAO() {
		this.list = new ArrayList<modelOrderDetail>();
	}

	@Override
	public int insert(modelOrderDetail t) {
		// TODO Auto-generated method stub
		if (selectByID(t) == null) {
			try {
				Connection connection = JDBCUtil.getConnction();
				String sql = "insert into model_order_detail value (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, t.getOrderDetailId());
				preparedStatement.setString(2, t.getBookId());
				preparedStatement.setLong(3, t.getCoverPrice());
				preparedStatement.setLong(4, t.getDiscount());
				preparedStatement.setLong(5, t.getSellPrice());
				preparedStatement.setLong(6, t.getVAT());
				preparedStatement.setLong(7, t.getTotal());
				preparedStatement.setInt(8, t.getQuantity());
				preparedStatement.setString(9, t.getOrder().getOrderId());

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
	public int delete(modelOrderDetail t) {
		// TODO Auto-generated method stub
		modelOrderDetail modelOrderDetailDeleted = selectByID(t);
		if (modelOrderDetailDeleted != null) {
			try {
				Connection connection = JDBCUtil.getConnction();
				String sql = "delete from model_order_detail where order_detail_ID = ?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, t.getOrderDetailId());
				int result = preparedStatement.executeUpdate();
				JDBCUtil.closeConnection(connection);
				return result;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		System.out.println("Chi tiết đơn hàng không tồn tại trong danh sách");
		return 0;
	}

	@Override
	public int update(modelOrderDetail t) {
		// TODO Auto-generated method stub
		modelOrderDetail authorUpdate = selectByID(t);
		if (authorUpdate != null) {
			delete(t);
			return insert(t);
		}
		return 0;
	}

	@Override
	public ArrayList<modelOrderDetail> selectAll() {
		// TODO Auto-generated method stub
		List<modelOrderDetail> listResult = new ArrayList<modelOrderDetail>();
		try {
			Connection connection = JDBCUtil.getConnction();
			String sql = "select * from model_order_detail";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				String orderDetailId = result.getString("order_detail_ID");
				String bookId = result.getString("book_ID");
				long coverPrice = result.getLong("cover_price");
				long discount = result.getLong("discount");
				long sellPrice = result.getLong("sell_price");
				long VAT = result.getLong("VAT");
				long total = result.getLong("total");
				int quantity = result.getInt("quantity");
				String order = result.getString("order_ID");
				modelOrderDetail modelOrderDetail = new modelOrderDetail(orderDetailId, bookId,
						new OrderDAO().selectByID(new modelOrder(order)), coverPrice, discount, sellPrice, VAT, total,
						quantity);
				listResult.add(modelOrderDetail);
			}
			JDBCUtil.closeConnection(connection);
			return (ArrayList<modelOrderDetail>) listResult;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public modelOrderDetail selectByID(modelOrderDetail t) {
		// TODO Auto-generated method stub
		try {
			modelOrderDetail modelOrderDetail = null;
			Connection connection = JDBCUtil.getConnction();
			String sql = "select * from model_order_detail where order_detail_ID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getOrderDetailId());
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				String orderDetailId = result.getString("order_detail_ID");
				String bookId = result.getString("book_ID");
				long coverPrice = result.getLong("cover_price");
				long discount = result.getLong("discount");
				long sellPrice = result.getLong("sell_price");
				long VAT = result.getLong("VAT");
				long total = result.getLong("total");
				int quantity = result.getInt("quantity");
				String order = result.getString("order_ID");
				modelOrderDetail = new modelOrderDetail(orderDetailId, bookId,
						new OrderDAO().selectByID(new modelOrder(order)), coverPrice, discount, sellPrice, VAT, total,
						quantity);
				break;
			}
			JDBCUtil.closeConnection(connection);
			return modelOrderDetail;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
