package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.modelCustomer;
import model.modelOrder;
import model.modelOrderDetail;

public class OrderDAO implements interfaceDAO<modelOrder> {
	private List<modelOrder> list;

	public OrderDAO() {
		this.list = new ArrayList<modelOrder>();
	}

	@Override
	public int insert(modelOrder t) {
		// TODO Auto-generated method stub
		if (selectByID(t) == null) {
			try {
				Connection connection = JDBCUtil.getConnction();
				String sql = "insert into model_order value (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, t.getOrderId());
				preparedStatement.setString(2, t.getAddressBuyer());
				preparedStatement.setString(3, t.getAddressReceive());
				preparedStatement.setString(4, t.getStatus());
				preparedStatement.setString(5, t.getPayment());
				preparedStatement.setString(6, t.getStatusPayment());
				preparedStatement.setString(7, t.getMoneyPaid());
				preparedStatement.setString(8, t.getMoneyRemain());
				preparedStatement.setDate(9, t.getOrderDate());
				preparedStatement.setDate(10, t.getShipDate());
				preparedStatement.setString(11, t.getCustomer().getCustomerId());

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
	public int delete(modelOrder t) {
		// TODO Auto-generated method stub
		modelOrder modelOrderDeleted = selectByID(t);
		if (modelOrderDeleted != null) {
			try {
				Connection connection = JDBCUtil.getConnction();
				deleteOrderDetail(modelOrderDeleted);
				String sql = "delete from model_order where order_id = ?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, t.getOrderId());

				int result = preparedStatement.executeUpdate();
				JDBCUtil.closeConnection(connection);
				return result;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		System.out.println("Hóa đơn không tồn tại trong danh sách");
		return 0;
	}

	// Khi xóa order thì sẽ xóa luôn orderdetail
	public int deleteOrderDetail(modelOrder t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnction();
			String sql = "select * from model_order_detail";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				if (resultSet.getString("order_ID").equals(t.getOrderId())) {
					new OrderDetailDAO().delete(new modelOrderDetail(resultSet.getString("order_detail_ID")));
					result++;
				}

			}
			JDBCUtil.closeConnection(connection);
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(modelOrder t) {
		// TODO Auto-generated method stub
		modelOrder authorUpdate = selectByID(t);
		if (authorUpdate != null) {
			delete(t);
			return insert(t);
		}
		return 0;
	}

	@Override
	public ArrayList<modelOrder> selectAll() {
		// TODO Auto-generated method stub
		List<modelOrder> listResult = new ArrayList<modelOrder>();
		try {
			Connection connection = JDBCUtil.getConnction();
			String sql = "select * from model_order";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				String orderID = result.getString("order_id");
				String addressBuyer = result.getString("address_buyer");
				String addressReceive = result.getString("address_receive");
				String status = result.getString("status_order");
				String payment = result.getString("payment_order");
				String statusPayment = result.getString("status_payment");
				String moneyPaid = result.getString("money_paid");
				String moneyRemain = result.getString("money_remain");
				Date orderDate = result.getDate("order_date");
				Date shipDate = result.getDate("ship_date");
				String customer = result.getString("customer_ID");

				modelOrder modelOrder = new modelOrder(orderID, addressBuyer, addressReceive, status, payment,
						statusPayment, moneyPaid, moneyRemain,
						new CustomerDAO().selectByID(new modelCustomer(customer)), orderDate, shipDate);
				listResult.add(modelOrder);
			}
			JDBCUtil.closeConnection(connection);
			return (ArrayList<modelOrder>) listResult;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public modelOrder selectByID(modelOrder t) {
		// TODO Auto-generated method stub
		try {
			modelOrder modelOrder = null;
			Connection connection = JDBCUtil.getConnction();
			String sql = "select * from model_order where order_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getOrderId());
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				String orderID = result.getString("order_id");
				String addressBuyer = result.getString("address_buyer");
				String addressReceive = result.getString("address_receive");
				String status = result.getString("status_order");
				String payment = result.getString("payment_order");
				String statusPayment = result.getString("status_payment");
				String moneyPaid = result.getString("money_paid");
				String moneyRemain = result.getString("money_remain");
				Date orderDate = result.getDate("order_date");
				Date shipDate = result.getDate("ship_date");
				String customer = result.getString("customer_ID");

				modelOrder = new modelOrder(orderID, addressBuyer, addressReceive, status, payment, statusPayment,
						moneyPaid, moneyRemain, new CustomerDAO().selectByID(new modelCustomer(customer)), orderDate,
						shipDate);
				break;
			}
			JDBCUtil.closeConnection(connection);
			return modelOrder;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		OrderDAO orderDAO = new OrderDAO();
		modelOrder modelOrder = new modelOrder("O1", "113 Bình Thạnh", "113 Bình Thạnh", "Đang giao hàng",
				"Chuyển khoản", "Đã thanh toán", "12000", "5000", new modelCustomer("C1"),
				new Date(System.currentTimeMillis()), new Date(2024 - 1900, 1 - 1, 21));
		orderDAO.insert(modelOrder);
	}
}
