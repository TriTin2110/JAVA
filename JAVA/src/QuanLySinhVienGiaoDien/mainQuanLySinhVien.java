package QuanLySinhVienGiaoDien;

import javax.swing.UIManager;

import QuanLySinhVienGiaoDien.QuanLySinhVienView.ViewSinhVien;

public class mainQuanLySinhVien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new ViewSinhVien();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
