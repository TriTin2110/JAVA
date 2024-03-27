package LoaiPhuongTien;

abstract class LoaiPhuongTien {
	protected NgaySanXuat ngay;
	protected HangSanXuat hsx;
	protected String tenPhuongTien;

	public LoaiPhuongTien(NgaySanXuat ngay, HangSanXuat hsx, String tenPhuongTien) {
		this.ngay = ngay;
		this.hsx = hsx;
		this.tenPhuongTien = tenPhuongTien;
	}

	String getTenPhuongTien() {
		return tenPhuongTien;
	}

	void setTenPhuongTien(String tenPhuongTien) {
		this.tenPhuongTien = tenPhuongTien;
	}

	abstract double tinhVanToc(double vanToc);

	abstract String inThongTin();
}
