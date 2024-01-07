package DanhSachXe;

import java.util.Scanner;

class MainXe {

	static Scanner sc = new Scanner(System.in);
	static DanhSachXe ds = new DanhSachXe();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choose = 0;
		boolean check = true;

		do {
			do {
				try {
					System.out.println("Hãy nhập lựa chọn của bạn:");
					System.out.println("1. Thêm xe mới vào danh sách");
					System.out.println("2. Tính thuế của tất cả các xe");
					System.out.println("3. In thuế của tất cả các xe");
					System.out.println("4. Tính tiền xe sau thuế");
					System.out.println("5. In danh sách xe");
					System.out.println("0. Thoát");
					System.out.print("==> ");
					choose = sc.nextInt();
					check = true;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Lựa chọn của bạn không hợp lệ!");
					check = false;
				}
				sc.nextLine();
			} while (!check);
			switch (choose) {
			case 1: {
				nhapXe(check);
				break;
			}

			case 2: {
				ds.tinhThue();
				break;
			}

			case 3: {
				ds.inThue();
				break;
			}

			case 4: {
				ds.tinhTienXeSauThue();
				break;
			}

			case 5: {
				ds.inThongTinXe();
				break;
			}
			}
		} while (choose != 0);
	}

	static void nhapXe(boolean check) {
		String chuXe, maSoXe, moTa;
		long giaXe = 0;
		int dungTich = 0;

		// Nhập mã số xe
		System.out.println("Hãy nhập mã số xe: ");
		maSoXe = sc.nextLine();

		// Nhập chủ xe
		System.out.println("Hãy nhập tên của chủ xe: ");
		chuXe = sc.nextLine();

		// Nhập mô tả
		System.out.println("Hãy nhập mô tả cho xe: ");
		moTa = sc.nextLine();

		// Nhập giá xe
		do {
			try {
				do {
					System.out.println("Hãy nhập giá xe: ");
					giaXe = sc.nextLong();
					check = true;
				} while (giaXe < 0);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Giá xe không hợp lệ!");
				check = false;
			}
			sc.nextLine();
		} while (!check);

		// Nhập dung tích
		do {
			try {
				do {
					System.out.println("Hãy nhập dung tích xe: ");
					dungTich = sc.nextInt();
					check = true;
				} while (dungTich < 0);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Dung tích xe không hợp lệ!");
				check = false;
			}
			sc.nextLine();
		} while (!check);
		Xe x = new Xe(maSoXe, chuXe, moTa, giaXe, dungTich);
		ds.themXe(x);
	}
}
