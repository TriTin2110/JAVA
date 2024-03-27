package File;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class MainDanhSachSinhVien {
	static boolean check = true;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DanhSachSinhVien ds = new DanhSachSinhVien();
		int choose = 0;
		do {
			do {
				try {
					do {
						System.out.println("Hãy nhập lựa chọn của bạn:");
						System.out.println("1.\tThêm sinh viên vào danh sách");
						System.out.println("2.\tIn danh sách sinh viên");
						System.out.println("3.\tLàm rỗng danh sách sinh viên");
						System.out.println("4.\tKiểm tra danh sách sinh viên có rỗng hay không");
						System.out.println("5.\tXóa sinh viên dựa theo mã số");
						System.out.println("6.\tIn danh sách dựa theo mã số cần tìm");
						System.out.println("7.\tIn danh sách dựa theo tên cần tìm");
						System.out.println("8.\tSắp xếp danh sách theo điểm");
						System.out.println("9.\tSắp xếp danh sách theo tên");
						System.out.println("10.\tIn số lượng sinh viên có trong danh sách");
						System.out.println("11.\tLưu danh sách vào file");
						System.out.println("12.\tLấy danh sách từ file");
						System.out.println("0.\tThoát");
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
			System.out.println("\n------------------------------\n");
		} while (choose != 0);
	}

	static void luaChon(int choose, DanhSachSinhVien ds) {
		switch (choose) {
		case 1: {
			String tenSinhVien;
			int maSoSinhVien = 0, namNhapHoc = 0;
			float diemSo = 0;
			do {
				try {
					do {
						System.out.print("Hãy nhập mã số sinh viên: ");
						maSoSinhVien = sc.nextInt();
						check = true;
					} while (maSoSinhVien < 1);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Mã số sinh viên bạn nhập vào không hợp lệ!");
					check = false;
				}
				sc.nextLine();
			} while (!check);

			System.out.println("Hãy nhập tên sinh viên: ");
			tenSinhVien = sc.nextLine();
			tenSinhVien.trim();
			do {
				try {
					do {
						System.out.print("Hãy nhập điểm số của sinh viên: ");
						diemSo = sc.nextFloat();
						check = true;
					} while (diemSo < 0 || diemSo > 10);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Điểm số của sinh viên bạn nhập vào không hợp lệ!");
					check = false;
				}
				sc.nextLine();
			} while (!check);

			do {
				try {
					do {
						System.out.print("Hãy nhập năm nhập học của sinh viên: ");
						namNhapHoc = sc.nextInt();
						check = true;
					} while (namNhapHoc < 2000);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Năm nhập học của sinh viên bạn nhập vào không hợp lệ!");
					check = false;
				}
				sc.nextLine();
			} while (!check);

			SinhVien sv = new SinhVien(maSoSinhVien, namNhapHoc, tenSinhVien, diemSo);
			ds.themSinhVien(sv, choose);
			break;
		}

		case 2:
			ds.inDanhSachSinhVien();
			break;

		case 3:
			ds.lamRongDanhSach();
			break;
		case 4:
			System.out.println(ds.kiemTraDanhSachRong());
			break;

		case 5: {
			int maSoSinhVien = 0;
			do {
				try {
					do {
						System.out.println("Hãy nhập mã số sinh viên mà bạn muốn xóa: ");
						maSoSinhVien = sc.nextInt();
						check = true;
					} while (maSoSinhVien < 1);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Mã số sinh viên không hợp lệ!");
					check = false;
				}
				sc.nextLine();
			} while (!check);
			SinhVien svXoa = new SinhVien(maSoSinhVien);
			ds.xoaSinhVien(svXoa);
			break;
		}

		case 6: {
			int maSoSinhVien = 0;
			do {
				try {
					do {
						System.out.println("Hãy nhập mã số sinh viên mà bạn muốn xóa: ");
						maSoSinhVien = sc.nextInt();
						check = true;
					} while (maSoSinhVien < 1);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Mã số sinh viên không hợp lệ!");
					check = false;
				}
				sc.nextLine();
			} while (!check);
			SinhVien sv = new SinhVien(maSoSinhVien);
			ds.inDanhSachSinhVienTimTheoMaSo(sv);
			break;
		}

		case 7: {
			System.out.println("Hãy nhập tên sinh viên mà bạn cần tìm: ");
			String tenSinhVien = sc.nextLine();
			ds.inDanhSachTheoTen(tenSinhVien);
			break;
		}

		case 8: {
			ds.sapXepSinhVienTheoDiem();
			break;
		}

		case 9: {
			ds.sapXepSinhVienTheoTen();
			break;
		}

		case 10: {
			System.out.println(ds.traVeSoLuongSinhVienTrongDanhSach());
			break;
		}

		case 11: {
			File file = new File("D:\\DanhSachSinhVien.data");
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ds.luuThongTinSinhVien(file);
			break;
		}

		case 12: {
			File file = new File("D:\\DanhSachSinhVien.data");
			ds.layThongTinSinhVien(file);
			break;
		}
		}
	}

}
