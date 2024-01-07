import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int check;
		long soDu = 0, tienNap, tienRut;
		do {
			try {
				do {
					System.out.println("\n------------------------\n");
					System.out.println("Hãy nhập lựa chọn của bạn!");
					System.out.println("1. Kiểm tra số dư");
					System.out.println("2. Nạp tiền");
					System.out.println("3. Rút tiền");
					System.out.println("4. Thoát");
					System.out.print("==> ");
					check = sc.nextInt();
				} while (check < 0 || check > 4);
			} catch (Exception e) {
				System.out.println("Lựa chọn không hợp lệ: ");
				sc.close();
				return;
			}
			switch (check) {
			case 1: {
				System.out.println("Số dư trong tài khoản là: " + soDu);
				break;
			}
			case 2: {
				try {
					do {
						System.out.println("Hãy nhập số tiền nhập: ");
						tienNap = sc.nextLong();
					} while (tienNap < 0);
				} catch (Exception e) {
					System.out.println("Giá trị nạp vào không hợp lệ!");
					sc.close();
					return;
				}
				soDu = napTien(tienNap, soDu);
				System.out.println("Đã nạp " + tienNap);
				break;
			}
			case 3: {
				try {
					do {
						System.out.println("Hãy nhập số tiền rút: ");
						tienRut = sc.nextLong();
					} while (tienRut < 0);
				} catch (Exception e) {
					System.out.println("Giá trị rút ra không hợp lệ!");
					sc.close();
					return;
				}
				if (soDu < tienRut) {
					System.out.println("Tài khoản không đủ tiền để rút!");
					break;
				} else {
					soDu = rutTien(tienRut, soDu);
					System.out.println("Đã rút " + tienRut);
					break;
				}
			}
			}
		} while (check != 4);
		System.out.println("Cảm ơn bạn đã sử dụng dịch vụ!");
		sc.close();
	}

	public static long napTien(long soTienNap, long soDu) {
		return soDu + soTienNap;
	}

	public static long rutTien(long soTienRut, long soDu) {
		return soDu - soTienRut;
	}
}
