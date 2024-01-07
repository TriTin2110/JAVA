package DanhSachSinhVien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class DanhSachSinhVien {
	ArrayList<SinhVien> dssv;

	public DanhSachSinhVien() {
		dssv = new ArrayList<SinhVien>();
	}

	void themSinhVien(SinhVien sv) {
		dssv.add(sv);
	}

	void inDanhSach() {
		dssv.stream().forEach(sv -> {
			System.out.println(sv);
		});
		;
	}

	boolean kiemTraDanhSachRong() {
		return dssv.isEmpty();
	}

	void lamRongDanhSach() {
		dssv.clear();
	}

	void timKiemSinhVienTheoMS(SinhVien sv) {
		System.out.println("Kết quả tìm kiếm là:");
		dssv.stream().forEach(sinhVien -> {
			if (sinhVien.getMSSV().compareTo(sv.getMSSV()) == 0) {
				System.out.println(sinhVien);
			}

		});
		if (dssv.stream().allMatch(sinhVien -> sinhVien.getMSSV().compareTo(sv.getMSSV()) != 0)) {
			System.out.println("Sinh viên không tồn tại trong danh sách!");
		}
	}

	void xoaSinhVienTheoTen(SinhVien sv) {

		if (dssv.contains(sv)) {
			dssv.remove(sv);
		} else {
			System.out.println("Không có sinh viên nào có mã số là: " + sv.getMSSV());
		}
	}

	void sapXepSinhVienTheoDiem() {
		Collections.sort(dssv, new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				if (o1.getDiemGPA() > o2.getDiemGPA()) {
					return 1;
				} else if (o1.getDiemGPA() < o2.getDiemGPA()) {
					return -1;
				} else {
					return 0;
				}
			}
		});
	}

}
