package CaPhe;

import java.util.Scanner;

class MainCafe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int soLuongHoaDon;
		try {
			do {
				System.out.println("Hãy nhập số lượng hóa đơn: ");
				soLuongHoaDon = sc.nextInt();
			} while (soLuongHoaDon < 1);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Số lượng của hóa đơn không hợp lệ!");
			sc.close();
			return;
		}
		sc.nextLine();
		HoaDon[] hd = new HoaDon[soLuongHoaDon];
		String tenLoaiCaPhe;
		double giaTien, khoiLuong;
		for (int i = 0; i < hd.length; i++) {
			System.out.println("Hãy nhập tên của loại cà phê: ");
			tenLoaiCaPhe = sc.nextLine();

			try {
				do {
					System.out.println("Hãy nhập giá tiền của cà phê (/1kg): ");
					giaTien = sc.nextDouble();
				} while (giaTien < 0);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Giá tiền của loại cà phê không hợp lệ!");
				sc.close();
				return;
			}

			try {
				do {
					System.out.println("Hãy nhập khối lượng: ");
					khoiLuong = sc.nextDouble();
				} while (khoiLuong < 0);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Khối lượng của loại cà phê không hợp lệ!");
				sc.close();
				return;
			}

			hd[i] = new HoaDon(tenLoaiCaPhe, giaTien, khoiLuong);
			sc.nextLine();
			System.out.println("\n--------------------------\n");
		}
		outPut(hd);
		sc.close();
	}

	static void outPut(HoaDon[] hd) {
		for (int i = 0; i < hd.length; i++) {
			System.out.println("Thông tin của loại cà phê thứ " + (i + 1) + "!");
			System.out.println(hd[i].inThongTin());
			System.out.println("Khối lượng mua có lớn hơn khối lượng tồn kho?: " + hd[i].kiemTraKhoiLuong(10));
			System.out.println("Tổng tiền của hóa đơn là: " + hd[i].tinhTongTienHoaDon());
			System.out.println("Hóa đơn có được giảm giá không?: " + hd[i].kiemTraHoaDonCoDuocGiam(100000));
			System.out.println("Số tiền giảm giá của hóa đơn là: " + hd[i].tinhSoTienGiam(10));
			System.out.println("Tổng số tiền sau khi giảm giá là: " + hd[i].tinhTongTienSauKhiGiam());
			System.out.println("\n-------------------------------\n");
		}
	}
}
