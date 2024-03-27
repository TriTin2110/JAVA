package DanhSachTinhThanh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class DanhSachTinh {
	ArrayList<Tinh> tinh = new ArrayList<Tinh>();

	// Kiểm tra mã số tỉnh
	boolean kiemTraMaSoTinh(int maSoThemvao) {
		boolean check = true;
		for (Tinh tinh2 : tinh) {
			if (tinh2.getMaTinh() == maSoThemvao) {
				check = false;
			}
		}
		return check;
	}

	public DanhSachTinh() {
	}

	// Thêm tỉnh mới
	void themTinhMoi(Tinh tinhMoi) {
		tinh.add(tinhMoi);
	}

	// Xóa tỉnh theo mã số
	void xoaTinhTheoMaSo(Tinh tinhNhapVao) {
		tinh.remove(tinhNhapVao);
	}

	// In danh sách
	void inDanhSachTinh() {
		for (Tinh tinh2 : tinh) {
			System.out.println(tinh2);
		}
	}

	// Tính tổng diện tích của tất cả các tỉnh
	double tinhTongDienTichCuaTatCaCacTinhThanh() {
		double tongDienTich = 0;
		for (Tinh tinh2 : tinh) {
			tongDienTich += tinh2.getDienTich();
		}
		return tongDienTich;
	}

	// Tìm tỉnh có diện tích lớn nhất
	void timTinhDienTichLonNhat() {
		int i = 0;
		for (int j = 0; j < tinh.size() - 1; j++) {
			for (int j2 = j + 1; j2 < tinh.size(); j2++) {
				if (tinh.get(j).getDienTich() < tinh.get(j2).getDienTich()) {
					i = j2;
				}
			}
		}
		System.out.println(tinh.get(i));
	}

	// Tìm tỉnh thành có dân số lớn nhất
	void timTinhDanSoLonNhat() {
		int i = 0;
		for (int j = 0; j < tinh.size() - 1; j++) {
			for (int j2 = j + 1; j2 < tinh.size(); j2++) {
				if (tinh.get(j).getDanSo() < tinh.get(j2).getDanSo()) {
					i = j2;
				}
			}
		}
		System.out.println(tinh.get(i));
	}

	// Sắp xếp tỉnh theo mã
	void sapXepTinhTheoMa() {
		Collections.sort(tinh, new Comparator<Tinh>() {

			@Override
			public int compare(Tinh o1, Tinh o2) {
				// TODO Auto-generated method stub
				if (o1.getMaTinh() > o2.getMaTinh()) {
					return 1;
				} else if (o1.getMaTinh() < o2.getMaTinh()) {
					return -1;
				} else {
					return 0;
				}
			}
		});
	}

	// Sắp xếp tỉnh theo diện tích
	void sapXepTinhTheoDienTich() {
		Collections.sort(tinh, new Comparator<Tinh>() {

			@Override
			public int compare(Tinh o1, Tinh o2) {
				// TODO Auto-generated method stub
				if (o1.getDienTich() > o2.getDienTich()) {
					return 1;
				} else if (o1.getDienTich() < o2.getDienTich()) {
					return -1;
				} else {
					return 0;
				}
			}
		});
	}

}
