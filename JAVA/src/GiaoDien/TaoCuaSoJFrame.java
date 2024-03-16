package GiaoDien;

import javax.swing.JFrame;

class TaoCuaSoJFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jf = new JFrame();
		// Hiển thị cửa sổ
		jf.setVisible(true);

		// Cài đặt kích cỡ hiển thị
		jf.setSize(600, 400);

		// Cài đặt vị trí xuất hiện cửa sổ
		jf.setLocation(300, 300);

		// Đặt tên cho cửa sổ
		jf.setTitle("Ví dụ Jframe");

		// Đóng chương trình
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
