package CaPhe;

class HoaDon {
	private String tenCaPhe;
	private double gia, khoiLuong, giamGia, phanTram;

	HoaDon(String tenCaPhe, double gia, double khoiLuong) {
		this.tenCaPhe = tenCaPhe;
		this.gia = gia;
		this.khoiLuong = khoiLuong;
	}

	String getTenCaPhe() {
		return tenCaPhe;
	}

	void setTenCaPhe(String tenCaPhe) {
		this.tenCaPhe = tenCaPhe;
	}

	double getGia() {
		return gia;
	}

	void setGia(double gia) {
		this.gia = gia;
	}

	double getKhoiLuong() {
		return khoiLuong;
	}

	void setKhoiLuong(double khoiLuong) {
		this.khoiLuong = khoiLuong;
	}

	String inThongTin() {
		return "Tên của loại cà phê là: " + tenCaPhe + "\nGiá của loại cà phê là: " + gia + "/1kg"
				+ "\nKhối lượng của loại cà phê là: " + khoiLuong;
	}

	boolean kiemTraKhoiLuong(double tonKho) {
		return khoiLuong > tonKho;
	}

	long tinhTongTienHoaDon() {
		return (long) Math.round(gia * khoiLuong);
	}

	boolean kiemTraHoaDonCoDuocGiam(double giamGia) {
		this.giamGia = giamGia;
		return (tinhTongTienHoaDon() > giamGia);
	}

	long tinhSoTienGiam(double phanTram) {
		this.phanTram = phanTram;
		return (long) Math.round((kiemTraHoaDonCoDuocGiam(giamGia)) ? ((tinhTongTienHoaDon() * phanTram) / 100) : 0);
	}

	long tinhTongTienSauKhiGiam() {
		return tinhTongTienHoaDon() - tinhSoTienGiam(phanTram);
	}
}
