package DanhSachSinhVien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class DanhSachSinhVien {
	ArrayList<SinhVien> danhSach;

	public DanhSachSinhVien() {
		this.danhSach = new ArrayList<SinhVien>();
	}

//Thêm sinh viên
	void themSinhVien(SinhVien sinhVien) {
		this.danhSach.add(sinhVien);
	}

	// In danh sách
	void inDanhSach() {
		for (SinhVien sinhVien : danhSach) {
			System.out.println(sinhVien);
		}
	}

	// Kiểm tra danh sách rỗng
	boolean kiemTraDanhSachRong() {
		return danhSach.isEmpty();
	}

	// Làm rỗng danh sách
	void lamRongDanhSach() {
		danhSach.removeAll(danhSach);
	}

	// Tìm kiếm sinh viên theo MSSV
//	boolean timKiemSinhVien(SinhVien sv) {
//		/*
//		 * Sẽ chuyển danh sách thành stream() (luồng dữ liệu) sau đó sẽ so sánh nếu có
//		 * bất kỳ mã số sinh viên nào giống với mã số sinh viên ng dùng nhập vào thì sẽ
//		 * trả về 0 ==> true
//		 */
//		return danhSach.stream().anyMatch(sinhVien -> sinhVien.getMSSV().compareTo(sv.getMSSV()) == 0);
//	}

	// Tìm kiếm sinh viên theo MSSV
	boolean timKiemSinhVien(SinhVien sv) {
		if (danhSach.contains(sv)) {
			return true;
		} else {
			return false;
		}
	}

	// Xóa sinh viên theo MSSV
	void xoaSinhVien(SinhVien sv) {
		if (danhSach.contains(sv)) {
			danhSach.remove(sv);
		}
	}

	// In danh sách sinh viên theo tên
	void inTheoTen(String ten) {
		danhSach.stream().forEach(sinhVien -> {
			if (sinhVien.getHoVaTen().compareTo(ten) == 0) {
				System.out.println(sinhVien);
			}
		});
	}

	// Sắp xếp sinh viên theo điểm
	void sapXepSinhVien() {
		Collections.sort(danhSach, new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				// TODO Auto-generated method stub
				if (o1.getDiem() > o2.getDiem()) {
					return 1;
				} else if (o1.getDiem() < o2.getDiem()) {
					return -1;
				} else {
					return 0;
				}
			}
		});
	}
}
