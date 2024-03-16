package LapTrinhMang.ChuongTrinhQuanLySinhVien;

import java.sql.Connection;

interface ManageStudent {
	public int addStudent(ModelStudent modelStudent);

	public int removeStudent(ModelStudent modelStudent);

	public int alterStudent(ModelStudent modelStudent);

	public ModelStudent findingStudent(ModelStudent modelStudent);

	public Connection getConnection();

	public void closeConnection(Connection connection);
}
