package HoaDonCaPhe;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class MainCaPhe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		HoaDonCaPhe hoaDonCaPhe = new HoaDonCaPhe();
		int choose = 0;
		boolean check = true;
		File file = new File("D:\\Code\\JAVA\\JAVA\\src\\HoaDonCaPhe\\hoaDon.data");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		do {
			do {
				try {
					do {
						System.out.println("Hãy nhập lựa chọn của bạn:");
						System.out.println("1. Thêm hóa đơn");
						System.out.println("2. In hóa đơn");
						System.out.println("0. Thoát");
						System.out.print("==> ");
						choose = sc.nextInt();
						check = true;
					} while (choose < 0);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Lựa chọn của bạn không hợp lệ!");
					check = false;
				}
				sc.nextLine();
			} while (!check);
			luaChon(choose, hoaDonCaPhe, file);
		} while (choose != 0);

	}

	static void luaChon(int choose, HoaDonCaPhe hoaDonCaPhe, File file) {
		switch (choose) {
		case 1:
			hoaDonCaPhe.themHoaDon();
			break;

		case 2:
			hoaDonCaPhe.inHoaDon();
			break;

		case 3:
			hoaDonCaPhe.luuHoaDon(file);
			break;

		case 4:
			hoaDonCaPhe.docHoaDon(file);
			break;
		}

	}
}
