package HoaDonCaPhe;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

class CaPhe implements Serializable {
	private String tenCaPhe;
	private long giaCaPhe, soTienDuocGiam;
	private double khoiLuongMua;

	public CaPhe(String tenCaPhe, long giaCaPhe, double khoiLuongMua) {
		this.tenCaPhe = tenCaPhe;
		this.giaCaPhe = giaCaPhe;
		this.khoiLuongMua = khoiLuongMua;
		tinhTongTienHoaDon();
		tinhSoTienDuocGiam();
		tinhTongTienSauKhiGiam();
	}

	String getTenCaPhe() {
		return tenCaPhe;
	}

	void setTenCaPhe(String tenCaPhe) {
		this.tenCaPhe = tenCaPhe;
	}

	long getGiaCaPhe() {
		return giaCaPhe;
	}

	void setGiaCaPhe(long giaCaPhe) {
		this.giaCaPhe = giaCaPhe;
	}

	long getSoTienDuocGiam() {
		return soTienDuocGiam;
	}

	void setSoTienDuocGiam(long soTienDuocGiam) {
		this.soTienDuocGiam = soTienDuocGiam;
	}

	double getKhoiLuongMua() {
		return khoiLuongMua;
	}

	void setKhoiLuongMua(double khoiLuongMua) {
		this.khoiLuongMua = khoiLuongMua;
	}

	public long tinhTongTienHoaDon() {
		return (long) Math.round(this.giaCaPhe * this.khoiLuongMua);
	}

	@Override
	public String toString() {
		Locale lo = new Locale("vi", "VN");
		NumberFormat nf = NumberFormat.getCurrencyInstance(lo);
		String tongTien = nf.format(tinhTongTienHoaDon());
		String soTienGiam = nf.format(tinhSoTienDuocGiam());
		String tongTienSauGiam = nf.format(tinhTongTienSauKhiGiam());

		return "\nTên cà phê: " + tenCaPhe + "\nGiá cà phê: " + nf.format(giaCaPhe) + "\nKhối lượng mua: "
				+ khoiLuongMua + "\\nTổng tiền của hóa đơn: " + tongTien + "\nSố tiền được giảm" + soTienGiam
				+ "\nTổng tiền của hóa đơn sau giảm: " + tongTienSauGiam;
	}

	public long tinhSoTienDuocGiam() {
		double phanTram = 0;
		if (this.khoiLuongMua < 5) {
			phanTram = 0;
		} else if (this.khoiLuongMua < 10) {
			phanTram = 0.1;
		} else if (this.khoiLuongMua < 15) {
			phanTram = 0.25;
		} else {
			phanTram = 0.5;
		}
		return (long) Math.round(tinhTongTienHoaDon() * phanTram);
	}

	public double tinhTongTienSauKhiGiam() {
		return this.tinhTongTienHoaDon() - this.tinhSoTienDuocGiam();
	}
}
