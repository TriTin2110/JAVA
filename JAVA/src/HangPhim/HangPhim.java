package HangPhim;

class HangPhim {
	NgayChieu ngayChieu;
	HangSanXuat hangSanXuat;
	String tenPhim;
	long giaVe;
	int namSanXuat;
	int soLuongVe;

	HangPhim(NgayChieu ngayChieu, HangSanXuat hangSanXuat, String tenPhim, long giaVe, int namSanXuat, int soLuongVe) {
		this.ngayChieu = ngayChieu;
		this.hangSanXuat = hangSanXuat;
		this.tenPhim = tenPhim;
		this.giaVe = giaVe;
		this.namSanXuat = namSanXuat;
		this.soLuongVe = soLuongVe;
	}

	String inThongTin() {
		return tenPhim + "\n" + hangSanXuat.getTenHang() + "\n" + hangSanXuat.getQuocGia() + "\n" + ngayChieu.toString()
				+ "\n" + giaVe + "\n" + namSanXuat + "\n" + soLuongVe;
	}

	boolean kiemTraCungNamSanXuat(HangPhim hangKhac) {
		return namSanXuat == hangKhac.namSanXuat;
	}

	long tinhTongTien() {
		return soLuongVe * giaVe;
	}

	long tinhTongTienSauKhiGiam(double phanTram) {
		return (long) Math.round(tinhTongTien() * ((100 - phanTram) / 100));
	}
}
