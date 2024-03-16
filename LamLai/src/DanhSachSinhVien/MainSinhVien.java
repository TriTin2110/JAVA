package DanhSachSinhVien;

import java.util.Scanner;

class MainSinhVien {
	static Scanner sc = new Scanner(System.in);
	static boolean check = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choose = 0;
		DanhSachSinhVien ds = new DanhSachSinhVien();
		do {
			do {
				try {
					do {
						System.out.println("Hãy nhập lựa chọn của bạn:");
						System.out.println("1. Thêm sinh viên");
						System.out.println("2. In danh sách sinh viên");
						System.out.println("3. Kiểm tra danh sách sinh viên có phải rỗng");
						System.out.println("4. Làm rỗng danh sách sinh viên");
						System.out.println("5. Tìm kiếm sinh viên theo mã số sinh viên");
						System.out.println("6. Xóa sinh viên theo tên sinh viên");
						System.out.println("7. Sắp xếp sinh viên theo tên điểm");
						System.out.println("0. Thoát");
						System.out.print("==> ");
						choose = sc.nextInt();
						check = true;
					} while (choose < 0 || choose > 8);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Lựa chọn của bạn không hợp lệ!");
					check = false;
				}
				System.out.println("\n------------------------------\n");
				sc.nextLine();
			} while (!check);

			luaChon(choose, ds);
		} while (choose != 0);

	}

	static void luaChon(int choose, DanhSachSinhVien ds) {
		switch (choose) {

		// Thêm sinh viên vào danh sách
		case 1: {
			String tenSV, MSSV;
			double diem = 0;
			do {
				System.out.println("Hãy nhập tên của sinh viên: ");
				tenSV = sc.nextLine();
				System.out.println("Hãy nhập mã số sinh viên: ");
				MSSV = sc.nextLine();
				try {
					do {
						System.out.println("Hãy nhập điểm của sinh viên: ");
						diem = sc.nextDouble();
						check = true;
					} while (diem < 0 || diem > 10);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Điểm của sinh viên không hợp lệ!");
					check = false;
				}
				sc.nextLine();
				System.out.println("\n");
			} while (!check);
			SinhVien sv = new SinhVien(MSSV, tenSV, diem);
			ds.themSinhVien(sv);
			break;
		}

		// In ra danh sách sinh viên
		case 2: {
			ds.inDanhSach();
			break;
		}

		// Kiểm tra danh sách sinh viên có rỗng
		case 3: {
			System.out.println(ds.kiemTraDanhSachRong());
			break;
		}

		// Làm rỗng danh sách sinh viên
		case 4: {
			ds.lamRongDanhSach();
			break;
		}

		// Tìm kiếm sinh viên dựa theo MSSV
		case 5: {
			String mssv;
			System.out.println("Hãy nhập mã số sinh viên mà bạn cần tìm: ");
			mssv = sc.nextLine();
			SinhVien sv = new SinhVien(mssv);
			ds.timKiemSinhVienTheoMS(sv);
			break;
		}

		// Xóa sinh viên theo tên
		case 6: {
			String MS;
			System.out.println("Hãy nhập MSSV của sinh viên mà bạn muốn xóa: ");
			MS = sc.nextLine();
			SinhVien sv = new SinhVien(MS);
			ds.xoaSinhVienTheoTen(sv);
		}

		// Sắp xếp sinh viên theo điểm
		case 7: {
			ds.sapXepSinhVienTheoDiem();
		}
		}
	}
}
