package DanhSachSinhVien;

import java.util.Scanner;

class MainDanhSach {
	static Scanner sc = new Scanner(System.in);
	static boolean check;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choose = 0;

		DanhSachSinhVien dssv = new DanhSachSinhVien();
		do {
			do {
				try {
					do {
						System.out.println("Hãy nhập lựa chọn của bạn:");
						System.out.println("1. Thêm sinh viên");
						System.out.println("2. In danh sách sinh viên");
						System.out.println("3. Kiểm tra danh sách sinh viên có rỗng");
						System.out.println("4. Làm rỗng danh sách sinh viên");
						System.out.println("5. Tìm kiếm sinh viên theo MSSV");
						System.out.println("6. Xóa sinh viên theo MSSV");
						System.out.println("7. In danh sách sinh viên theo tên");
						System.out.println("8. Sắp xếp danh sách sinh viên theo điểm");
						System.out.println("0. Thoát");
						System.out.println("==> ");
						choose = sc.nextInt();
						check = true;
					} while (choose < 0 || choose > 8);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Lựa chọn không hợp lệ!");
					check = false;
					sc.nextLine();
					System.out.println("\n--------------------------------\n");
				}
				sc.nextLine();
			} while (!check);
			luaChon(choose, dssv);
		} while (choose != 0);

	}

	static void luaChon(int choose, DanhSachSinhVien dssv) {

		switch (choose) {
		case 1: {
			int namSinh = 0;
			float diem = 0;
			// Nhập MSSV
			System.out.println("Hãy nhập MSSV: ");
			String mssv = sc.nextLine();

			// Nhập tên
			System.out.println("Hãy nhập họ tên: ");
			String hoTen = sc.nextLine();

			// Nhập năm sinh
			do {
				try {
					System.out.println("Hãy nhập năm sinh: ");
					namSinh = sc.nextInt();
					check = true;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Năm sinh không hợp lệ!");
					check = false;
					sc.nextLine();
				}
			} while (!check);

			// Nhập điểm
			do {
				try {
					System.out.println("Hãy nhập điểm: ");
					diem = sc.nextFloat();
					check = true;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Điểm không hợp lệ!");
					check = false;
					sc.nextLine();
				}
			} while (!check);
			SinhVien sinhVien = new SinhVien(mssv, hoTen, namSinh, diem);
			dssv.themSinhVien(sinhVien);
			break;
		}

		// In danh sách
		case 2: {
			dssv.inDanhSach();
			break;
		}

		// Kiểm tra danh sách rỗng
		case 3: {
			System.out.println("Danh sách của sinh viên có rỗng hay không?: " + dssv.kiemTraDanhSachRong());
			break;
		}

		// Làm rỗng danh sách
		case 4: {
			dssv.lamRongDanhSach();
			break;
		}

		// Tìm kiếm sinh viên theo MSSV
		case 5: {
			System.out.println("Hãy nhập mã số sinh viên cần tìm: ");
			String ms = sc.nextLine();
			SinhVien sv = new SinhVien(ms);
			System.out.println("Có sinh viên nào có mã số là " + ms + " hay không?: " + dssv.timKiemSinhVien(sv));
		}

		// Xóa sinh viên theo MSSV
		case 6: {
			System.out.println("Hãy nhập mã số sinh viên cần xóa: ");
			String ms = sc.nextLine();
			SinhVien sv = new SinhVien(ms);
			dssv.xoaSinhVien(sv);
			break;
		}

		// In danh sách sinh viên theo tên
		case 7: {
			System.out.println("Hãy nhập tên sinh viên: ");
			String ten = sc.nextLine();
			dssv.inTheoTen(ten);
		}

		// Sắp xếp sinh viên theo điểm
		case 8: {
			dssv.sapXepSinhVien();
		}
		}
	}
}
