import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

class TaiXiu {
	static Scanner sc = new Scanner(System.in);
	static boolean check = true;
	static Locale lo = new Locale("vi", "VN");
	static NumberFormat numf = NumberFormat.getCurrencyInstance(lo);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choose = 0;
		long soTienConLai = 50000;
		long soTienCuoc = 0;
		do {
			if (soTienConLai > 0) {

				System.out.println("Số tiền còn lại là: " + numf.format(soTienConLai));
				choose = nhapLuaChon(soTienCuoc, choose);
				if (choose == 1 || choose == 2) {
					soTienConLai = xuLy(nhapSoTienCuoc(soTienCuoc, soTienConLai), choose, soTienConLai);
				}

			} else {
				String thongBaoKetThuc = "Bạn đã hết tiền!";
				for (int i = 0; i < thongBaoKetThuc.length(); i++) {
					System.out.print(thongBaoKetThuc.charAt(i));
					try {
						Thread.sleep(15);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.exit(0);
			}
		} while (choose != 0);

		String loiCamOn = "Cảm ơn bạn đã tham gia trò chơi!";
		for (int i = 0; i < loiCamOn.length(); i++) {
			System.out.print(loiCamOn.charAt(i));
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.exit(0);
	}

	static int nhapLuaChon(long soTienCuoc, int choose) {
		do {
			try {
				do {
					System.out.println("Hãy nhập lựa chọn của bạn:");
					System.out.println("1. Đặt tài");
					System.out.println("2. Đặt xỉu");
					System.out.println("0. Thoát");
					System.out.print("==> ");
					choose = sc.nextInt();
					check = true;
				} while (choose < 0 || choose > 2);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Lựa chọn của bạn không hợp lệ!");
				check = false;
			}
			sc.nextLine();
			System.out.println("\n--------------------------\n");
		} while (!check);
		return choose;
	}

	static long nhapSoTienCuoc(long soTienCuoc, long soTienConLai) {
		do {
			try {
				do {
					System.out.println("Hãy nhập số tiền cược: ");
					soTienCuoc = sc.nextLong();
					check = true;
				} while (soTienCuoc < 0 || soTienCuoc > soTienConLai);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Số tiền cược không hợp lệ!");
				check = false;
			}
			sc.nextLine();
		} while (!check);
		System.out.println();
		return soTienCuoc;
	}

	// Tung xúc xắc
	static long xuLy(long soTienCuoc, int luaChon, long soTienConLai) {

		Random rd = new Random();
		// Do hàm Random bắt đầu từ 0 nên phải cộng thêm 1
		int xucXacMot = rd.nextInt(5) + 1;
		int xucXacHai = rd.nextInt(5) + 1;
		int xucXacBa = rd.nextInt(5) + 1;

		int tong = xucXacMot + xucXacHai + xucXacBa;
		System.out.println("Kết quả của đợt này là: " + xucXacMot + "-" + xucXacHai + "-" + xucXacBa);
		if (tong > 3 && tong < 10) {
			System.out.println("Xỉu!");
		} else if (tong < 18) {
			System.out.println("Tài!");
		} else {
			System.out.println("Nhà cái thắng!");
		}

		if (tong > 3 && tong < 10 && luaChon == 2) {
			System.out.println("Bạn đã thắng!");
			soTienConLai += soTienCuoc;
			System.out.println("Số tiền còn lại là: " + numf.format(soTienConLai));

		} else if (tong > 10 && tong < 18 && luaChon == 1) {
			System.out.println("Bạn đã thắng!");
			soTienConLai += soTienCuoc;
			System.out.println("Số tiền còn lại là: " + numf.format(soTienConLai));

		} else {
			System.out.println("Bạn đã thua!");
			soTienConLai -= soTienCuoc;
			System.out.println("Số tiền còn lại là: " + numf.format(soTienConLai));
		}
		System.out.println("\n----------------------------");
		return soTienConLai;
	}
}
