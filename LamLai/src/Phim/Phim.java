package Phim;

class Phim {
	private NgayChieu ngayChieu;
	private HangPhim hangPhim;
	private String tenPhim;
	private double giaVe;
	private int namSanXuat, soLuongVe;

	public Phim(NgayChieu ngayChieu, HangPhim hangPhim, String tenPhim, double giaVe, int namSanXuat) {
		this.ngayChieu = ngayChieu;
		this.hangPhim = hangPhim;
		this.tenPhim = tenPhim;
		this.giaVe = giaVe;
		this.namSanXuat = namSanXuat;
	}

	String getTenPhim() {
		return tenPhim;
	}

	void setTenPhim(String tenPhim) {
		this.tenPhim = tenPhim;
	}

	double getGiaVe() {
		return giaVe;
	}

	void setGiaVe(double giaVe) {
		this.giaVe = giaVe;
	}

	int getNamSanXuat() {
		return namSanXuat;
	}

	void setNamSanXuat(int namSanXuat) {
		this.namSanXuat = namSanXuat;
	}

	public String inThongTin() {
		return "Phim: " + tenPhim + "\nHãng phim :" + hangPhim.getTenHang() + "\nQuốc gia : " + hangPhim.getQuocGia()
				+ "\nGiá vé: " + giaVe + "\nNăm sản xuất " + namSanXuat + "\nNgày chiếu " + ngayChieu.toString();
	}

	public double tinhTien(int soLuongVe) {
		this.soLuongVe = soLuongVe;
		return this.giaVe * soLuongVe;
	}

	public double tinhTongTien(double giamGia) {
		return tinhTien(soLuongVe) * ((100 - giamGia) / 100);
	}
}
