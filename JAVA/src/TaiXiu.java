import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class TaiXiu {
	// Lấy đĩa điểm bằng biến local
	static Locale lc = new Locale("vi", "VN");

	// Lấy kiểu định dạng tiền tệ thông qua getCurrencyInstance(quoc_gia);
	static NumberFormat num = NumberFormat.getCurrencyInstance(lc);

	// Nếu 3 hoặc 18 cái thắng
	// Nếu 4-10 xỉu thắng
	// Nếu 11-17 tài thắng
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int taiKhoan = 1000000000;
		int luaChon;
		do {
			System.out.println("\n\n");
			try {
				do {
					System.out.println("Tài khoản hiện tại: " + num.format(taiKhoan));
					System.out.println("______________________________________________");
					System.out.println("Hãy nhập lựa chọn của bạn");
					System.out.println("1. Đặt tài");
					System.out.println("2. Đặt xỉu");
					System.out.println("0. Thoát");
					System.out.print("==> ");
					luaChon = sc.nextInt();
				} while (luaChon < 0 || luaChon > 2);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Lụa chọn của bạn không hợp lệ!");
				sc.close();
				return;
			}
			sc.nextLine();
			taiKhoan = nhapTienCuoc(taiKhoan, luaChon);
			if (taiKhoan == 0) {
				sc.close();
				return;
			}
		} while (luaChon != 0);
		sc.close();
	}

	static int nhapTienCuoc(int taiKhoan, int luaChon) {
		Scanner sc = new Scanner(System.in);
		int tienCuoc = 0;
		try {
			do {
				System.out.print("Hãy nhập số tiền cược: ");
				tienCuoc = sc.nextInt();
			} while (tienCuoc < 0 || tienCuoc > taiKhoan);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Tiền cược không hợp lệ!");
			sc.close();
		}
		return xuLy(tienCuoc, luaChon, taiKhoan);
	}

	static int xuLy(int tienCuoc, int luaChon, int taiKhoan) {

		int tong = 0;
		// Hàm random dùng để random 1 số bất kỳ
		Random xucXac1 = new Random();
		Random xucXac2 = new Random();
		Random xucXac3 = new Random();
		int giaTri1 = xucXac1.nextInt(5) + 1;
		int giaTri2 = xucXac2.nextInt(5) + 1;
		int giaTri3 = xucXac3.nextInt(5) + 1;
		tong = giaTri1 + giaTri2 + giaTri3;

		System.out.println("Kết quả của vòng này là: " + giaTri1 + " - " + giaTri2 + " - " + giaTri3);
		System.out.println("Tổng = " + tong);
		if (tong >= 4 && tong <= 10) {
			System.out.println("==> Xỉu");
		} else if (tong >= 11 && tong <= 17) {
			System.out.println("==>  Tài");
		} else {
			System.out.println("==>  Cái thắng");
		}
		System.out.println("\n----------------------------\n");
		if (tong >= 4 && tong <= 10 && luaChon == 2) {
			taiKhoan += tienCuoc;
			System.out.println("Bạn đã thắng: " + num.format(tienCuoc));
			System.out.println("Số tiền hiện tại là: " + num.format(taiKhoan));
		} else if (tong >= 11 && tong <= 17 && luaChon == 1) {
			taiKhoan += tienCuoc;
			System.out.println("Bạn đã thắng: " + num.format(tienCuoc));
			System.out.println("Số tiền hiện tại là: " + num.format(taiKhoan));
		} else {
			taiKhoan -= tienCuoc;
			System.out.println("Bạn đã thua: " + num.format(tienCuoc));
			System.out.println("Số tiền hiện tại là: " + num.format(taiKhoan));
		}
		return taiKhoan;
	}
}
