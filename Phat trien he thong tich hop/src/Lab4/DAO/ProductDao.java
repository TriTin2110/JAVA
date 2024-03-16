package Lab4.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import JDBC.JDBCUtil;
import Lab4.ClientServer.process;
import Lab4.model.modelProduct;

public class ProductDao implements process<modelProduct> {

	@Override
	public String insert(modelProduct t) {
		System.out.println(t.toString());
		// TODO Auto-generated method stub
		//Lấy id của sản phẩm có cùng id của người dùng nhập vào
		String result = selectByID(t).split(",")[0];
		//Kiểm tra sản phẩm đã tồn tại trong danh sách chưa
		//Nếu chưa tồn tại thì selectByID(t).split(",")[0] sẽ trả về productID=
		//Ngược lại sẽ trả về productID=(id)
		if (result.equals("productID=")) {
			try {
				Connection connection = JDBCUtil.getConnect();
				String sql = "insert into Product value (?, ?, ?, ?)";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, t.getProductID());
				preparedStatement.setString(2, t.getProductName());
				preparedStatement.setLong(3, t.getPrice());
				preparedStatement.setString(4, t.getCompanyID());
				result = "Thêm thành công " + preparedStatement.executeUpdate() + " dòng sản phẩm!";
				JDBCUtil.closeConnect(connection);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return result;
		} else {
			result = "Sản phẩm đã tồn tại trong danh sách";
			System.out.println(result);
			return result;
		}
		
	}

	@Override
	public String delete(modelProduct t) {
		// TODO Auto-generated method stub
		String result = "Không tồn tại sản phẩm có mã là " + t.getProductID();
		// Lấy mã sản phẩm từ chuỗi mà selectByID trả về
		String r = selectByID(t).split(",")[0];
		if (r.equals("productID=")) {
			return result;
		} else {
			try {
				Connection connection = JDBCUtil.getConnect();
				String sql = "delete from Product where product_ID = ?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, t.getProductID());
				result = "Đã cập nhật thành công " + preparedStatement.executeUpdate() + " dòng";
				JDBCUtil.closeConnect(connection);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return result;
	}

	@Override
	public String update(modelProduct t) {
		// TODO Auto-generated method stub
		String r = selectByID(t).split(",")[0];
		if (r.equals("productID=")) {
			return "Không tìm thấy sản phẩm có mà là " + t.getProductID();
		} else {
			delete(t);
			insert(t);
			return "Đã cập nhật thành công 1 dòng sản phẩm";
		}

	}

	@Override
	public String selectByID(modelProduct t) {
		// TODO Auto-generated method stub
		modelProduct modelProduct = new modelProduct("");
		try {
			Connection connection = JDBCUtil.getConnect();
			String sql = "select * from Product where product_ID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getProductID());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String productID = resultSet.getString(1);
				String productName = resultSet.getString(2);
				long price = resultSet.getLong(3);
				String companyID = resultSet.getString(4);
				modelProduct = new modelProduct(productID, productName, companyID, price);
				break;
			}
			JDBCUtil.closeConnect(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return modelProduct.toString();
	}
}
