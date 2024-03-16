package CaPhe;

class HoaDonCaPhe {
	private String tenLoaiCaPhe;
	private long gia, soTienGiam, tienDK;
	private double khoiLuong, phanTram;

	public HoaDonCaPhe(String tenLoaiCaPhe, long gia, double khoiLuong) {
		this.tenLoaiCaPhe = tenLoaiCaPhe;
		this.gia = gia;
		this.khoiLuong = khoiLuong;
	}

	long tinhTongTienCuaHoaDon() {
		return (long) (this.gia * this.khoiLuong);
	}

	String inThongTin() {
		return "Tên loại cà phê là: " + tenLoaiCaPhe + "\nGiá: " + gia + "/1kg" + "\nKhối lượng mua: " + khoiLuong
				+ "kg";
	}

	boolean kiemTraHoaDonCoDuocGiamGia(long tien) {
		this.tienDK = tien;
		return tinhTongTienCuaHoaDon() > tien;
	}

	long tinhSoTienDuocGiam(double phanTram) {
		if (kiemTraHoaDonCoDuocGiamGia(tienDK)) {
			this.soTienGiam = (long) ((tinhTongTienCuaHoaDon() * phanTram) / 100);
			return this.soTienGiam;
		} else {
			return 0;
		}
	}

	long tinhTongTienSauGiam() {
		return tinhTongTienCuaHoaDon() - soTienGiam;
	}
}
