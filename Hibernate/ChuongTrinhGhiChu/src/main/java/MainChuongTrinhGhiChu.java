import javax.swing.UIManager;

import View.viewDangNhap;

public class MainChuongTrinhGhiChu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		new viewDangNhap();
	}

}
