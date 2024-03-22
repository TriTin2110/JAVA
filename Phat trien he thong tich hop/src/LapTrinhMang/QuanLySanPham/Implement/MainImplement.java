package LapTrinhMang.QuanLySanPham.Implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import LapTrinhMang.QuanLySanPham.Connect.MyConnection;
import LapTrinhMang.QuanLySanPham.Interface.MainInterface;
import LapTrinhMang.QuanLySanPham.Model.ModelCompany;
import LapTrinhMang.QuanLySanPham.Model.ModelProduct;
import LapTrinhMang.QuanLySanPham.MyClass.CheckingConstraint;

public class MainImplement implements MainInterface {

	@Override
	public int add(Object object) {
		// TODO Auto-generated method stub
		try {
			Connection connection = MyConnection.getConnection();
			String sql = "";
			if (object instanceof ModelCompany) {
				ModelCompany modelCompany = (ModelCompany) object;
				sql = "insert into company values ('" + modelCompany.getId() + "', '" + modelCompany.getName() + "', '"
						+ modelCompany.getAddressCompany() + "')";

			} else {
				ModelProduct modelProduct = (ModelProduct) object;
				sql = "insert into product values ('" + modelProduct.getId() + "', '" + modelProduct.getName() + "',"
						+ modelProduct.getPrice() + ", '" + modelProduct.getIdCompany() + "')";
			}
			Statement statement = connection.createStatement();
			return statement.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int remove(Object object) {
		// TODO Auto-generated method stub
		try {
			Connection connection = MyConnection.getConnection();
			String sql = "";
			if (object instanceof ModelCompany) {
				ModelCompany modelCompany = (ModelCompany) object;
				if (CheckingConstraint.checkingConstraintCompany(modelCompany)) {
					sql = "delete from company where id_company = '" + modelCompany.getId() + "'";
				} else {
					System.out.println("Lỗi ràng buộc!");
					return 0;
				}
			} else {
				ModelProduct modelProduct = (ModelProduct) object;
				sql = "delete from product where id_product = '" + modelProduct.getId() + "'";
			}
			Statement statement = connection.createStatement();
			return statement.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Object object) {
		// TODO Auto-generated method stub
		remove(object);
		return add(object);
	}

	@Override
	public Object searching(Object object) {
		// TODO Auto-generated method stub
		String sql = "";
		try {
			Connection connection = MyConnection.getConnection();
			if (object instanceof ModelCompany) {
				ModelCompany modelCompany = (ModelCompany) object;
				sql = "select * from company where id_company = '" + modelCompany.getId() + "'";
			} else {
				ModelProduct modelProduct = (ModelProduct) object;
				sql = "select * from product where id_product = '" + modelProduct.getId() + "'";
			}
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			// valiable = dữ liệu hiện có trong database
			boolean valiable = resultSet.next();
			if (valiable == false) {
				return null;
			} else if (valiable && object instanceof ModelCompany) {
				return new ModelCompany(resultSet.getString("id_company"), resultSet.getString("name_company"),
						resultSet.getString("address_company"));
			} else {
				return new ModelProduct(resultSet.getString("id_product"), resultSet.getString("name_product"),
						resultSet.getLong("price_product"), resultSet.getString("id_company"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public ArrayList<Object> printList(String currentTable) {
		// TODO Auto-generated method stub
		String sql = "";
		try {
			Connection connection = MyConnection.getConnection();
			ArrayList<Object> list = new ArrayList<Object>();
			Statement statement = connection.createStatement();
			if (currentTable.equals("Company")) {
				sql = "select * from company";
				ResultSet resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
					list.add(new ModelCompany(resultSet.getString("id_company"), resultSet.getString("name_company"),
							resultSet.getString("address_company")));
				}
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

}
