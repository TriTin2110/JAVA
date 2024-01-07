package DanhSachSinhVien;

import java.util.Objects;

class SinhVien {
	private String MSSV, tenSinhVien;
	private double diemGPA;

	public SinhVien(String mSSV) {
		MSSV = mSSV;
	}

	public SinhVien(String mSSV, String tenSinhVien, double diemGPA) {
		MSSV = mSSV;
		this.tenSinhVien = tenSinhVien;
		this.diemGPA = diemGPA;
	}

	String getMSSV() {
		return MSSV;
	}

	void setMSSV(String mSSV) {
		MSSV = mSSV;
	}

	String getTenSinhVien() {
		return tenSinhVien;
	}

	void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}

	double getDiemGPA() {
		return diemGPA;
	}

	void setDiemGPA(double diemGPA) {
		this.diemGPA = diemGPA;
	}

	@Override
	public String toString() {
		return "SinhVien [MSSV=" + MSSV + ", tenSinhVien=" + tenSinhVien + ", diemGPA=" + diemGPA + "]";
	}

	String getTen() {
		return getTenSinhVien().substring(getTenSinhVien().lastIndexOf(" ") + 1);
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
