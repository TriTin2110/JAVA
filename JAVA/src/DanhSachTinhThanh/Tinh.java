package DanhSachTinhThanh;

import java.util.Objects;

class Tinh {
	private int maTinh;
	private String tenTinh;
	private long danSo;
	private double dienTich;

	public Tinh(int maTinh) {
		this.maTinh = maTinh;
	}

	public Tinh(int maTinh, String tenTinh, long danSo, double dienTich) {
		this.maTinh = maTinh;
		this.tenTinh = tenTinh;
		this.danSo = danSo;
		this.dienTich = dienTich;
	}

	int getMaTinh() {
		return maTinh;
	}

	void setMaTinh(int maTinh) {
		this.maTinh = maTinh;
	}

	String getTenTinh() {
		return tenTinh;
	}

	void setTenTinh(String tenTinh) {
		this.tenTinh = tenTinh;
	}

	long getDanSo() {
		return danSo;
	}

	void setDanSo(long danSo) {
		this.danSo = danSo;
	}

	double getDienTich() {
		return dienTich;
	}

	void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maTinh);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tinh other = (Tinh) obj;
		return maTinh == other.maTinh;
	}

	@Override
	public String toString() {
		return "Tinh [maTinh=" + maTinh + ", tenTinh=" + tenTinh + ", danSo=" + danSo + ", dienTich=" + dienTich + "]";
	}

}
