package QuanLySinhVienGiaoDien.QuanLySinhVienModel;

import java.io.Serializable;
import java.util.Objects;

public class SinhVien implements Serializable {
	private String tenSinhVien, ngaySinh;
	private int maSinhVien;
	private boolean gioiTinh;
	private float diem1, diem2, diem3;
	QueQuan queQuan;

	public SinhVien() {
	}

	public SinhVien(int maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public SinhVien(String tenSinhVien, String ngaySinh, int maSinhVien, boolean gioiTinh, float diem1, float diem2,
			float diem3, QueQuan queQuan) {
		this.tenSinhVien = tenSinhVien;
		this.ngaySinh = ngaySinh;
		this.maSinhVien = maSinhVien;
		this.gioiTinh = gioiTinh;
		this.diem1 = diem1;
		this.diem2 = diem2;
		this.diem3 = diem3;
		this.queQuan = queQuan;
	}

	public String getTenSinhVien() {
		return tenSinhVien;
	}

	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public int getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(int maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public float getDiem1() {
		return diem1;
	}

	public void setDiem1(float diem1) {
		this.diem1 = diem1;
	}

	public float getDiem2() {
		return diem2;
	}

	public void setDiem2(float diem2) {
		this.diem2 = diem2;
	}

	public float getDiem3() {
		return diem3;
	}

	public void setDiem3(float diem3) {
		this.diem3 = diem3;
	}

	public QueQuan getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(QueQuan queQuan) {
		this.queQuan = queQuan;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maSinhVien);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinhVien other = (SinhVien) obj;
		return maSinhVien == other.maSinhVien;
	}

	@Override
	public String toString() {
		return "SinhVien [tenSinhVien=" + tenSinhVien + ", ngaySinh=" + ngaySinh + ", maSinhVien=" + maSinhVien
				+ ", gioiTinh=" + gioiTinh + ", diem1=" + diem1 + ", diem2=" + diem2 + ", diem3=" + diem3 + ", queQuan="
				+ queQuan.getTenTinhThanh() + "]";
	}

}
