package DanhSachTinhThanh;

import java.util.Scanner;

class MainDanhSachTinh {
	static boolean check = true;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choose = 0;
		DanhSachTinh ds = new DanhSachTinh();
		do {
			do {
				try {
					do {
						System.out.println("Hãy nhập lựa chọn của bạn: ");
						System.out.println("1. Thêm tỉnh mới vào danh sách");
						System.out.println("2. Xóa tỉnh ra khỏi danh sách");
						System.out.println("3. In danh sách các tỉnh có trong danh sách");
						System.out.println("4. Tính tổng diện tích của tất cả tỉnh thành");
						System.out.println("5. Tìm tỉnh thành có diện tích lớn nhất");
						System.out.println("6. Sắp xếp danh sách theo mã");
						System.out.println("7. Sắp xếp danh sách theo diện tích");
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
			luaChon(choose, ds);
		} while (choose != 0);
	}

	static void luaChon(int choose, DanhSachTinh ds) {
		switch (choose) {

		// Thêm tỉnh
		case 1: {
			int maSo = 0;
			String tenTinh;
			long danSo = 0;
			double dienTich = 0;
			// Nhập mã số tỉnh
			do {
				try {
					do {
						System.out.println("Hãy nhập mã số của tỉnh: ");
						maSo = sc.nextInt();
						check = true;
					} while (maSo < 0);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Mã số của tỉnh không hợp lệ!");
					check = false;
				}
				sc.nextLine();
				if (!ds.kiemTraMaSoTinh(maSo)) {
					check = false;
				}
				System.out.println("\n---------------------");
			} while (!check);

			// Nhập tên tỉnh
			System.out.println("Hãy nhập tên của tỉnh: ");
			tenTinh = sc.nextLine();

			// Nhập dân số
			do {
				try {
					do {
						System.out.println("Hãy nhập dân số của tỉnh: ");
						danSo = sc.nextLong();
						check = true;
					} while (danSo < 0);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Dân số của tỉnh không hợp lệ!");
					check = false;
				}
				sc.nextLine();
				System.out.println("\n---------------------");
			} while (!check);

			// Nhập diện tích
			do {
				try {
					do {
						System.out.println("Hãy nhập diện tích của tỉnh: ");
						dienTich = sc.nextInt();
						check = true;
					} while (dienTich < 0);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Diện tích của tỉnh không hợp lệ!");
					check = false;
				}
				sc.nextLine();
				System.out.println("\n---------------------");
			} while (!check);
			Tinh tinh = new Tinh(maSo, tenTinh, danSo, dienTich);
			ds.themTinhMoi(tinh);
			break;
		}

		// Xóa tỉnh
		case 2: {
			int maSo = 0;
			do {
				try {
					do {
						System.out.println("Hãy nhập mã số của tỉnh: ");
						maSo = sc.nextInt();
						check = true;
					} while (maSo < 0);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Mã số của tỉnh không hợp lệ!");
					check = false;
				}
				sc.nextLine();
				System.out.println("\n---------------------");
			} while (!check);
			Tinh tinh = new Tinh(maSo);
			ds.xoaTinhTheoMaSo(tinh);
			break;
		}

		// In danh sách tỉnh
		case 3: {
			ds.inDanhSachTinh();
			break;
		}

		// Tính tổng diện tích của tất cả tỉnh thành
		case 4: {
			System.out.println("Diện tích của tất cả các tỉnh thành là: " + ds.tinhTongDienTichCuaTatCaCacTinhThanh());
			break;
		}

		// Tìm tỉnh thành có diện tích lớn nhất
		case 5: {
			ds.timTinhDienTichLonNhat();
			break;
		}

		// Sắp xếp danh sách theo mã
		case 6: {
			ds.sapXepTinhTheoMa();
			break;
		}

		// Sắp xếp danh sách theo diện tích
		case 7: {
			ds.sapXepTinhTheoDienTich();
			break;
		}
		}
	}
}
