package HangPhim;

import java.text.NumberFormat;
import java.util.Locale;

class Phim {
	private NgayChieu ngayChieu;
	private HangPhim hangPhim;
	private String tenPhim;
	private long giaVe;
	private int soLuongVe;

	public Phim(NgayChieu ngayChieu, HangPhim hangPhim, String tenPhim, long giaVe, int soLuongVe) {
		this.ngayChieu = ngayChieu;
		this.hangPhim = hangPhim;
		this.tenPhim = tenPhim;
		this.giaVe = giaVe;
		this.soLuongVe = soLuongVe;
	}

	String getTenPhim() {
		return tenPhim;
	}

	void setTenPhim(String tenPhim) {
		this.tenPhim = tenPhim;
	}

	long getGiaVe() {
		return giaVe;
	}

	void setGiaVe(long giaVe) {
		this.giaVe = giaVe;
	}

	long tinhTongTien() {
		return this.giaVe * this.soLuongVe;
	}

	void inThongTinVe() {
		long tongTien = this.tinhTongTien();
		Locale locate = new Locale("vi", "VN");
		NumberFormat num = NumberFormat.getCurrencyInstance(locate);
		if (kiemTraChuongTrinhKhuyenMai()) {
			tongTien = this.tinhTongTienSauGiamGia(10);
		}
		String giaVeToString = num.format(giaVe);
		String tongTienToString = num.format(tongTien);

		System.out.println("Thông tin của vé là:");
		System.out.println("Tên phim: " + this.tenPhim);
		System.out.println("Giá vé: " + giaVeToString);
		System.out.println("Số lượng vé: " + this.soLuongVe);
		System.out.println("Ngày chiếu: " + this.ngayChieu.getDate());
		System.out.println("Tổng tiền: " + tongTienToString);
		System.out.println("\n-------------------------------");
		this.inThongTinHangPhim();
	}

	void inThongTinHangPhim() {
		System.out.println("Hãng phim: " + this.hangPhim.getTenHangPhim());
		System.out.println("Quốc gia: " + this.hangPhim.getQuocGia());
	}

	boolean kiemTraChuongTrinhKhuyenMai() {
		if (this.soLuongVe > 5) {
			return true;
		} else {
			return false;
		}
	}

	long tinhTongTienSauGiamGia(double phanTram) {
		return (long) (this.tinhTongTien() * ((100 - phanTram) / 100));
	}
}
