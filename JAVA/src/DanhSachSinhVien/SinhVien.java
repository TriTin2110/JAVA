package DanhSachSinhVien;

import java.util.Objects;

class SinhVien {
	private String MSSV, hoVaTen;
	private int namSinh;
	private float diem;

	public SinhVien(String mSSV, String hoVaTen, int namSinh, float diem) {
		MSSV = mSSV;
		this.hoVaTen = hoVaTen;
		this.namSinh = namSinh;
		this.diem = diem;
	}

	public SinhVien(String mSSV) {
		MSSV = mSSV;
	}

	String getMSSV() {
		return MSSV;
	}

	void setMSSV(String mSSV) {
		MSSV = mSSV;
	}

	String getHoVaTen() {
		return hoVaTen;
	}

	void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	int getNamSinh() {
		return namSinh;
	}

	void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	float getDiem() {
		return diem;
	}

	void setDiem(float diem) {
		this.diem = diem;
	}

	@Override
	public String toString() {
		return "SinhVien [MSSV=" + MSSV + ", hoVaTen=" + hoVaTen + ", namSinh=" + namSinh + ", diem=" + diem + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(MSSV);
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
		return Objects.equals(MSSV, other.MSSV);
	}
}
