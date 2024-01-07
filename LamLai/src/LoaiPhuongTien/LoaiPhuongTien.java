package LoaiPhuongTien;

class LoaiPhuongTien {
	private NgaySanXuat ngay;
	private HangSanXuat hang;
	private String loaiNhienLieu;
	private double vanToc;

	public LoaiPhuongTien(NgaySanXuat ngay, HangSanXuat hang, String loaiNhienLieu) {
		this.ngay = ngay;
		this.hang = hang;
		this.loaiNhienLieu = loaiNhienLieu;
	}

	NgaySanXuat getNgay() {
		return ngay;
	}

	void setNgay(NgaySanXuat ngay) {
		this.ngay = ngay;
	}

	HangSanXuat getHang() {
		return hang;
	}

	void setHang(HangSanXuat hang) {
		this.hang = hang;
	}

	String getLoaiNhienLieu() {
		return loaiNhienLieu;
	}

	void setLoaiNhienLieu(String loaiNhienLieu) {
		this.loaiNhienLieu = loaiNhienLieu;
	}

	double tinhVanToc(double vanToc) {
		this.vanToc = vanToc;
		return vanToc;
	}

	void inThongTin() {
		System.out.println("Thông tin của loại phương tiện là:");
		System.out.println("Hãng sản xuất: " + hang.getTenHang());
		System.out.println("Quốc gia: " + hang.getQuocGia());
		System.out.println("Ngày sản xuất: " + ngay.getNgaySX());
		System.out.println("Loại nhiên liệu: " + this.loaiNhienLieu);
		System.out.println("Vận tốc: " + this.tinhVanToc(this.vanToc) + " km/h");
	}
}
