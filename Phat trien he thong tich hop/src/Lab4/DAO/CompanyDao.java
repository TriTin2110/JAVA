package Lab4.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JOptionPane;

import JDBC.JDBCUtil;
import Lab4.ClientServer.process;
import Lab4.model.modelCompany;

public class CompanyDao implements process<modelCompany> {

        @Override
	public String insert(modelCompany t) {
		// TODO Auto-generated method stub
		String result = selectByID(t).split(",")[0];
		if (result.equals("companyID=")) {
                        try {
                                        System.out.println(t.toString());
                                        Connection connection = JDBCUtil.getConnect();
                                        String sql = "insert into Company value (?, ?)";
                                        PreparedStatement preparedStatement = connection.prepareStatement(sql);
                                        preparedStatement.setString(1, t.getCompanyID());
                                        preparedStatement.setString(2, t.getCompanyName());
                                        result = "Thêm thành công " + preparedStatement.executeUpdate() + " dòng sản phẩm!";
                                        JDBCUtil.closeConnect(connection);
                                        
                                } catch (Exception e) {
                                        // TODO: handle exception
                                        e.printStackTrace();
                                }
                                return result;
		} else {
                        result = "Công ty đã tồn tại trong danh sách";
                        return result;
		}
		
	}

	@Override
	public String delete(modelCompany t) {
		// TODO Auto-generated method stub
		String result = "Không tồn tại công ty có mã là " + t.getCompanyID();
		// Lấy mã sản phẩm từ chuỗi mà selectByID trả về
                String r = selectByID(t).split(",")[0];
		if (r.equals("companyID=")) {
			return result;
                } else {
			try {
				Connection connection = JDBCUtil.getConnect();
				String sql = "delete from Company where company_ID = ?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, t.getCompanyID());
                                result = "Đã cập nhật thành công " + preparedStatement.executeUpdate() + " dòng";
				JDBCUtil.closeConnect(connection);
                        } catch (Exception e) {
                                // TODO: handle exception
                                result = "Hãy xóa những sản phẩm có liên quan đến công ty này trước!";
                        }
                        return result;
		}
		
	}

	@Override
        public String update(modelCompany t) {
            return null;
	}

	@Override
	public String selectByID(modelCompany t) {
		// TODO Auto-generated method stub
		modelCompany modelCompany = new modelCompany("");
		try {
			Connection connection = JDBCUtil.getConnect();
			String sql = "select * from Company where company_ID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getCompanyID());
			ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                                String companyID = resultSet.getString(1);
                                String companyName = resultSet.getString(2);
                                modelCompany = new modelCompany(companyID, companyName);
                                break;
                        }
                        System.out.println(modelCompany.toString());
			JDBCUtil.closeConnect(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return modelCompany.toString();
	}
        
}
