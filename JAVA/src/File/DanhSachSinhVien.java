package File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class DanhSachSinhVien {
	ArrayList<SinhVien> dssv;
	SinhVien sinhVienTim;
	int choose = 0;

	public DanhSachSinhVien() {
		this.dssv = new ArrayList<SinhVien>();
	}

	static void baoLoiMSSV() {
		System.out.println("Không thể thêm sinh viên do:");
		System.out.println("Mã số sinh viên đã tồn tại trong danh sách!");
	}

	static void khongTimThaySinhVien(SinhVien sv) {
		System.out.println("Không tìm thấy sinh viên nào có mã là: " + sv.getMaSinhVien());
	}

	// Tìm kiếm sinh viên dựa theo mã số (Xóa sinh viên, Tìm sinh viên theo mã)
	ArrayList<SinhVien> timKiemSinhVien(SinhVien sinhVienCanTim, int choose) {
		ArrayList<SinhVien> danhSachTim = new ArrayList<SinhVien>();
		for (SinhVien sinhVien : dssv) {
			if (sinhVien.getMaSinhVien() == sinhVienCanTim.getMaSinhVien()) {
				danhSachTim.add(sinhVien);
			}
		}
		if (danhSachTim.isEmpty() && choose == 5 || choose == 6) {
			khongTimThaySinhVien(sinhVienCanTim);
		}
		return danhSachTim;
	}

	// Lấy tên của sinh viên
	static String layTen(SinhVien sinhVien) {
		String ten = null;
		int layTen = sinhVien.getHoTen().lastIndexOf(" ") + 1;
		if (sinhVien.getHoTen().contains(" ") == false) {
			ten = sinhVien.getHoTen();
			return ten;
		} else {
			ten = sinhVien.getHoTen().substring(layTen);
			return ten;
		}

	}

	// Lấy họ của sinh viên
	static String layHo(SinhVien sinhVien) {
		String ho = null;
		int layHo = sinhVien.getHoTen().indexOf(' ');
		ho = sinhVien.getHoTen().substring(0, layHo);
		return ho;
	}

	// 1. Thêm sinh viên
	void themSinhVien(SinhVien sinhVienMoi, int choose) {
		boolean trungMaSinhVien = false;
		out: for (SinhVien sinhVien : dssv) {
			if (timKiemSinhVien(sinhVienMoi, 1).contains(sinhVien)) {
				trungMaSinhVien = true;
				break out;
			}
		}
		if (trungMaSinhVien) {
			baoLoiMSSV();
		} else {
			dssv.add(sinhVienMoi);
		}
	}

	// 2. In danh sách sinh viên
	void inDanhSachSinhVien() {
		for (SinhVien sinhVien : dssv) {
			System.out.println(sinhVien);
		}
	}

	// 3. Làm rỗng danh sách sinh viên
	void lamRongDanhSach() {
		dssv.clear();
	}

	// 4. Kiểm tra danh sách sinh viên có rỗng không
	boolean kiemTraDanhSachRong() {
		return dssv.isEmpty();
	}

	// 5. Xóa sinh viên dựa theo mã số sinh viên
	void xoaSinhVien(SinhVien sinhVienXoa) {
		for (SinhVien sinhVien : timKiemSinhVien(sinhVienXoa, 5)) {
			dssv.remove(sinhVien);
		}
	}

	// 6. In danh sách sinh viên dựa theo mã số cần tìm
	void inDanhSachSinhVienTimTheoMaSo(SinhVien sinhVienCanTim) {
		for (SinhVien sinhVien : timKiemSinhVien(sinhVienCanTim, 6)) {
			System.out.println(sinhVien);
		}
	}

	// 7. In danh sách sinh viên dựa theo tên nhập vào
	void inDanhSachTheoTen(String ten) {
		for (SinhVien sinhVien : dssv) {
			if (ten.compareTo(layTen(sinhVien)) == 0) {
				System.out.println(sinhVien);
			}
		}
	}

	// 8. Sắp xếp sinh viên dựa theo điểm từ thấp đến cao
	void sapXepSinhVienTheoDiem() {
		Collections.sort(dssv, new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				// TODO Auto-generated method stub
				if (o1.getDiem() > o2.getDiem()) {
					return 1; // Di chuyển xuống
				} else if (o1.getDiem() < o2.getDiem()) {
					return -1; // Di chuyển lên đầu
				} else {
					return 0;
				}
			}
		});
	}

	// 9. Sắp xếp sinh viên dựa theo tên
	void sapXepSinhVienTheoTen() {
		Collections.sort(dssv, new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				// TODO Auto-generated method stub
				String ten1 = layTen(o1);
				String ten2 = layTen(o2);
				if (ten1.compareTo(ten2) > 1) {
					return 1;
				} else if (ten1.compareTo(ten2) < 1) {
					return -1;
				} else {
					return 0;
				}
			}
		});
	}

	void sapXepSinhVienTheoHoTen() {
		sapXepSinhVienTheoTen();
	}

	// 10. In số lượng sinh viên
	int traVeSoLuongSinhVienTrongDanhSach() {
		return dssv.size();
	}

	// 11. Lưu thông tin của sinh viên vào file DanhSachSinhVien.data
	void luuThongTinSinhVien(File file) {
		try {
			OutputStream os = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			for (SinhVien sinhVien : dssv) {
				oos.writeObject(sinhVien);
			}
			oos.flush();
			oos.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// 12. Lấy thông tin của sinh viên từ file DanhSachSinhVien.data
	void layThongTinSinhVien(File file) {
		try {
			InputStream is = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(is);
			SinhVien sv = null;
			while (true) {
//				Method readObject() sau mỗi lần gọi sẽ lưu lại vị trí nó đọc đến trong stream
//ở lần gọi tiếp theo nó sẽ đọc đến byte kế tiếp kể từ vị trí đã được lưu từ lần trước
				Object oj = ois.readObject();
				sv = (SinhVien) oj;
				if (sv == null) {
					break;
				} else {
					dssv.add(sv);
				}
			}
			ois.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Đã lấy thông tin thành công!");
		}
	}
}
