package NganHang;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

class Account {
	private long soTaiKhoan;
	private String tenTaiKhoan;
	private double soTienTaiKhoan, laiSuat = 0.035;

	public Account(long soTaiKhoan) {
		this.soTaiKhoan = soTaiKhoan;
	}

	public Account(long soTaiKhoan, String tenTaiKhoan) {
		super();
		this.soTaiKhoan = soTaiKhoan;
		this.tenTaiKhoan = tenTaiKhoan;
		this.soTienTaiKhoan = 50000;
	}

	long getSoTaiKhoan() {
		return soTaiKhoan;
	}

	void setSoTaiKhoan(long soTaiKhoan) {
		this.soTaiKhoan = soTaiKhoan;
	}

	String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	double getSoTienTaiKhoan() {
		return soTienTaiKhoan;
	}

	void setSoTienTaiKhoan(double soTienTaiKhoan) {
		this.soTienTaiKhoan = soTienTaiKhoan;
	}

	double getLaiSuat() {
		return laiSuat;
	}

	void setLaiSuat(double laiSuat) {
		this.laiSuat = laiSuat;
	}

	@Override
	public int hashCode() {
		return Objects.hash(soTaiKhoan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return soTaiKhoan == other.soTaiKhoan;
	}

	@Override
	public String toString() {
		Locale lo = new Locale("vi", "vn");
		NumberFormat nf = NumberFormat.getCurrencyInstance(lo);
		return "Account [soTaiKhoan=" + soTaiKhoan + ", tenTaiKhoan=" + tenTaiKhoan + ", soTienTaiKhoan="
				+ nf.format(soTienTaiKhoan) + "]";
	}

}
