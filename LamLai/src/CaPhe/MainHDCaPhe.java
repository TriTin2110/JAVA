package CaPhe;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

class MainHDCaPhe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		HoaDonCaPhe hd1 = new HoaDonCaPhe("Trung Nguyên", 500000, 3.5);
		HoaDonCaPhe hd2 = new HoaDonCaPhe("Phố", 100000, 6);

		int soLuongHoaDon = 0;
		boolean check = true;
		do {
			try {
				do {
					System.out.println("Hãy nhập số lượng hóa đơn: ");
					soLuongHoaDon = sc.nextInt();
					check = true;
				} while (soLuongHoaDon < 0);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Số lượng hóa đơn không hợp lệ!");
				check = false;
			}
			sc.nextLine();
		} while (!check);

		HoaDonCaPhe[] hd = new HoaDonCaPhe[soLuongHoaDon];
		String ten;
		long gia = 0;
		double khoiLuong = 0;
		for (int i = 0; i < hd.length; i++) {
			System.out.println("Hãy nhập tên của loại cà phê thứ " + (i + 1) + ": ");
			ten = sc.nextLine();

			do {
				try {
					do {
						System.out.println("Hãy nhập số tiền của loại cà phê (/1kg): ");
						gia = sc.nextLong();
						check = true;
					} while (gia < 0);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Giá tiền của loại cà phê không hợp lệ!");
					System.out.println("\n---------------------");
					check = false;
				}
				sc.nextLine();
			} while (!check);
			do {
				try {
					do {
						System.out.println("Hãy nhập khối lượng của loại cà phê (/1kg): ");
						khoiLuong = sc.nextDouble();
						check = true;
					} while (khoiLuong < 0);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Khối lượng mua của hóa đơn không hợp lệ!");
					System.out.println("\n---------------------");
					check = false;
				}
				sc.nextLine();
			} while (!check);
			hd[i] = new HoaDonCaPhe(ten, gia, khoiLuong);
		}
		output(hd);
	}

	static void output(HoaDonCaPhe[] hd) {
		Locale lc = new Locale("vi", "VN");
		NumberFormat nf = NumberFormat.getCurrencyInstance(lc);
		for (int i = 0; i < hd.length; i++) {
			System.out.println("Thông tin của hóa đơn thứ " + (i + 1) + " là:");
			System.out.println("Tổng tiền: " + nf.format(hd[i].tinhTongTienCuaHoaDon()));
			System.out.println(hd[i].inThongTin());
			System.out.println("Hóa đơn này có được giảm giá hay không??: " + hd[i].kiemTraHoaDonCoDuocGiamGia(800000));
			System.out.println("Số tiền được giảm của hóa đơn là: " + nf.format(hd[i].tinhSoTienDuocGiam(10)));
			System.out.println("Tổng tiền sau giảm của hóa đơn là: " + nf.format(hd[i].tinhTongTienSauGiam()));
			System.out.println("\n----------------------\n");
		}
	}
}
