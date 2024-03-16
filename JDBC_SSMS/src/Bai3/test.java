package Bai3;

import Bai3.database.DatabaseUser;
import model.modelUser;

public class test {

	public static void main(String[] args) {
//		modelSach sach = new modelSach(1, 2023, "Lập trình Java", 25000);
//		DatabaseSach.getInstance().insert(sach);
//		DatabaseSach.getInstance().selectAll().forEach((inSach) -> System.out.println(inSach));
//		System.out.println("------------------------------------------");
//		System.out.println(DatabaseSach.getInstance().selectByID(1));
//		modelSach sach2 = new modelSach(2);
//		DatabaseSach.getInstance().delete(sach2);
//		modelSach sach3 = new modelSach(3, 2023, "Lập trình C++", 20000);
//		DatabaseSach.getInstance().update(sach3);
//		Date date = new Date(2023 - 1900, 9 - 1, 10);
//		khachHang khachHang = new khachHang(0, "Nguyễn Trí Tín", date);
//		DatabaseKhachHang.getInstance().insert(khachHang);
//
//		DatabaseKhachHang.getInstance().delete(new khachHang(1));
//
//		DatabaseKhachHang.getInstance().update(new khachHang(2, "NTT", date));

		// DatabaseKhachHang.getInstance().selectAll().forEach((khachHang) ->
		// System.out.println(khachHang));
		// System.out.println(DatabaseKhachHang.getInstance().selectByID(2));
//		modelUser modelUser = new modelUser("nguyentritin", "nguyentritin123");
//		DatabaseUser.getInstance().insert(modelUser);

//		modelUser modelUser2 = new modelUser("nguyentritin");
//		DatabaseUser.getInstance().delete(modelUser2);

//		modelUser modelUser2 = new modelUser("nguyentritin", "123");
//		DatabaseUser.getInstance().update(modelUser2);
//		DatabaseUser.getInstance().selectAll();

		DatabaseUser.getInstance().selectByID(new modelUser("nguyentritin"));
	}

}
