package QuanLySinhVienGiaoDien.QuanLySinhVienModel;

import java.util.LinkedList;

public class DanhSachSinhVien {
	public LinkedList<SinhVien> dssv = new LinkedList<SinhVien>();
	public String luaChon = "", duongDan = "";

	public DanhSachSinhVien() {
	}

	public LinkedList<SinhVien> getDssv() {
		return dssv;
	}

	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	public void setDssv(LinkedList<SinhVien> dssv) {
		this.dssv = dssv;
	}

	public String getDuongDan() {
		return duongDan;
	}

	public void setDuongDan(String duongDan) {
		this.duongDan = duongDan;
	}

	public boolean kiemTraSinhVienCoTonTaiTrongDanhSach(SinhVien sinhVienKhac) {
		for (SinhVien sinhVien : dssv) {
			if (sinhVien.getMaSinhVien() == sinhVienKhac.getMaSinhVien()) {
				return true;
			}
		}
		return false;
	}

	public void themSinhVien(SinhVien sinhVien) {
		if (!this.dssv.contains(sinhVien)) {
			this.dssv.add(sinhVien);
		}
	}

	public void xoaSinhVien(SinhVien sv) {
		if (dssv.contains(sv)) {
			dssv.remove(sv);
		}
	}

	public void inDanhSachSinhVien() {
		for (SinhVien sinhVien : dssv) {
			System.out.println(sinhVien);
		}
	}

	public void capNhatSinhVien(SinhVien sv) {
		xoaSinhVien(sv);
		themSinhVien(sv);
	}

	public void xoaDuLieu() {
		this.dssv.clear();
	}
}
