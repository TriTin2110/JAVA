package File;

import java.io.Serializable;
import java.util.Objects;

class SinhVien implements Serializable {
	private int maSinhVien, namNhapHoc;
	private String hoTen;
	private float diem;

	public SinhVien(int maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public SinhVien(int maSinhVien, int namNhapHoc, String hoTen, float diem) {
		this.maSinhVien = maSinhVien;
		this.namNhapHoc = namNhapHoc;
		this.hoTen = hoTen;
		this.diem = diem;
	}

	int getMaSinhVien() {
		return maSinhVien;
	}

	void setMaSinhVien(int maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	int getNamNhapHoc() {
		return namNhapHoc;
	}

	void setNamNhapHoc(int namNhapHoc) {
		this.namNhapHoc = namNhapHoc;
	}

	String getHoTen() {
		return hoTen;
	}

	void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	float getDiem() {
		return diem;
	}

	void setDiem(float diem) {
		this.diem = diem;
	}

	@Override
	public String toString() {
		return "SinhVien [maSinhVien=" + maSinhVien + ", namNhapHoc=" + namNhapHoc + ", hoTen=" + hoTen + ", diem="
				+ diem + "]";
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

}
